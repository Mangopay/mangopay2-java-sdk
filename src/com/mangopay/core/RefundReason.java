package com.mangopay.core;

import com.mangopay.core.enumerations.RefundReasonType;

/**
 * Class represents refund's reason.
 */
public class RefundReason extends Dto {
    
    /**
     * Message.
     */
    public String RefundReasonMessage;
    
    /**
     * Type of refund reason.
     */
    public RefundReasonType RefundReasonType;
}
