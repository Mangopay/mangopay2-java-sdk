package com.mangopay.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for transaction list.
 */
public class FilterTransactions extends Dto {
    
    /**
     * TransactionStatus {CREATED, SUCCEEDED, FAILED}
     */
    public String Status;
    
    /**
     * TransactionType {PAYIN, PAYOUT, TRANSFER}
     */
    public String Type;
    
    /**
     * TransactionNature { REGULAR, REFUND, REPUDIATION }
     */
    public String Nature;
    
    /**
     * TransactionDirection {DEBIT, CREDIT}
     */
    public String Direction;
    
    /**
     * Start date in Unix format:
     * return only transactions that have CreationDate BEFORE this date
     */
    public Long BeforeDate;
    
    /**
     * End date in Unix format:
     * return only transactions that have CreationDate AFTER this date
     */
    public Long AfterDate;
    
    /**
     * Gets map of fields and values.
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();
        
        if (Status != null && !Status.isEmpty()) result.put("Status", Status);
        if (Type != null && !Type.isEmpty()) result.put("Type", Type);
        if (Nature != null && !Nature.isEmpty()) result.put("Nature", Nature);
        if (Direction != null && !Direction.isEmpty()) result.put("Direction", Direction);
        if (BeforeDate != null) result.put("BeforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("AfterDate", Long.toString(AfterDate));
        
        return result;
    }
}
