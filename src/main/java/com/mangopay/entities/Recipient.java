package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.subentities.BusinessRecipient;
import com.mangopay.entities.subentities.IndividualRecipient;
import com.mangopay.entities.subentities.PendingUserAction;

import java.util.Map;

public class Recipient extends EntityBase {
    /**
     * The status
     */
    @SerializedName("Status")
    private String status;

    /**
     * A unique external identifier for the recipient's bank account.
     */
    @SerializedName("DisplayName")
    private String displayName;

    /**
     * Defines the payout method (e.g., LocalBankTransfer, InternationalBankTransfer).
     */
    @SerializedName("PayoutMethodType")
    private String payoutMethodType;

    /**
     * Specifies whether the recipient is an Individual or a Business.
     */
    @SerializedName("RecipientType")
    private String recipientType;

    /**
     * 3-letter ISO 4217 destination currency code (e.g. EUR, USD, GBP, AUD, CAD,HKD, SGD, MXN).
     */
    @SerializedName("Currency")
    private CurrencyIso currency;

    /**
     * Individual recipient
     */
    @SerializedName("IndividualRecipient")
    private IndividualRecipient individualRecipient;

    /**
     * Business recipient
     */
    @SerializedName("BusinessRecipient")
    private BusinessRecipient businessRecipient;

    /**
     * The account details if PayoutMethodType is LocalBankTransfer, depending on the Currency.
     */
    @SerializedName("LocalBankTransfer")
    private Map<String, Object> localBankTransfer;

    /**
     * The account details if PayoutMethodType is InternationalBankTransfer.
     */
    @SerializedName("InternationalBankTransfer")
    private Map<String, Object> internationalBankTransfer;

    /**
     * Information about the action required from the user
     */
    @SerializedName("PendingUserAction")
    private PendingUserAction pendingUserAction;

    public String getStatus() {
        return status;
    }

    public Recipient setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Recipient setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getPayoutMethodType() {
        return payoutMethodType;
    }

    public Recipient setPayoutMethodType(String payoutMethodType) {
        this.payoutMethodType = payoutMethodType;
        return this;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public Recipient setRecipientType(String recipientType) {
        this.recipientType = recipientType;
        return this;
    }

    public CurrencyIso getCurrency() {
        return currency;
    }

    public Recipient setCurrency(CurrencyIso currency) {
        this.currency = currency;
        return this;
    }

    public IndividualRecipient getIndividualRecipient() {
        return individualRecipient;
    }

    public Recipient setIndividualRecipient(IndividualRecipient individualRecipient) {
        this.individualRecipient = individualRecipient;
        return this;
    }

    public BusinessRecipient getBusinessRecipient() {
        return businessRecipient;
    }

    public Recipient setBusinessRecipient(BusinessRecipient businessRecipient) {
        this.businessRecipient = businessRecipient;
        return this;
    }

    public Map<String, Object> getLocalBankTransfer() {
        return localBankTransfer;
    }

    public Recipient setLocalBankTransfer(Map<String, Object> localBankTransfer) {
        this.localBankTransfer = localBankTransfer;
        return this;
    }

    public PendingUserAction getPendingUserAction() {
        return pendingUserAction;
    }

    public Recipient setPendingUserAction(PendingUserAction pendingUserAction) {
        this.pendingUserAction = pendingUserAction;
        return this;
    }

    public Map<String, Object> getInternationalBankTransfer() {
        return internationalBankTransfer;
    }

    public Recipient setInternationalBankTransfer(Map<String, Object> internationalBankTransfer) {
        this.internationalBankTransfer = internationalBankTransfer;
        return this;
    }
}
