package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;

/**
 * Class represents money value with currency.
 */
public class Money extends Dto {

    /**
     * Currency code in ISO 4217 standard.
     *
     * @deprecated Use {@link #getCurrency()} and {@link #setCurrency(CurrencyIso)} instead.
     */
    @Deprecated
    public CurrencyIso Currency;

    /**
     * The currency amount of money, in cents
     *
     * @deprecated Use {@link #getAmount()} and {@link #setAmount(int)} instead.
     */
    @Deprecated
    public int Amount;

    public CurrencyIso getCurrency() {
        return Currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.Currency = currency;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }
}
