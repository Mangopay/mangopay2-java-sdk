package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import java.util.ArrayList;

/**
 * CardRegistration entity.
 */
public class CardRegistration extends EntityBase {
    
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
    public String Currency;
        
    /**
     * Status.
     */
    public String Status;
    
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
