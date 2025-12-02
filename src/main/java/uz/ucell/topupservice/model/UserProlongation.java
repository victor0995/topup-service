package uz.ucell.topupservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table("user_prolongation")
public class UserProlongation implements Serializable {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,name = "msisdn",ordinal = 0)
    String msisdn;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "content_provider_id",ordinal = 1)
    Long serviceId;

    @Column("created_date")
    LocalDateTime createdDate;

}
