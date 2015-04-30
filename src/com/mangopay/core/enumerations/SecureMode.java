package com.mangopay.core.enumerations;

/**
 * Secure mode enumeration.
 */
public enum SecureMode {
    /**
     * Not specified.
     */
    NotSpecified,

    /**
     * Secured Mode is activated from €100.
     */
    DEFAULT,

    /**
     * Secured Mode is activated for any transaction's amount.
     */
    FORCE
}
