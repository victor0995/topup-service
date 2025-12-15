package uz.ucell.topupservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import uz.ucell.topupservice.model.UserProlongation;

import java.util.List;

public interface UserProlongationRepository extends CassandraRepository<UserProlongation, String> {

    List<UserProlongation> findByMsisdn(String msisdn);

    List<UserProlongation> findByMsisdnAndServiceId(String msisdn, Long serviceId);
}
