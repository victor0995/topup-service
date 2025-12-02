package uz.ucell.topupservice.cassandra;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(value = "spring.data.cassandra")
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CassandraProperties {
    String keyspace;

    String contactPoints;

    Integer port;

    String username;

    String password;

    String dc;
}
