package uz.ucell.topupservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TopupConfig {

    @Value("${SPRING_DATA_CASSANDRA_CONTACTPOINTS}")
    private String cassandraContactPoints;

    @Value("${SPRING_DATA_CASSANDRA_PORT}")
    private String cassandraPort;

    @Value("${SPRING_DATA_CASSANDRA_USERNAME}")
    private String cassandraUsername;

    @Value("${SPRING_DATA_CASSANDRA_PASSWORD}")
    private String cassandraPassword;

    @Value("${SPRING_DATA_CASSANDRA_KEYSPACE}")
    private String cassandraKeyspace;

    @Value("${SPRING_DATA_CASSANDRA_DC}")
    private String cassandraDc;

    @Value("${SPRING_DATA_CASSANDRA_REPLICATION}")
    private String cassandraReplication;

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

    @Value("${logging.file.name}")
    private String logFileName;

    @Value("${logging.pattern.console}")
    private String logPatternConsole;

    @Value("${logging.pattern.file}")
    private String logPatternFile;

    @Value("${logging.level.org.springframework.web}")
    private String logLevelSpringWeb;

    @Value("${logging.level.uz.coscom.topup}")
    private String logLevelTopup;

    @PostConstruct
    public void printConfig() {
        System.out.println("Cassandra Contact Points: " + cassandraContactPoints);
        System.out.println("Cassandra Port: " + cassandraPort);
        System.out.println("Cassandra Username: " + cassandraUsername);
        System.out.println("Cassandra Password: " + cassandraPassword);
        System.out.println("Cassandra Keyspace: " + cassandraKeyspace);
        System.out.println("Cassandra DC: " + cassandraDc);
        System.out.println("Cassandra Replication: " + cassandraReplication);

        System.out.println("RabbitMQ Host: " + rabbitMqHost);
        System.out.println("RabbitMQ Port: " + rabbitMqPort);
        System.out.println("RabbitMQ Username: " + rabbitMqUsername);
        System.out.println("RabbitMQ Password: " + rabbitMqPassword);
        System.out.println("RabbitMQ Exchange Name: " + rabbitMqExchangeName);
        System.out.println("RabbitMQ Queue Termination: " + rabbitMqQueueTermination);
        System.out.println("RabbitMQ Routing Key Termination: " + rabbitMqRoutingKeyTermination);

        System.out.println("CBS Broker URL: " + cbsBrokerUrl);
        System.out.println("CBS Broker User: " + cbsBrokerUser);
        System.out.println("CBS Broker Password: " + cbsBrokerPassword);
        System.out.println("CBS Broker Exchange Type: " + cbsBrokerExchangeType);
        System.out.println("CBS Broker Exchange Type Alternative: " + cbsBrokerExchangeTypeAlternative);

        System.out.println("Log File Name: " + logFileName);
        System.out.println("Log Pattern Console: " + logPatternConsole);
        System.out.println("Log Pattern File: " + logPatternFile);
        System.out.println("Log Level Spring Web: " + logLevelSpringWeb);
        System.out.println("Log Level Termination: " + logLevelTopup);
    }
}