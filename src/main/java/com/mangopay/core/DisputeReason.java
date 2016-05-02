package com.mangopay.core;

import com.mangopay.core.enumerations.DisputeReasonType;

/**
 * Class represents dispute's reason.
 */
public class DisputeReason extends Dto {
    
    /**
     * Dispute's reason type.
     */
    public DisputeReasonType DisputeReasonType;
    
    /**
     * Dispute's reason message.
     */
    public String DisputeReasonMessage;
}
