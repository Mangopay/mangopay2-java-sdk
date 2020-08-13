package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.CurrencyIso;

/**
 * Class represents money value with currency.
 */
public class Money extends Dto {

    /**
     * Currency code in ISO 4217 standard.
     */
    @SerializedName("Currency")
    private CurrencyIso currency;

    /**
     * The currency amount of money, in cents
     */
    @SerializedName("Amount")
    private long amount;

    public Money(CurrencyIso currency, long amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money() {
    }

    public CurrencyIso getCurrency() {
        return currency;
    }

    public Long getAmount() {
        return amount;
    }

    public Money setCurrency(CurrencyIso currency) {
        this.currency = currency;
        return this;
    }

    public Money setAmount(long amount) {
        this.amount = amount;
        return this;
    }
}
