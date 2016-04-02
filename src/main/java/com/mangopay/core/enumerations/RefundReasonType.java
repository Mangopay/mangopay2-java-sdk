package com.mangopay.core.enumerations;

/**
 * Refund reason type enumeration.
 */
public enum RefundReasonType {
    
    /**
     * Not specified.
     */
    NotSpecified,

    /**
     * Incorrect bank account.
     */
    BANKACCOUNT_INCORRECT, 

    /**
     * Closed bank account.
     */
    BANKACCOUNT_HAS_BEEN_CLOSED, 

    /**
     * Owner-bank account mismatch.
     */
    OWNER_DOT_NOT_MATCH_BANKACCOUNT, 

    /**
     * Withdrawal impossible on savings accounts.
     */
    WITHDRAWAL_IMPOSSIBLE_ON_SAVINGS_ACCOUNTS, 

    /**
     * Initialized by client.
     */
    INITIALIZED_BY_CLIENT, 

    /**
     * Other.
     */
    OTHER
}
