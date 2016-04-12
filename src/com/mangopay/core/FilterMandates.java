package com.mangopay.core;

import com.mangopay.core.enumerations.MandateStatus;
import java.util.HashMap;
import java.util.Map;

/**
 * Filters for mandates list.
 */
public class FilterMandates extends Dto {
    
    /**
     * Status of mandates.
     */
    public MandateStatus Status;
    
    /**
     * Start date in Unix format.
     */
    public Long BeforeDate;
    
    /**
     * End date in Unix format.
     */
    public Long AfterDate;
    
    /**
     * Gets map of fields and values.
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();
        
        if (Status != null && Status != MandateStatus.NotSpecified) {
            result.put("status", Status.name());
        }
        
        if (BeforeDate != null) result.put("beforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("afterDate", Long.toString(AfterDate));
        
        return result;
    }
    
}
