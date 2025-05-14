package com.mangopay.core.enumerations;

/**
 * Payment status enumeration.
 */
public enum PaymentStatus {
    /**
     * Not specified.
     */ 
    NotSpecified,

    /**
     * WAITING payment status.
     */ 
    WAITING, 

    /**
     * CANCELED payment status.
     */ 
    CANCELED, 

    /**
     * EXPIRED payment status.
     */ 
    EXPIRED, 

    /**
     * VALIDATED payment status.
     */
    VALIDATED,

    /**
     * CANCEL_REQUESTED payment status (deposits)
     */
    CANCEL_REQUESTED,

    /**
     * TO_BE_COMPLETED payment status (deposits)
     */
    TO_BE_COMPLETED,

    /**
     * NO_SHOW_REQUESTED payment status (deposits)
     */
    NO_SHOW_REQUESTED,

    /**
     * NO_SHOW payment status (deposits)
     */
    NO_SHOW,

    /**
     * FAILED payment status (deposits)
     */
    FAILED
}
