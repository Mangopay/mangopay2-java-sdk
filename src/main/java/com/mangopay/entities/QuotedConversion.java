package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

/**
 * A conversion, at the rate guaranteed by its quote, of the debited funds to the credited wallet.
 */
public class QuotedConversion extends Transaction {

    @SerializedName("QuoteId")
    private String quoteId;

    @SerializedName("ConversionRateResponse")
    private ConversionRate conversionRateResponse;

    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    @SerializedName("DebitedWalletId")
    private String debitedWalletId;

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public ConversionRate getConversionRateResponse() {
        return conversionRateResponse;
    }

    public void setConversionRateResponse(ConversionRate conversionRateResponse) {
        this.conversionRateResponse = conversionRateResponse;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }
}
