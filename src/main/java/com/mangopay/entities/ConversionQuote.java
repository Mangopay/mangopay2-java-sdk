package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;

public class ConversionQuote extends EntityBase {

    @SerializedName("ExpirationDate")
    private int expirationDate;
    @SerializedName("Status")
    private String status;
    @SerializedName("Duration")
    private int duration;
    @SerializedName("DebitedFunds")
    private Money debitedFunds;
    @SerializedName("CreditedFunds")
    private Money creditedFunds;
    @SerializedName("ConversionRateResponse")
    private ConversionRate conversionRateResponse;

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public ConversionRate getConversionRateResponse() {
        return conversionRateResponse;
    }

    public void setConversionRateResponse(ConversionRate conversionRateResponse) {
        this.conversionRateResponse = conversionRateResponse;
    }
}
