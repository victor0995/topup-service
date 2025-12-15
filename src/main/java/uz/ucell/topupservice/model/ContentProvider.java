package uz.ucell.topupservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("content_provider")
public class ContentProvider implements Serializable {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,name = "short_number",ordinal = 0)
    private String shortNumber;

    @Column("name")
    private String name;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "action_id",ordinal = 1)
    private String actionId;

    @Column("rating_group")
    private Long ratingGroup;

    @Column("type_id")
    private Integer typeId;

    @Column("content_id")
    private Long contentId;

    @Column("external_type_id")
    private String billingTypeId;

    @Column("amount")
    private Long amount;

    @Column("provider_url")
    private String providerUrl;

    private Long billingContentId;

    private Long serviceId;
}
