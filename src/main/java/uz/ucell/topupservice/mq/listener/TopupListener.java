package uz.ucell.topupservice.mq.listener;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uz.ucell.topupservice.dto.TopupRequest;

import uz.ucell.topupservice.service.Impl.TopupServiceImpl;


@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopupListener {

    TopupServiceImpl topupService;

    @RabbitListener(queues = "${RABBITMQ_QUEUE_TOPUP}")
    public void setTopupService(TopupRequest request) {
        topupService.topup(request);
    }
}