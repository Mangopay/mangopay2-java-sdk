package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;
import com.mangopay.entities.subentities.BrowserInfo;

import java.lang.reflect.Type;
import java.util.Map;

public class RecurringPayInCIT extends Dto {

    @SerializedName("RecurringPayinRegistrationId")
    private String recurringPayInRegistrationId;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    @SerializedName("IpAddress")
    private String ipAddress;

    @SerializedName("SecureModeReturnURL")
    private String secureModeReturnURL;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Tag")
    private String tag;

    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    @SerializedName("Fees")
    private Money fees;

    public String getRecurringPayInRegistrationId() {
        return recurringPayInRegistrationId;
    }

    public void setRecurringPayInRegistrationId(String recurringPayInRegistrationId) {
        this.recurringPayInRegistrationId = recurringPayInRegistrationId;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSecureModeReturnURL() {
        return secureModeReturnURL;
    }

    public void setSecureModeReturnURL(String secureModeReturnURL) {
        this.secureModeReturnURL = secureModeReturnURL;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Money getDebitedFunds() { return debitedFunds; }

    public void setDebitedFunds(Money debitedFunds) { this.debitedFunds = debitedFunds; }

    public Money getFees() { return fees; }

    public void setFees(Money fees) { this.fees = fees; }

    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("BrowserInfo", BrowserInfo.class);
        result.put("Money", Money.class);

        return result;
    }
}
