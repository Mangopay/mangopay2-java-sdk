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
     * Initialized by Mangopay.
     */
    INITIALIZED_BY_MANGOPAY,

    AG01_FORBIDDEN_TRANSACTION,

    AC06_BLOCKED_BANKACCOUNT,  
    
    AG02_INVALID_BANK_OPERATION,  
        
    AM05_DUPLICATE_PAYMENT,  
        
    BE04_BENEFICIARY_ADDRESS_MISSING,  
        
    CNOR_INVALID_BIC,  
        
    ERIN_REMITTANCE_INFO_NOT_SUPPORTED,  
        
    MD07_BENEFICIARY_IS_DECEASED,  
        
    MS02_BENEFICIARY_ORDER,  
        
    MS03_NOT_SPECIFIED,  
        
    RC01_INVALIDE_BIC,  
        
    RR01_REGULATORY_REASON,  
        
    RR02_REGULATORY_REASON,  
        
    RR03_BENEFICIARY_NAME_OR_ADDRESS_MISSING,  
        
    RR04_REGULATORY_REASON,  
        
    ED05_SETTLEMENT_FAILED,  
        
    FF01_INVALID_FILE_FORMAT,  
        
    TM01_CUT_OFF_TIME,  
        
    DNOR_DEBTOR_BANK_NOT_REGISTERED,  
        
    FOCR_RECALLED,  
        
    CB,  

    /**
     * Other.
     */
    OTHER
}
