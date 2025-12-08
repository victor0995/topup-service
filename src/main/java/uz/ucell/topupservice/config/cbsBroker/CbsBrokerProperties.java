package uz.ucell.topupservice.config.cbsBroker;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "cbs.broker")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CbsBrokerProperties {

//    @Value("${CBS_BROKER_URL}")
//    private String cbsBrokerUrl;
//
//    @Value("${CBS_BROKER_USER}")
//    private String cbsBrokerUser;
//
//    @Value("${CBS_BROKER_PASSWORD}")
//    private String cbsBrokerPassword;
//
//    @Value("${CBS_BROKER_EXCHANGETYPE}")
//    private String cbsBrokerExchangeType;
//
//    @Value("${CBS_BROKER_EXCHANGE-TYPE}")
//    private String cbsBrokerExchangeTypeAlternative;

    @Value("${KEY:}")
    private String cbsBrokerUrl;

    @Value("${KEY:}")
    private String cbsBrokerUser;

    @Value("${KEY:}")
    private String cbsBrokerPassword;

    @Value("${KEY:}")
    private String cbsBrokerExchangeType;

    @Value("${KEY:}")
    private String cbsBrokerExchangeTypeAlternative;
}
