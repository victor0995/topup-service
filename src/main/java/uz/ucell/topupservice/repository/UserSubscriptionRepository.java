package uz.ucell.topupservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import uz.ucell.topupservice.model.UserSubscription;

import java.util.List;

@Repository
public interface UserSubscriptionRepository extends CassandraRepository<UserSubscription, String> {

    List<UserSubscription> findByMsisdn(String msisdn);
    List<UserSubscription> findAllByCpId(String cpId);
    void deleteByMsisdn(String msisdn);
}