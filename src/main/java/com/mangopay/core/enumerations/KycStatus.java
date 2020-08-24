package com.mangopay.core.enumerations;

/**
 * KYC document status enumeration.
 */
public enum KycStatus {
    /**
     * Not specified.
     */
    NotSpecified,

    /**
     * CREATED KYC status.
     */
    CREATED, 

    /**
     * VALIDATION ASKED KYC status.
     */
    VALIDATION_ASKED, 

    /**
     * VALIDATED KYC status.
     */
    VALIDATED, 

    /**
     * REFUSED KYC status.
     */
    REFUSED,

    /**
     * OUT_OF_DATE kyc status
     */
    OUT_OF_DATE
}
