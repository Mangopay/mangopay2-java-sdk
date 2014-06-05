package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.EventType;

/**
 * Hooks and Notifications entity.
 */
public class Hook extends EntityBase {
    
    /**
     * This is the URL where you receive notification for each EventType.
     */
    public String Url;
    
    /**
     * Status { ENABLED, DISABLED }.
     */
    public String Status;
    
    /**
     * Validity { VALID, INVALID }.
     */
    public String Validity;
    
    /**
     * Event type (the <code>EventType.ALL</code> value is forbidden here).
     */
    public EventType EventType;
    
}
