package com.mangopay.core.enumerations;

/**
 * Transaction type enumeration.
 */
public enum TransactionType {
    /**
     * Not specified.
     */
    NotSpecified,

    /**
     * PAYIN transaction type.
     */
    PAYIN, 

    /**
     * PAYOUT transaction type.
     */
    PAYOUT, 

    /**
     * TRANSFER transaction type.
     */
    TRANSFER,

    /**
     * CONVERSION transaction type.
     */
    CONVERSION,

    /**
     * CARD_VALIDATION transaction type.
     */
    CARD_VALIDATION
}
