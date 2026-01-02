package uz.ucell.topupservice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import uz.ucell.topupservice.dto.TopupRequest;

import uz.ucell.topupservice.model.MessageResponse;
import uz.ucell.topupservice.service.TopupService;


@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopupListener {

    TopupService topupService;
    ObjectMapper objectMapper;

    @RabbitListener(id = "${rabbitmq.listener}" ,queues = "${rabbitmq.queue}")
    public void setTopupService(TopupRequest request) {
        topupService.topup(request);
    }

    @SneakyThrows
    @JmsListener(destination = "topup-res")
    public void successSubscription(String subscriptionInfo)  {
        MessageResponse messageResponse = objectMapper.readValue(subscriptionInfo, MessageResponse.class);

        topupService.updateTopup(messageResponse);
    }
}