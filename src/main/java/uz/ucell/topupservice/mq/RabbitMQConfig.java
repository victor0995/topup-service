package uz.ucell.topupservice.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class RabbitMQConfig {
    private final RabbitMQProperties properties;

    @Bean
    public Queue terminationService() {
        return new Queue(properties.getQueueTermination(), false, false, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(properties.getExchangeName());
    }

    @Bean
    public Binding bindingTermination() {
        return BindingBuilder
                .bind(terminationService())
                .to(exchange())
                .with(properties.getRoutingKeyTermination());
    }


    @Bean

    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setVirtualHost(properties.getVirtualhost());
        connectionFactory.setAddresses(properties.getHost());
        connectionFactory.setPort(Integer.parseInt(properties.getPort()));
        connectionFactory.setUsername(properties.getUsername());
        connectionFactory.setPassword(properties.getPassword());
        return connectionFactory;
    }


}
