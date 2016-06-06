package com.mangopay.entities;

import com.mangopay.core.enumerations.*;
import com.mangopay.core.EntityBase;
import java.util.ArrayList;

/**
 * Card entity.
 */
public class Card extends EntityBase {
    
     /**
     * User Id.
     */
    public String UserId;
    
     /**
     * Country.
     */
    public String Country;
    
    /**
     * Expiration date.
     */
    public String ExpirationDate;
    
    /**
     * Alias.
     */
    public String Alias;
    
    /**
     * The card provider, it could be CB, VISA, MASTERCARD, etc.
     */
    public String CardProvider;
    
    /**
     * Card type.
     */
    public CardType CardType;
    
    /**
     * Product codes.
     */
    public String Product;
    
    /**
     * Bank code.
     */
    public String BankCode;
    
    /**
     * Active.
     */
    public Boolean Active;
    
    /**
     * The currency accepted in the wallet.
     */
    public CurrencyIso Currency;
    
    /**
     * Validity.
     */
    public Validity Validity;
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("UserId");
        result.add("Country");
        result.add("ExpirationDate");
        result.add("Alias");
        result.add("CardProvider");
        result.add("CardType");
        result.add("Product");
        result.add("BankCode");
        result.add("Active");
        result.add("Currency");
        
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s ID: %s Active: %s", super.toString(), super.Id, Active);
    }
    
    
    
    
    
}
