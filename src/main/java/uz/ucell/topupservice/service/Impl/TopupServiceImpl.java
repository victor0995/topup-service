package uz.ucell.topupservice.service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.ucell.topupservice.dto.TopupRequest;
import uz.ucell.topupservice.model.UserProlongation;
import uz.ucell.topupservice.repository.UserProlongationRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopupServiceImpl implements uz.ucell.topupservice.service.TopupService {
    private final UserProlongationRepository userProlongationRepository;

    public void topup(TopupRequest topupRequest) {

        log.info("Topup request: " + topupRequest);
        List<UserProlongation> userProlongations = userProlongationRepository.findAll();
        userProlongations.stream().filter(userProlongation -> userProlongation.getServiceId()> 1L).count();
    }


}