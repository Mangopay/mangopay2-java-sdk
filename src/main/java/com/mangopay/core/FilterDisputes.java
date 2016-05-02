package com.mangopay.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for disputes list.
 */
public class FilterDisputes extends Dto {
    
    /**
     * Start date in Unix format: return only disputes that have CreationDate BEFORE this date.
     */
    public Long BeforeDate;
    
    /**
     * End date in Unix format: return only disputes that have CreationDate AFTER this date.
     */
    public Long AfterDate;
    
    /**
     * Gets map of fields and values.
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();
        
        if (BeforeDate != null) result.put("BeforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("AfterDate", Long.toString(AfterDate));
        
        return result;
    }
}
