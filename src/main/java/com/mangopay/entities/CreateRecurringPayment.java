package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.*;

import java.lang.reflect.Type;
import java.util.Map;

public class CreateRecurringPayment extends Dto {

    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("CardId")
    private String cardId;

    @SerializedName("CreditedUserId")
    private String creditedUserId;

    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    @SerializedName("FirstTransactionDebitedFunds")
    private Money firstTransactionDebitedFunds;

    @SerializedName("FirstTransactionFees")
    private Money firstTransactionFees;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("Shipping")
    private Shipping shipping;

    @SerializedName("EndDate")
    private Long endDate;

    @SerializedName("Frequency")
    private String frequency;

    @SerializedName("FixedNextAmount")
    private Boolean fixedNextAmount;

    @SerializedName("FractionedPayment")
    private Boolean fractionedPayment;

    @SerializedName("Migration")
    private Boolean migration;

    @SerializedName("NextTransactionDebitedFunds")
    private Money nextTransactionDebitedFunds;

    @SerializedName("NextTransactionFees")
    private Money nextTransactionFees;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCreditedUserId() {
        return creditedUserId;
    }

    public void setCreditedUserId(String creditedUserId) {
        this.creditedUserId = creditedUserId;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }

    public Money getFirstTransactionDebitedFunds() {
        return firstTransactionDebitedFunds;
    }

    public void setFirstTransactionDebitedFunds(Money firstTransactionDebitedFunds) {
        this.firstTransactionDebitedFunds = firstTransactionDebitedFunds;
    }

    public Money getFirstTransactionFees() {
        return firstTransactionFees;
    }

    public void setFirstTransactionFees(Money firstTransactionFees) {
        this.firstTransactionFees = firstTransactionFees;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Boolean isFixedNextAmount() {
        return fixedNextAmount;
    }

    public void setFixedNextAmount(Boolean fixedNextAmount) {
        this.fixedNextAmount = fixedNextAmount;
    }

    public Boolean isFractionedPayment() {
        return fractionedPayment;
    }

    public void setFractionedPayment(Boolean fractionedPayment) {
        this.fractionedPayment = fractionedPayment;
    }

    public Boolean isMigration() {
        return migration;
    }

    public void setMigration(Boolean migration) {
        this.migration = migration;
    }

    public Money getNextTransactionDebitedFunds() {
        return nextTransactionDebitedFunds;
    }

    public void setNextTransactionDebitedFunds(Money nextTransactionDebitedFunds) {
        this.nextTransactionDebitedFunds = nextTransactionDebitedFunds;
    }

    public Money getNextTransactionFees() {
        return nextTransactionFees;
    }

    public void setNextTransactionFees(Money nextTransactionFees) {
        this.nextTransactionFees = nextTransactionFees;
    }

    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("Money", Money.class);
        result.put("Billing", Billing.class);
        result.put("Shipping", Shipping.class);

        return result;
    }
}
