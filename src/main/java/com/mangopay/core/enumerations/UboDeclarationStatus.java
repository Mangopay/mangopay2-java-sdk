package com.mangopay.core.enumerations;

/**
 * UBO declaration status enumeration.
 */
public enum UboDeclarationStatus {

    /**
     * When the UBO declaration was created
     */
    CREATED,

    /**
     * When validation has been requested for the UBO declaration
     */
    VALIDATION_ASKED,

    /**
     * When the UBO declaration was validated
     */
    VALIDATED,

    /**
     * When the UBO declaration was refused
     */
    REFUSED
}
