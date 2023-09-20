package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.ArrayList;

public class ConversionRate extends Dto {

    /**
     * The sell currency – the currency of the wallet to be debited.
     */
    @SerializedName("DebitedCurrency")
    public String debitedCurrency;

    /**
     * The buy currency – the currency of the wallet to be credited.
     */
    @SerializedName("CreditedCurrency")
    public String creditedCurrency;

    /**
     * The market rate plus Mangopay's commission,
     * charged during the platform's billing cycle. This is an indicative rate.
     */
    @SerializedName("ClientRate")
    public String clientRate;

    /**
     * The rate used for the conversion, excluding Mangopay's commission.
     */
    @SerializedName("MarketRate")
    public String marketRate;

    public String getDebitedCurrency() {
        return debitedCurrency;
    }

    public void setDebitedCurrency(String debitedCurrency) {
        this.debitedCurrency = debitedCurrency;
    }

    public String getCreditedCurrency() {
        return creditedCurrency;
    }

    public void setCreditedCurrency(String creditedCurrency) {
        this.creditedCurrency = creditedCurrency;
    }

    public String getClientRate() {
        return clientRate;
    }

    public void setClientRate(String clientRate) {
        this.clientRate = clientRate;
    }

    public String getMarketRate() {
        return marketRate;
    }

    public void setMarketRate(String marketRate) {
        this.marketRate = marketRate;
    }

    @Override
    public ArrayList<String> getReadOnlyProperties() {
        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("ClientRate");
        result.add("MarketRate");

        return result;
    }
}
