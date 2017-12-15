package com.mangopay.core.enumerations;

/**
 * Enumerated reasons why declaration of a user as UBO was refused.
 */
public enum UboRefusedReasonType {

    /**
     * When user should not be declared as UBO
     */
    INVALID_DECLARED_UBO,

    /**
     * User declared as UBO was created with wrong
     * details (i.e. date of birth, country of residence).
     */
    INVALID_UBO_DETAILS
}
