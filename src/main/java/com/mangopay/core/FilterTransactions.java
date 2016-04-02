package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import java.util.*;

/**
 * Filter for transaction list.
 */
public class FilterTransactions extends Dto {
    
    /**
     * Transaction status.
     */
    public TransactionStatus Status;
    
    /**
     * Transaction type.
     */
    public TransactionType Type;
    
    /**
     * Transaction nature.
     */
    public TransactionNature Nature;
    
    /**
     * Start date in Unix format: return only transactions that have CreationDate BEFORE this date.
     */
    public Long BeforeDate;
    
    /**
     * End date in Unix format: return only transactions that have CreationDate AFTER this date.
     */
    public Long AfterDate;
    
    /**
     * Gets map of fields and values.
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();
        
        if (Status != null && Status != TransactionStatus.NotSpecified) result.put("Status", Status.toString());
        if (Type != null && Type != TransactionType.NotSpecified) result.put("Type", Type.toString());
        if (Nature != null && Nature != TransactionNature.NotSpecified) result.put("Nature", Nature.toString());
        if (BeforeDate != null) result.put("BeforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("AfterDate", Long.toString(AfterDate));
        
        return result;
    }
}
