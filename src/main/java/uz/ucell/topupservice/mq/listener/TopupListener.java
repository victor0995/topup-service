package uz.ucell.topupservice.mq.listener;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uz.ucell.topupservice.dto.TopupRequest;
import uz.ucell.topupservice.service.Impl.TopupService;


@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopupListener {
    TopupService topupService;

    @RabbitListener(queues = {"billing.charge.queue"})
    public void setTopupService(TopupRequest request) {
        topupService.topup(request);
    }
}