package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.FundsType;
import java.lang.reflect.Type;
import java.util.*;

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
     * Currency.
     */
    public CurrencyIso Currency;
    
    /**
     * The funds usage type.
     */
    public FundsType FundsType;
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        return new HashMap<String, Type>() {{ 
            put("Balance", Money.class); 
        }};
    }
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("Balance");
        
        return result;
    }
    
}
