package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class CreateClientWalletsQuotedConversion extends Dto {
    /**
     * The unique identifier of the active quote which guaranteed the rate for the conversion.
     */
    @SerializedName("QuoteId")
    private String quoteId;

    /**
     * The type of the client wallet to be debited.
     * Allowed values: FEES, CREDIT
     */
    @SerializedName("DebitedWalletType")
    public String debitedWalletType;

    /**
     * The type of the client wallet to be credited.
     * Allowed values: FEES, CREDIT
     */
    @SerializedName("CreditedWalletType")
    public String creditedWalletType;

    /**
     * Custom data.
     */
    @SerializedName("Tag")
    private String tag;

    public String getQuoteId() {
        return quoteId;
    }

    public CreateClientWalletsQuotedConversion setQuoteId(String quoteId) {
        this.quoteId = quoteId;
        return this;
    }

    public String getDebitedWalletType() {
        return debitedWalletType;
    }

    public CreateClientWalletsQuotedConversion setDebitedWalletType(String debitedWalletType) {
        this.debitedWalletType = debitedWalletType;
        return this;
    }

    public String getCreditedWalletType() {
        return creditedWalletType;
    }

    public CreateClientWalletsQuotedConversion setCreditedWalletType(String creditedWalletType) {
        this.creditedWalletType = creditedWalletType;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public CreateClientWalletsQuotedConversion setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
