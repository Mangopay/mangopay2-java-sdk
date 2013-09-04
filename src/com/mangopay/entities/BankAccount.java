package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import java.util.ArrayList;

/**
 * Bank Account entity.
 */
public class BankAccount extends EntityBase {
    
    /**
     * User identifier.
     */
    public String UserId;
    
    /**
     * Type of bank account.
     */
    public String Type;
    
    /**
     * Owner name.
     */
    public String OwnerName;
    
    /**
     * Owner address.
     */
    public String OwnerAddress;
    
    /**
     * IBAN number.
     */
    public String IBAN;
    
    /**
     * BIC.
     */
    public String BIC;

    /**
     * Gets the collection of read-only fields names
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("UserId");
        
        return result;
    }
}
