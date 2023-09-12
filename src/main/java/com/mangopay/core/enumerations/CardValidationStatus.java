package com.mangopay.core.enumerations;

/**
 * Payment status enumeration.
 */
public enum CardValidationStatus {
    /**
     * The Card Validation object is created and the card pending validation.
     */
    CREATED,

    /**
     * The Card Validation failed, setting the corresponding card as invalid.
     */
    FAILED,

    /**
     The Card Validation was a success, setting the corresponding card as valid.
     */
    SUCCEEDED
}
