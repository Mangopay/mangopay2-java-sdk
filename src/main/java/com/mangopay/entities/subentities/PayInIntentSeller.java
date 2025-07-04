package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;


public class PayInIntentSeller extends Dto {
    /**
     * The unique identifier of the seller providing the item
     * <p></p>
     * One valid value must be sent between AuthorId & WalletId
     */
    @SerializedName("AuthorId")
    private String authorId;

    /**
     * The unique identifier of the wallet to credit the seller funds
     * <p>
     * One valid value must be sent between AuthorId & WalletId
     */
    @SerializedName("WalletId")
    private String walletId;

    /**
     * Information about the fees
     */
    @SerializedName("FeesAmount")
    private Integer feesAmount;

    /**
     * Information about the date when the funds are to be transferred to the seller’s wallet
     * <p></p>
     * Must be a date in the future
     */
    @SerializedName("TransferDate")
    private String transferDate;

    public String getAuthorId() {
        return authorId;
    }

    public PayInIntentSeller setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getWalletId() {
        return walletId;
    }

    public PayInIntentSeller setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public Integer getFeesAmount() {
        return feesAmount;
    }

    public PayInIntentSeller setFeesAmount(Integer feesAmount) {
        this.feesAmount = feesAmount;
        return this;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public PayInIntentSeller setTransferDate(String transferDate) {
        this.transferDate = transferDate;
        return this;
    }
}
