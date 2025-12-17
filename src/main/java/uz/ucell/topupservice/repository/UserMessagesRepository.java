package uz.ucell.topupservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import uz.ucell.topupservice.model.UserMessage;

import java.util.UUID;

@Repository
public interface UserMessagesRepository extends CassandraRepository<UserMessage, UUID> {

    UserMessage findAllByRequestId(UUID id);
}
