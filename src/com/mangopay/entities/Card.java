package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * Card entity.
 */
public class Card extends EntityBase {
    
    /**
     * Expiration date.
     */
    public String ExpirationDate;
    
    /**
     * Alias.
     */
    public String Alias;
    
    /**
     * Card type.
     */
    public String CardType;
    
    /**
     * Product.
     */
    public String Product ;
    
    /**
     * Bank code.
     */
    public String BankCode;
    
    /**
     * Active.
     */
    public Boolean Active;
    
    /**
     * Currency.
     */
    public String Currency;
    
    /**
     * Validity.
     */
    public String Validity;
}
