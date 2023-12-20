package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.CardInfo;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;

import java.lang.reflect.Type;
import java.util.Map;

public class RecurringPayInMIT extends Dto {

    @SerializedName("RecurringPayinRegistrationId")
    private String recurringPayInRegistrationId;

    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    @SerializedName("Fees")
    private Money fees;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Tag")
    private String tag;

    @SerializedName("CardInfo")
    private CardInfo cardInfo;

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getRecurringPayInRegistrationId() {
        return recurringPayInRegistrationId;
    }

    public void setRecurringPayInRegistrationId(String recurringPayInRegistrationId) {
        this.recurringPayInRegistrationId = recurringPayInRegistrationId;
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

        result.put("Money", Money.class);

        return result;
    }
}
