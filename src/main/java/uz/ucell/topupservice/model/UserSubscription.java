package uz.ucell.topupservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "user_subscription")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSubscription {
    @CassandraType(type = CassandraType.Name.SET, typeArguments = CassandraType.Name.UUID)
    private SortedSet<UUID> requestIds = new TreeSet<>(UserSubscription::compareTo);

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,name = "msisdn",ordinal = 0)
    private String msisdn;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "content_provider_id",ordinal = 2)
    private String cpId;

    private Long serviceId;

    private String actionId;

    private Integer state;

    private Integer typeId;

    @CreatedDate
    @Column("createddate")
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordinal = 3)
    private Instant createdDate;

    @Column("langid")
    private Integer langId;


    static int compareTo(UUID a, UUID b){
        return Long.compare(b.timestamp(),a.timestamp());
    }


}