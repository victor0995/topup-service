package uz.ucell.topupservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table("user_prolongation")
public class UserProlongation implements Serializable {

    public UserProlongation(String msisdn, Long serviceId) {
        this.msisdn = msisdn;
        this.serviceId = serviceId;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,name = "msisdn",ordinal = 0)
    private String msisdn;


    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "content_provider_id",ordinal = 1)
    private Long serviceId;

    @Column("created_date")
    private LocalDateTime createdDate;


}
