package com.mangopay.entities;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.EntityBase;
import java.util.ArrayList;

/**
 * CardRegistration entity.
 */
public class CardRegistration extends EntityBase {
    
    public CardRegistration() {
        CardType = CardType.CB_VISA_MASTERCARD;
    }
    
    public CardRegistration(CardType cardType) {
        CardType = cardType;
    }
    
    /**
     * User Id.
     */
    public String UserId;
    
    /**
     * Access key.
     */
    public String AccessKey;
        
    /**
     * Pre-registration data.
     */
    public String PreregistrationData;
        
    /**
     * Card registration URL.
     */
    public String CardRegistrationURL;
        
    /**
     * Card identifier.
     */
    public String CardId;
        
    /**
     * Card registration data.
     */
    public String RegistrationData;
        
    /**
     * Result code.
     */
    public String ResultCode;
        
    /**
     * Currency.
     */
    public CurrencyIso Currency;
        
    /**
     * Status.
     */
    public String Status;
    
    /**
     * Card type.
     */
    public CardType CardType;
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("AccessKey");
        result.add("PreregistrationData");
        result.add("CardRegistrationURL");
        result.add("CardId");
        result.add("ResultCode");
        result.add("Status");
        
        return result;
    }
    
}
