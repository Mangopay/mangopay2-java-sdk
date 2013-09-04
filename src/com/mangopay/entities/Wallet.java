package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Wallet entity.
 */
public class Wallet extends EntityBase {
    
    /**
     * Collection of owners identifiers.
     */
    public ArrayList<String> Owners;
    
    /**
     * Wallet description.
     */
    public String Description;
    
    /**
     * Money in wallet.
     */
    public Money Balance;
    
    /**
     * Currency code in ISO.
     */
    public String Currency;
    
    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        return new HashMap<String, Type>() {{ 
            put("Balance", Money.class); 
        }};
    }
    
    /**
     * Gets the collection of read-only fields names
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("Balance");
        
        return result;
    }
    
}
