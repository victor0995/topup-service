package uz.ucell.topupservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

/*

TODO конвертеры напиши вместо int используй класс Integer.
 */
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopupRequest implements Serializable {
    @JsonProperty("P_MSISDN")
    String p_MSISDN;
    @JsonProperty("P_RECEIPT_NUM")
    String p_RECEIPT_NUM;
    @JsonProperty("P_ACCOUNT")
    String p_ACCOUNT;
    @JsonProperty("P_PAY_AMOUNT")
    int p_PAY_AMOUNT;
    @JsonProperty("P_PAY_AMOUNT_CURR")
    int p_PAY_AMOUNT_CURR;
    @JsonProperty("P_PAY_CURR")
    String p_PAY_CURR;
    @JsonProperty("P_RATE_EXCH")
    int p_RATE_EXCH;
    @JsonProperty("P_DATE")
    Date p_DATE;
    @JsonProperty("P_DATE2")
    Date p_DATE2;
    @JsonProperty("P_PAY_TYPE")
    String p_PAY_TYPE;
    @JsonProperty("P_WARRANTOR")
    String p_WARRANTOR;
    @JsonProperty("P_COMMENT")
    String p_COMMENT;
    @JsonProperty("P_SALE_POINT")
    String p_SALE_POINT;
    @JsonProperty("P_AGENT_CODE")
    String p_AGENT_CODE;
    @JsonProperty("P_TERMINAL")
    String p_TERMINAL;
    @JsonProperty("P_ADDINFO3")
    String p_ADDINFO3;
    @JsonProperty("P_RESELLER_ID")
    int p_RESELLER_ID;
    @JsonProperty("P_MESSAGE_DATE")
    Date p_MESSAGE_DATE;
    @JsonProperty("V_EVENT_TIME")
    Date v_EVENT_TIME;
    @JsonProperty("V_REQUEST_TIMEOUT")
    int v_REQUEST_TIMEOUT;
    @JsonProperty("P_PAY_VAT")
    double p_PAY_VAT;
    @JsonProperty("P_BIS_BALANCE")
    int p_BIS_BALANCE;
}
