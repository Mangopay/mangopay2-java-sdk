package com.mangopay.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for events list.
 */
public class FilterEvents extends Dto {
    
    /**
     * Type of events.
     */
    public EventType Type;
    
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
        
        result.put("eventtype", Type.name());
        
        if (BeforeDate != null) result.put("beforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("afterDate", Long.toString(AfterDate));
        
        return result;
    }
}
