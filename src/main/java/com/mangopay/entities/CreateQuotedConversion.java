package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class CreateQuotedConversion extends Dto {

    /**
     * The unique identifier of the active quote which guaranteed the rate for the conversion.
     */
    @SerializedName("QuoteId")
    private String quoteId;

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
     * Custom data.
     */
    @SerializedName("Tag")
    private String tag;

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
