package uz.ucell.topupservice.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledListener {

    private static final LocalTime STOP_TIME = LocalTime.of(2, 0); // 2:00 AM
    private static final LocalTime START_TIME = LocalTime.of(6, 0); // 6:00 AM
    private final RabbitListenerEndpointRegistry registry;
    private final RabbitMQProperties rabbitMQProperties;

    @Scheduled(cron = "0 * * * * ?")
    public void controlListenerBasedOnTime() {
        LocalTime now = LocalTime.now();
        MessageListenerContainer container = registry.getListenerContainer(rabbitMQProperties.getListener());

        if (now.isAfter(STOP_TIME) && now.isBefore(START_TIME)) {
            if (container.isRunning()) {
                container.stop();
                System.out.println("Listener stopped at: " + now);
            }
        } else {
            if (!container.isRunning()) {
                container.start();
                System.out.println("Listener started at: " + now);
            }
        }
    }

}
