package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import java.util.ArrayList;

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
     * The card provider, it could be CB, VISA, MASTERCARD, etc.
     */
    public String CardProvider;
    
    /**
     * Card type. { CB_VISA_MASTERCARD } is the only value available yet.
     */
    public String CardType;
    
    /**
     * Product codes.
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
     * The currency accepted in the wallet { EUR, USD, GBP, PLN, CHF }.
     */
    public String Currency;
    
    /**
     * Validity { UNKNOWN, VALID, INVALID }.
     */
    public String Validity;
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
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
}
