package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;

/**
 * Class represents money value with currency.
 */
public class Money extends Dto {
    
    /**
     * Currency code in ISO 4217 standard.
     */
    public CurrencyIso Currency;
    
    /**
     * The currency amount of money, in cents
     */
    public int Amount;
    
}
