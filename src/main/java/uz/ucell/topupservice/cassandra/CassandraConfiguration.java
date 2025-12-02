package uz.ucell.topupservice.cassandra;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Objects;

@RequiredArgsConstructor
@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    private final CassandraProperties properties;

    @Override
    public String getKeyspaceName() {
        return properties.getKeyspace();
    }

    @Override
    public String getContactPoints() {
        return properties.getContactPoints();
    }

    @Override
    public int getPort() {
        return properties.getPort();
    }

    @Override
    protected String getLocalDataCenter() {
        return properties.getDc();
    }

    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints(getContactPoints());
        session.setKeyspaceName(getKeyspaceName());
        session.setPort(getPort());
        session.setLocalDatacenter(getLocalDataCenter());
        session.setUsername(properties.getUsername());
        session.setPassword(properties.getPassword());
        return session;
    }

    @Bean
    public CqlSessionBuilderCustomizer cqlSessionBuilderCustomizer() {
        return builder -> builder
                .withKeyspace(getKeyspaceName())
                .withLocalDatacenter(Objects.requireNonNull(getLocalDataCenter()));
    }
}