package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;

public class CreateConversionQuote extends Dto {
    @SerializedName("Duration")
    private int duration;
    @SerializedName("DebitedFunds")
    private Money debitedFunds;
    @SerializedName("CreditedFunds")
    private Money creditedFunds;
    @SerializedName("Tag")
    private String tag;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
