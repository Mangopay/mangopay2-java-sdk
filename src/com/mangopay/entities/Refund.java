package com.mangopay.entities;

import com.mangopay.core.RefundReason;
import com.mangopay.core.enumerations.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Refund entity.
 */
public class Refund extends Transaction {
    
    /**
     * Initial transaction identifier.
     */
    public String InitialTransactionId;
    
    /**
     * Initial transaction type.
     */
    public InitialTransactionType InitialTransactionType;
    
    /**
     * Debited wallet identifier.
     */
    public String DebitedWalletId;
    
    /**
     * Credited wallet identifier.
     */
    public String CreditedWalletId;
    
    /**
     * Contains info about the reason for refund.
     */
    public RefundReason RefundReason;
    
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        Map<String, Type> result = super.getSubObjects();
        
        result.put("RefundReason", RefundReason.class);
        
        return result;
    }
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("InitialTransactionType");
        result.add("RefundReason");
        
        return result;
    }
}
