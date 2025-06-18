package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.subentities.*;

import java.util.List;

public class PayInIntent extends EntityBase {
    /**
     * An amount of money in the smallest sub-division of the currency
     */
    @SerializedName("Amount")
    private Integer amount;

    /**
     * The remaining amount on the intent available for transfers
     */
    @SerializedName("AvailableAmountToSplit")
    private Integer availableAmountToSplit;

    /**
     * The currency of the funds
     */
    @SerializedName("Currency")
    private CurrencyIso currency;

    /**
     * Information about the fees
     */
    @SerializedName("PlatformFeesAmount")
    private Integer platformFeesAmount;

    /**
     * The status of the intent
     */
    @SerializedName("Status")
    private String status;

    /**
     * The possible next statuses for the intent
     */
    @SerializedName("NextActions")
    private String nextActions;

    /**
     * Information about the external processed transaction
     */
    @SerializedName("ExternalData")
    private PayInIntentExternalData externalData;

    /**
     * Information about the buyer
     */
    @SerializedName("Buyer")
    private PayInIntentBuyer buyer;

    /**
     * Information about the items purchased in the transaction.
     * <p></p>
     * The total of all LineItems UnitAmount, TaxAmount, DiscountAmount, TotalLineItemAmount must equal the Amount
     * <p></p>
     * The total of all LineItems FeesAmount mus equal the PlatformFees amount
     */
    @SerializedName("LineItems")
    private List<PayInIntentLineItem> lineItems;

    /**
     * Information about the amounts captured against the intent
     */
    @SerializedName("Captures")
    private List<PayInIntentCapture> captures;

    /**
     * Information about the amounts refunded against the intent
     */
    @SerializedName("Refunds")
    private List<PayInIntentRefund> refunds;

    /**
     * Information about the amounts refunded against the intent
     */
    @SerializedName("Disputes")
    private List<PayInIntentDispute> disputes;

    /**
     * Information about the amounts split against the intent
     */
    @SerializedName("Splits")
    private List<PayInIntentSplit> splits;

    /**
     * The unique identifier of the settlement linked to this intent in Mangopay ecosystem
     */
    @SerializedName("SettlementId")
    private String settlementId;

    public Integer getAmount() {
        return amount;
    }

    public PayInIntent setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Integer getAvailableAmountToSplit() {
        return availableAmountToSplit;
    }

    public PayInIntent setAvailableAmountToSplit(Integer availableAmountToSplit) {
        this.availableAmountToSplit = availableAmountToSplit;
        return this;
    }

    public CurrencyIso getCurrency() {
        return currency;
    }

    public PayInIntent setCurrency(CurrencyIso currency) {
        this.currency = currency;
        return this;
    }

    public Integer getPlatformFeesAmount() {
        return platformFeesAmount;
    }

    public PayInIntent setPlatformFeesAmount(Integer platformFeesAmount) {
        this.platformFeesAmount = platformFeesAmount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PayInIntent setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getNextActions() {
        return nextActions;
    }

    public PayInIntent setNextActions(String nextActions) {
        this.nextActions = nextActions;
        return this;
    }

    public PayInIntentExternalData getExternalData() {
        return externalData;
    }

    public PayInIntent setExternalData(PayInIntentExternalData externalData) {
        this.externalData = externalData;
        return this;
    }

    public PayInIntentBuyer getBuyer() {
        return buyer;
    }

    public PayInIntent setBuyer(PayInIntentBuyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public List<PayInIntentLineItem> getLineItems() {
        return lineItems;
    }

    public PayInIntent setLineItems(List<PayInIntentLineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public List<PayInIntentCapture> getCaptures() {
        return captures;
    }

    public PayInIntent setCaptures(List<PayInIntentCapture> captures) {
        this.captures = captures;
        return this;
    }

    public List<PayInIntentRefund> getRefunds() {
        return refunds;
    }

    public PayInIntent setRefunds(List<PayInIntentRefund> refunds) {
        this.refunds = refunds;
        return this;
    }

    public List<PayInIntentDispute> getDisputes() {
        return disputes;
    }

    public PayInIntent setDisputes(List<PayInIntentDispute> disputes) {
        this.disputes = disputes;
        return this;
    }

    public List<PayInIntentSplit> getSplits() {
        return splits;
    }

    public PayInIntent setSplits(List<PayInIntentSplit> splits) {
        this.splits = splits;
        return this;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public PayInIntent setSettlementId(String settlementId) {
        this.settlementId = settlementId;
        return this;
    }
}
