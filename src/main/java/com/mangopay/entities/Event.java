package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.EventType;
import java.util.ArrayList;

/**
 * Event entity.
 */
public class Event extends EntityBase {
    
    /**
     * Resource identifier.
     */
    public String ResourceId;
    
    /**
     * Type of event.
     */
    public EventType EventType;
    
    /**
     * Date as UNIX timestamp.
     */
    public long Date;
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("ResourceId");
        result.add("EventType");
        result.add("Date");
        
        return result;
    }
}
