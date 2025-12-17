package uz.ucell.topupservice.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import uz.ucell.topupservice.dto.TopupRequest;
import uz.ucell.topupservice.model.*;
import uz.ucell.topupservice.repository.CpRepository;
import uz.ucell.topupservice.repository.UserMessagesRepository;
import uz.ucell.topupservice.repository.UserProlongationRepository;
import uz.ucell.topupservice.repository.UserSubscriptionRepository;
import uz.ucell.topupservice.service.QuietTimeService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopupServiceImpl implements uz.ucell.topupservice.service.TopupService {
    private final JmsTemplate jmsTemplate;
    private final UserProlongationRepository userProlongationRepository;
    private final UserSubscriptionRepository userSubscriptionRepository;
    private final UserMessagesRepository userMessagesRepository;
    private final CpRepository cpRepository;
    private final ObjectMapper objectMapper;
    private final QuietTimeService quietTimeService;
    static final ZoneId TASHKENT_ZONE = ZoneId.of("Asia/Tashkent");


    @Override
    public void topup(TopupRequest request) {

        if (request.getMsisdn() == null) {
            log.info("Topup request without msisdn: {}", request);
            return;
        }
        log.info("Start TOPUP for msisdn={} request={}", request.getMsisdn(), request);

        if (quietTimeService.isQuietTime()) {
            log.info("Skip topup for msisdn={} (23:00-04:00)", request.getMsisdn());
            return;
        }

        LocalDate today = LocalDate.now(TASHKENT_ZONE);

        List<UserSubscription> subscriptions = userSubscriptionRepository.findByMsisdn(request.getMsisdn());
        if (subscriptions.isEmpty()) {
            log.info("No subscriptions for msisdn={}", request.getMsisdn());
            return;
        }

        List<UserSubscription> activeSubs = subscriptions.stream()
                .filter(sub -> sub.getTypeId() != null && ( sub.getTypeId() == 1 || sub.getTypeId() == 11))
                .toList();

        if (activeSubs.isEmpty()) {
            log.info("No ACTIVE subscriptions for msisdn={}", request.getMsisdn());
            return;
        }

        List<UserProlongation> prolongations = userProlongationRepository.findByMsisdn(request.getMsisdn());
        log.info("Total prolongations={}", prolongations);

        for (UserSubscription sub : activeSubs) {

            Long serviceId = sub.getServiceId();
            log.info("serviceId={}", serviceId);
            if (serviceId == null) {
                log.info("Subscription without serviceId: msisdn={}, sub={}", request.getMsisdn(), sub);
                continue;
            }
            log.info("Process subscription: msisdn={}, serviceId={}", request.getMsisdn(), serviceId);
            UserProlongation up = prolongations.stream().filter(p -> p.getServiceId().equals(serviceId)).findFirst().orElse(null);
            log.info("Up={}", up);
            if (up != null && up.getCreatedDate() != null) {
                log.info("UserProlongation time {}",up.getCreatedDate() );
                LocalDate lastChargeDay = up.getCreatedDate()
                        .atZone(ZoneId.of("Asia/Tashkent"))
                        .toLocalDate();
                log.info("Last charge day={}", lastChargeDay);

                if (lastChargeDay.isEqual(today)) {
                    log.info(
                            "Already charged today: msisdn={}, serviceId={}",
                            request.getMsisdn(),
                            serviceId
                    );
                    continue;
                }
            }

            String cpId = sub.getCpId();
            String actionId = sub.getActionId();

            ContentProvider cp = cpRepository
                    .findByShortNumberAndActionId(cpId, actionId)
                    .orElse(null);

            if (cp == null) {
                log.warn("ContentProvider not found for msisdn={}, cpId={}, actionId={}",
                        request.getMsisdn(), cpId, actionId);
                continue;
            }

            Long amount = cp.getAmount();
            if (amount == null || amount <= 0) {
                log.warn("Invalid amount={} for msisdn={}, serviceId={}, cpId={}, actionId={}",
                        amount, request.getMsisdn(), serviceId, cpId, actionId);
                continue;
            }
            log.info("Amount cp {}", amount);
            try {
                ProlongationRequest prolongationRequest = new ProlongationRequest(
                        request.getMsisdn(),
                        cp.getServiceId().toString(),
                        UUID.randomUUID(),
                        amount
                );
                log.info("Prolongation request: {}", prolongationRequest);
                userMessagesRepository.save(new UserMessage(prolongationRequest.id(), cp.getShortNumber(), request.getMsisdn(), serviceId,0, Instant.now()));
                jmsTemplate.convertAndSend("topup-req", objectMapper.writeValueAsString(prolongationRequest));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        log.info("Finished TOPUP for msisdn={}", request.getMsisdn());
    }

    @Override
    public void updateTopup(MessageResponse message) {
        if(message.getStatus() == 1){

            UserMessage userMessage = userMessagesRepository.findAllByRequestId(UUID.fromString(message.getId()));
            log.info("userMessage {}", userMessage);
            Optional<UserProlongation> userProlongation = userProlongationRepository.findByMsisdnAndServiceId(userMessage.getMsisdn(), userMessage.getServiceId());
            if (userProlongation.isEmpty()) {
                log.warn("UserProlongation not found, msisdn={}, serviceId={}",
                        userMessage.getMsisdn(), userMessage.getServiceId());
                UserProlongation userProlong = new UserProlongation(userMessage.getMsisdn(),userMessage.getServiceId(),Instant.now());
                userProlongationRepository.save(userProlong);
                return;
            }
            UserProlongation userProlongationData = userProlongation.get();
            userProlongationData.setCreatedDate(Instant.now());
            userProlongationRepository.save(userProlongationData);
        }
    }


}


