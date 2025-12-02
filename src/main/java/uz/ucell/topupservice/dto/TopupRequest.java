package uz.ucell.topupservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopupRequest implements Serializable {
    @JsonProperty("P_MSISDN")
    public String p_MSISDN;
    @JsonProperty("P_RECEIPT_NUM")
    public String p_RECEIPT_NUM;
    @JsonProperty("P_ACCOUNT")
    public String p_ACCOUNT;
    @JsonProperty("P_PAY_AMOUNT")
    public int p_PAY_AMOUNT;
    @JsonProperty("P_PAY_AMOUNT_CURR")
    public int p_PAY_AMOUNT_CURR;
    @JsonProperty("P_PAY_CURR")
    public String p_PAY_CURR;
    @JsonProperty("P_RATE_EXCH")
    public int p_RATE_EXCH;
    @JsonProperty("P_DATE")
    public Date p_DATE;
    @JsonProperty("P_DATE2")
    public Date p_DATE2;
    @JsonProperty("P_PAY_TYPE")
    public String p_PAY_TYPE;
    @JsonProperty("P_WARRANTOR")
    public String p_WARRANTOR;
    @JsonProperty("P_COMMENT")
    public String p_COMMENT;
    @JsonProperty("P_SALE_POINT")
    public String p_SALE_POINT;
    @JsonProperty("P_AGENT_CODE")
    public String p_AGENT_CODE;
    @JsonProperty("P_TERMINAL")
    public String p_TERMINAL;
    @JsonProperty("P_ADDINFO3")
    public String p_ADDINFO3;
    @JsonProperty("P_RESELLER_ID")
    public int p_RESELLER_ID;
    @JsonProperty("P_MESSAGE_DATE")
    public Date p_MESSAGE_DATE;
    @JsonProperty("V_EVENT_TIME")
    public Date v_EVENT_TIME;
    @JsonProperty("V_REQUEST_TIMEOUT")
    public int v_REQUEST_TIMEOUT;
    @JsonProperty("P_PAY_VAT")
    public double p_PAY_VAT;
    @JsonProperty("P_BIS_BALANCE")
    public int p_BIS_BALANCE;
}
