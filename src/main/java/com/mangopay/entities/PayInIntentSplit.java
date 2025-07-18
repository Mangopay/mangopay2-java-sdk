package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class PayInIntentSplit extends EntityBase {
    /**
     * The unique identifier of an item in Mangopay ecosystem
     */
    @SerializedName("LineItemId")
    private String lineItemId;

    /**
     * The unique identifier of the seller providing the item (userId)
     */
    @SerializedName("SellerId")
    private String sellerId;

    /**
     * The unique identifier of the wallet to credit the seller funds
     */
    @SerializedName("WalletId")
    private String walletId;

    /**
     * Information about the amount to be credited to the seller wallet
     */
    @SerializedName("SplitAmount")
    private Integer splitAmount;

    /**
     * Information about the fees
     */
    @SerializedName("FeesAmount")
    private Integer feesAmount;

    /**
     * Information about the date when the funds are to be transferred to the seller’s wallet
     * Must be a date in the future
     */
    @SerializedName("TransferDate")
    private Long transferDate;

    /**
     * The description of the split object
     */
    @SerializedName("Description")
    private String description;

    /**
     * The status of the split
     */
    @SerializedName("Status")
    private String status;

    public String getLineItemId() {
        return lineItemId;
    }

    public PayInIntentSplit setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
        return this;
    }

    public String getSellerId() {
        return sellerId;
    }

    public PayInIntentSplit setSellerId(String sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    public String getWalletId() {
        return walletId;
    }

    public PayInIntentSplit setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public Integer getSplitAmount() {
        return splitAmount;
    }

    public PayInIntentSplit setSplitAmount(Integer splitAmount) {
        this.splitAmount = splitAmount;
        return this;
    }

    public Integer getFeesAmount() {
        return feesAmount;
    }

    public PayInIntentSplit setFeesAmount(Integer feesAmount) {
        this.feesAmount = feesAmount;
        return this;
    }

    public Long getTransferDate() {
        return transferDate;
    }

    public PayInIntentSplit setTransferDate(Long transferDate) {
        this.transferDate = transferDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PayInIntentSplit setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PayInIntentSplit setStatus(String status) {
        this.status = status;
        return this;
    }
}