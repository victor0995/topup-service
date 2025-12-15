package uz.ucell.topupservice.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.ucell.topupservice.cassandra.CassandraProperties;
import uz.ucell.topupservice.mq.RabbitMQProperties;


@Slf4j
@Component
@RequiredArgsConstructor
public class TopupConfig {

    private final CassandraProperties cassandraProperties;
    private final RabbitMQProperties rabbitMQProperties;


    @PostConstruct
    public void logConfig() {
        log.info("==== Topup service configuration ====");
        log.info("Cassandra: contactPoints={}, port={}, username={}, keyspace={}, dc={}",
                cassandraProperties.getContactPoints(),
                cassandraProperties.getPort(),
                cassandraProperties.getUsername(),
                cassandraProperties.getKeyspace(),
                cassandraProperties.getDc()
        );
        log.debug("Cassandra password: {}", mask(cassandraProperties.getPassword()));
        log.info("RabbitMQ: host={}, port={}, username={}, exchange={}, queueTermination={}, routingKeyTermination={}",
                rabbitMQProperties.getHost(),
                rabbitMQProperties.getPort(),
                rabbitMQProperties.getUsername(),
                rabbitMQProperties.getExchangeName(),
                rabbitMQProperties.getQueueTopup(),
                rabbitMQProperties.getRoutingKeyTopup()
        );
        log.debug("RabbitMQ password: {}", mask(rabbitMQProperties.getPassword()));
    }

    private String mask(String value) {
        if (value == null || value.isEmpty()) {
            return "<empty>";
        }
        return "***masked***";
    }
}