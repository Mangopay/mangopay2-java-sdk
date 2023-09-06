package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

public class Fees extends Dto {

    @SerializedName("Currency")
    private String currency;

    @SerializedName("Amount")
    private int amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
