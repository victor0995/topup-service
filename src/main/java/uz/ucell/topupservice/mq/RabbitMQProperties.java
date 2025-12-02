package uz.ucell.topupservice.mq;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RabbitMQProperties {
    @Value("${RABBITMQ_HOST}")
    String host;
    @Value("${RABBITMQ_PORT}")
    String port;
    @Value("${RABBITMQ_VIRTUAL_HOST}")
    String virtualhost;

    @Value("${RABBITMQ_USERNAME}")
    String username;
    @Value("${RABBITMQ_PASSWORD}")
    String password;

    @Value("${RABBITMQ_EXCHANGE_NAME}")
    String exchangeName;
    @Value("${RABBITMQ_QUEUE_TERMINATION}")
    String queueTermination;
    @Value("${RABBITMQ_ROUTING_KEY_TERMINATION}")
    String routingKeyTermination;
}
