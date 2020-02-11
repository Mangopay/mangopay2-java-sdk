package com.mangopay.core.enumerations;

/**
 * Payment type enumeration.
 */
public enum PayInPaymentType {
    /**
     * Not specified.
     */
    NotSpecified,

    /**
     * CARD payment type.
     */
    CARD, 

    /**
     * BANK WIRE payment type.
     */
    BANK_WIRE, 

    /**
     * AUTOMATIC DEBIT payment type.
     */
    AUTOMATIC_DEBIT, 

    /**
     * DIRECT DEBIT payment type.
     */
    DIRECT_DEBIT,

    /**
     * PREAUTHORIZED payment type.
     */
    PREAUTHORIZED,
    
    /**
     * PAYPAL payment type.
     */
    PAYPAL,

    /**
     * APPLEPAY payment type
     */
    APPLEPAY,

    /**
     * APPLEPAY payment type
     */
    GOOGLEPAY
}
