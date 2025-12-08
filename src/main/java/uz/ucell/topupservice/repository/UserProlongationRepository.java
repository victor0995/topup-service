package uz.ucell.topupservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import uz.ucell.topupservice.model.UserProlongation;

import java.util.List;

public interface UserProlongationRepository extends CassandraRepository<UserProlongation, Long> {
    List<UserProlongation> findByServiceId(Long serviceId);
}
