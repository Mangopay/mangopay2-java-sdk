package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.*;

/**
 * Hooks and Notifications entity.
 */
public class Hook extends EntityBase {
    
    /**
     * This is the URL where you receive notification for various event types.
     */
    public String Url;
    
    /**
     * Hook status.
     */
    public HookStatus Status;
    
    /**
     * Hook validity.
     */
    public Validity Validity;
    
    /**
     * Event type (the <code>EventType.ALL</code> value is forbidden here).
     */
    public EventType EventType;
    
}
