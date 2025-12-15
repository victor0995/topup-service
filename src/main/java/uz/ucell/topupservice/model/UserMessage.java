package uz.ucell.topupservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user_messages")
public class UserMessage {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, name = "request_id")
    private UUID requestId;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "cp_id",ordinal = 1)
    private String cpId;

    @Column("msisdn")
    private String msisdn;

    @Column("serviceid")
    private Long serviceId;

    @Column("status")
    private Integer status;

    @Column
    @CreatedDate
    private Instant created;
}
