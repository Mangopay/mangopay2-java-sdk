package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Transaction entity.
 * Base class for: PayIn, PayOut, Transfer.
 */
public class Transaction extends EntityBase {
    
    /**
     * Author identifier.
     */
    public String AuthorId;
    
    /**
     * Credited user identifier.
     */
    public String CreditedUserId;
    
    /**
     * Debited funds.
     */
    public Money DebitedFunds;
    
    /**
     * Credited funds.
     */
    public Money CreditedFunds;
    
    /**
     * Fees.
     */
    public Money Fees;
    
    /**
     * TransactionStatus {CREATED, SUCCEEDED, FAILED}
     */
    public String Status;
    
    /**
     * Result code.
     */
    public String ResultCode;
    
    /**
     * The PreAuthorization result Message explaining the result code.
     */
    public String ResultMessage;
    
    /**
     * ExecutionDate (UNIX timestamp).
     */
    public Long ExecutionDate;
    
    /**
     * TransactionType {PAYIN, PAYOUT, TRANSFER}
     */
    public String Type;
    
    /**
     * TransactionNature { REGULAR, REFUND, REPUDIATION }
     */
    public String Nature;
    
    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        HashMap<String, Type> result = new HashMap<>();
        
        result.put("DebitedFunds", Money.class);
        result.put("CreditedFunds", Money.class);
        result.put("Fees", Money.class);
        
        return result;
    }
    
    /**
     * Gets the collection of read-only fields names
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("Status");
        result.add("ResultCode");
        result.add("ExecutionDate");
        
        return result;
    }
}
