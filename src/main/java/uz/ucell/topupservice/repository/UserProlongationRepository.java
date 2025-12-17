package uz.ucell.topupservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import uz.ucell.topupservice.model.UserProlongation;

import java.util.List;
import java.util.Optional;

public interface UserProlongationRepository extends CassandraRepository<UserProlongation, String> {

    List<UserProlongation> findByMsisdn(String msisdn);



    Optional<UserProlongation> findByMsisdnAndServiceId(String msisdn, Long serviceId);
}
