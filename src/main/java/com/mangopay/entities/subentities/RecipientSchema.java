package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.Map;

public class RecipientSchema extends Dto {
    @SerializedName("DisplayName")
    private RecipientPropertySchema displayName;

    @SerializedName("Currency")
    private RecipientPropertySchema currency;

    @SerializedName("RecipientType")
    private RecipientPropertySchema recipientType;

    @SerializedName("PayoutMethodType")
    private RecipientPropertySchema payoutMethodType;

    @SerializedName("LocalBankTransfer")
    private Map<String, Map<String, RecipientPropertySchema>> localBankTransfer;

    @SerializedName("IndividualRecipient")
    private IndividualRecipientPropertySchema individualRecipient;

    @SerializedName("BusinessRecipient")
    private BusinessRecipientPropertySchema businessRecipient;

    public RecipientPropertySchema getDisplayName() {
        return displayName;
    }

    public RecipientSchema setDisplayName(RecipientPropertySchema displayName) {
        this.displayName = displayName;
        return this;
    }

    public RecipientPropertySchema getCurrency() {
        return currency;
    }

    public RecipientSchema setCurrency(RecipientPropertySchema currency) {
        this.currency = currency;
        return this;
    }

    public RecipientPropertySchema getRecipientType() {
        return recipientType;
    }

    public RecipientSchema setRecipientType(RecipientPropertySchema recipientType) {
        this.recipientType = recipientType;
        return this;
    }

    public RecipientPropertySchema getPayoutMethodType() {
        return payoutMethodType;
    }

    public RecipientSchema setPayoutMethodType(RecipientPropertySchema payoutMethodType) {
        this.payoutMethodType = payoutMethodType;
        return this;
    }

    public Map<String, Map<String, RecipientPropertySchema>> getLocalBankTransfer() {
        return localBankTransfer;
    }

    public RecipientSchema setLocalBankTransfer(Map<String, Map<String, RecipientPropertySchema>> localBankTransfer) {
        this.localBankTransfer = localBankTransfer;
        return this;
    }

    public IndividualRecipientPropertySchema getIndividualRecipient() {
        return individualRecipient;
    }

    public RecipientSchema setIndividualRecipient(IndividualRecipientPropertySchema individualRecipient) {
        this.individualRecipient = individualRecipient;
        return this;
    }

    public BusinessRecipientPropertySchema getBusinessRecipient() {
        return businessRecipient;
    }

    public RecipientSchema setBusinessRecipient(BusinessRecipientPropertySchema businessRecipient) {
        this.businessRecipient = businessRecipient;
        return this;
    }
}
