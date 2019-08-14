package com.mangopay.core.enumerations;

/**
 * Enumeration of reasons why a UBO declaration could be refused.
 */
public enum UboDeclarationRefusedReasonType {

    /**
     * When at least one natural user is missing on the declaration
     */
    MISSING_UBO,

    /**
     * When at least one natural user should not be declared as UBO
     */
    DECLARATION_DO_NOT_MATCH_UBO_INFORMATION,

    /**
     * When at least one natural user declared as UBO has been created
     * with wrong details (i.e. date of birth, country of residence)
     */
    INVALID_UBO_DETAILS
}
