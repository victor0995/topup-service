package uz.ucell.topupservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import uz.ucell.topupservice.model.ContentProvider;

import java.util.List;
import java.util.Optional;

@Repository
public interface CpRepository extends CassandraRepository<ContentProvider,String> {

    List<ContentProvider> findAllByShortNumber(String number);
    Optional<ContentProvider> findByShortNumberAndActionId(String shortNumber, String actionId);

}
