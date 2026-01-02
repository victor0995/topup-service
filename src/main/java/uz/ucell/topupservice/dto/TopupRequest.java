package uz.ucell.topupservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.ucell.topupservice.dto.deserializer.DoubleDeserializer;
import uz.ucell.topupservice.dto.deserializer.InstantDeserializer;
import uz.ucell.topupservice.dto.deserializer.IntegerDeserializer;

import java.io.Serializable;
import java.time.Instant;

/*

TODO конвертеры напиши вместо int используй класс Integer.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopupRequest implements Serializable {

    @JsonProperty("P_MSISDN")
    String msisdn;

    @JsonProperty("P_RECEIPT_NUM")
    String receiptNum;

    @JsonProperty("P_ACCOUNT")
    String account;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonProperty("P_PAY_AMOUNT")
    Integer payAmount;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonProperty("P_PAY_AMOUNT_CURR")
    Integer payAmountCurr;

    @JsonProperty("P_PAY_CURR")
    String payCurr;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonProperty("P_RATE_EXCH")
    Integer rateExch;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("P_DATE")
    Instant date;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("P_DATE2")
    Instant date2;

    @JsonProperty("P_PAY_TYPE")
    String payType;

    @JsonProperty("P_WARRANTOR")
    String warrantor;

    @JsonProperty("P_COMMENT")
    String comment;

    @JsonProperty("P_SALE_POINT")
    String salePoint;

    @JsonProperty("P_AGENT_CODE")
    String agentCode;

    @JsonProperty("P_TERMINAL")
    String terminal;

    @JsonProperty("P_ADDINFO3")
    String addinfo3;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonProperty("P_RESELLER_ID")
    Integer resellerId;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("P_MESSAGE_DATE")
    Instant messageDate;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("V_EVENT_TIME")
    Instant eventTime;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonProperty("V_REQUEST_TIMEOUT")
    Integer requestTimeout;

    @JsonDeserialize(using = DoubleDeserializer.class)
    @JsonProperty("P_PAY_VAT")
    Double payVat;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonProperty("P_BIS_BALANCE")
    Integer bisBalance;
}
