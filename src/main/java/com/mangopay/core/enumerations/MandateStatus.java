package com.mangopay.core.enumerations;

/**
 * Status of mandate.
 */
public enum MandateStatus {
    
    /**
     * Not specified.
     */
    NotSpecified,
    
    /**
     * The mandate has been created.
     */
    CREATED,
    
    /**
     * The mandate has been submitted to the banks and you can now do payments with this mandate.
     */
    SUBMITTED,
    
    /**
     * The mandate is active and has been accepted by the banks and/or successfully used in a payment.
     */
    ACTIVE,
    
    /**
     * The mandate has failed for a variety of reasons and is no longer available for payments.
     */
    FAILED,
    
        /**
     * The mandate has expired and cannot be used anymore for Payins. A new mandate has to be created.
     */
    EXPIRED
}
