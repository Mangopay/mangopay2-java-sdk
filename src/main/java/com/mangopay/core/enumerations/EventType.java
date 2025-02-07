package com.mangopay.core.enumerations;

/**
 * Event types enumeration.
 */
public enum EventType {

    ALL,

    PAYIN_NORMAL_CREATED,
    PAYIN_NORMAL_SUCCEEDED,
    PAYIN_NORMAL_FAILED,

    PAYOUT_NORMAL_CREATED,
    PAYOUT_NORMAL_SUCCEEDED,
    PAYOUT_NORMAL_FAILED,

    TRANSFER_NORMAL_CREATED,
    TRANSFER_NORMAL_SUCCEEDED,
    TRANSFER_NORMAL_FAILED,

    PAYIN_REFUND_CREATED,
    PAYIN_REFUND_SUCCEEDED,
    PAYIN_REFUND_FAILED,

    PAYOUT_REFUND_CREATED,
    PAYOUT_REFUND_SUCCEEDED,
    PAYOUT_REFUND_FAILED,

    TRANSFER_REFUND_CREATED,
    TRANSFER_REFUND_SUCCEEDED,
    TRANSFER_REFUND_FAILED,

    KYC_CREATED,
    KYC_VALIDATION_ASKED,
    KYC_SUCCEEDED,
    KYC_FAILED,
    KYC_OUTDATED,

    PAYIN_REPUDIATION_CREATED,
    PAYIN_REPUDIATION_SUCCEEDED,
    PAYIN_REPUDIATION_FAILED,

    DISPUTE_DOCUMENT_CREATED,
    DISPUTE_DOCUMENT_VALIDATION_ASKED,
    DISPUTE_DOCUMENT_SUCCEEDED,
    DISPUTE_DOCUMENT_FAILED,
    DISPUTE_CREATED,
    DISPUTE_SUBMITTED,
    DISPUTE_ACTION_REQUIRED,
    DISPUTE_FURTHER_ACTION_REQUIRED,
    DISPUTE_CLOSED,
    DISPUTE_SENT_TO_BANK,

    TRANSFER_SETTLEMENT_CREATED,
    TRANSFER_SETTLEMENT_SUCCEEDED,
    TRANSFER_SETTLEMENT_FAILED,

    MANDATE_CREATED,
    MANDATE_FAILED,
    MANDATE_ACTIVATED,
    MANDATE_SUBMITTED,
    MANDATE_EXPIRED,

    PREAUTHORIZATION_PAYMENT_WAITING,
    PREAUTHORIZATION_PAYMENT_EXPIRED,
    PREAUTHORIZATION_PAYMENT_CANCELED,
    PREAUTHORIZATION_PAYMENT_VALIDATED,

    UBO_DECLARATION_CREATED, 
    UBO_DECLARATION_VALIDATION_ASKED, 
    UBO_DECLARATION_REFUSED, 
    UBO_DECLARATION_VALIDATED, 
    UBO_DECLARATION_INCOMPLETE,

    USER_KYC_REGULAR,
    USER_KYC_LIGHT,

    USER_INFLOWS_BLOCKED,
    USER_INFLOWS_UNBLOCKED,
    USER_OUTFLOWS_BLOCKED,
    USER_OUTFLOWS_UNBLOCKED,

    PREAUTHORIZATION_CREATED,
    PREAUTHORIZATION_SUCCEEDED,
    PREAUTHORIZATION_FAILED,

    INSTANT_PAYOUT_FAILED,
    INSTANT_PAYOUT_SUCCEEDED,
    INSTANT_PAYOUT_FALLBACKED,

    DEPOSIT_PREAUTHORIZATION_CREATED,
    DEPOSIT_PREAUTHORIZATION_FAILED,
    DEPOSIT_PREAUTHORIZATION_PAYMENT_WAITING,
    DEPOSIT_PREAUTHORIZATION_PAYMENT_EXPIRED,
    DEPOSIT_PREAUTHORIZATION_PAYMENT_CANCEL_REQUESTED,
    DEPOSIT_PREAUTHORIZATION_PAYMENT_CANCELED,
    DEPOSIT_PREAUTHORIZATION_PAYMENT_VALIDATED,

    CARD_VALIDATION_CREATED,
    CARD_VALIDATION_FAILED,
    CARD_VALIDATION_SUCCEEDED,

    VIRTUAL_ACCOUNT_ACTIVE,
    VIRTUAL_ACCOUNT_BLOCKED,
    VIRTUAL_ACCOUNT_CLOSED,
    VIRTUAL_ACCOUNT_FAILED,

    IDENTITY_VERIFICATION_VALIDATED,
    IDENTITY_VERIFICATION_FAILED,
    IDENTITY_VERIFICATION_INCONCLUSIVE,
    IDENTITY_VERIFICATION_OUTDATED,
    IDENTITY_VERIFICATION_TIMEOUT
}
