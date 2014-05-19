package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import java.util.ArrayList;

/**
 * Event entity.
 */
public class Event extends EntityBase {
    
    public String ResourceId;
    
    public String EventType;
    
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
