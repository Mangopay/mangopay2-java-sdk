package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;

public class CreateInstantConversion extends Dto {

    /**
     * The unique identifier of the user at the source of the transaction.
     */
    @SerializedName("AuthorId")
    public String authorId;

    /**
     * The unique identifier of the debited wallet.
     */
    @SerializedName("DebitedWalletId")
    public String debitedWalletId;

    /**
     * The unique identifier of the credited wallet
     */
    @SerializedName("CreditedWalletId")
    public String creditedWalletId;

    /**
     * The sell funds
     */
    @SerializedName("DebitedFunds")
    public Money debitedFunds;

    /**
     * The buy funds
     */
    @SerializedName("CreditedFunds")
    public Money creditedFunds;

    /**
     * Information about the fees taken by the platform for
     * this transaction (and hence transferred to the Fees Wallet).
     */
    @SerializedName("Fees")
    public Money fees;

    /**
     * Custom data.
     */
    @SerializedName("Tag")
    private String tag;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public void setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
    }

    public Money getCreditedFunds() {
        return creditedFunds;
    }

    public void setCreditedFunds(Money creditedFunds) {
        this.creditedFunds = creditedFunds;
    }

    public Money getFees() {
        return fees;
    }

    public void setFees(Money fees) {
        this.fees = fees;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
