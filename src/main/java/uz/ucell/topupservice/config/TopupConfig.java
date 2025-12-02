package uz.ucell.topupservice.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.ucell.topupservice.cassandra.CassandraProperties;

@Slf4j
@Component
@RequiredArgsConstructor
public class TopupConfig {

    private final CassandraProperties cassandraProperties;

    /**
     * TODO Исправь все эти переменные как в Cassandra Properties.
     */
    @Value("${RABBITMQ_HOST}")
    private String rabbitMqHost;

    @Value("${RABBITMQ_PORT}")
    private String rabbitMqPort;

    @Value("${RABBITMQ_USERNAME}")
    private String rabbitMqUsername;

    @Value("${RABBITMQ_PASSWORD}")
    private String rabbitMqPassword;

    @Value("${RABBITMQ_EXCHANGE_NAME}")
    private String rabbitMqExchangeName;

    @Value("${RABBITMQ_QUEUE_TERMINATION}")
    private String rabbitMqQueueTermination;

    @Value("${RABBITMQ_ROUTING_KEY_TERMINATION}")
    private String rabbitMqRoutingKeyTermination;

    @Value("${CBS_BROKER_URL}")
    private String cbsBrokerUrl;

    @Value("${CBS_BROKER_USER}")
    private String cbsBrokerUser;

    @Value("${CBS_BROKER_PASSWORD}")
    private String cbsBrokerPassword;

    @Value("${CBS_BROKER_EXCHANGETYPE}")
    private String cbsBrokerExchangeType;

    @Value("${CBS_BROKER_EXCHANGE-TYPE}")
    private String cbsBrokerExchangeTypeAlternative;


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
                rabbitMqHost,
                rabbitMqPort,
                rabbitMqUsername,
                rabbitMqExchangeName,
                rabbitMqQueueTermination,
                rabbitMqRoutingKeyTermination
        );
        log.debug("RabbitMQ password: {}", mask(rabbitMqPassword));
        log.info("CBS broker: url={}, user={}, exchangeType={}, exchangeTypeAlt={}",
                cbsBrokerUrl,
                cbsBrokerUser,
                cbsBrokerExchangeType,
                cbsBrokerExchangeTypeAlternative
        );
        log.debug("CBS broker password: {}", mask(cbsBrokerPassword));
    }

    private String mask(String value) {
        if (value == null || value.isEmpty()) {
            return "<empty>";
        }
        return "***masked***";
    }
}