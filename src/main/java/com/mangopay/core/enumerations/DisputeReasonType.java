package com.mangopay.core.enumerations;

/**
 * Dispute reason type enumeration.
 */
public enum DisputeReasonType {
    
    /**
     * DUPLICATE dispute reason type.
     */
    DUPLICATE,
    
    /**
     * FRAUD dispute reason type.
     */
    FRAUD, 
    
    /**
     * PRODUCT_UNACCEPTABLE dispute reason type.
     */
    PRODUCT_UNACCEPTABLE, 
    
    /**
     * UNKNOWN dispute reason type.
     */
    UNKNOWN, 
    
    /**
     * OTHER dispute reason type.
     */
    OTHER, 
    
    /**
     * REFUND_CONVERSION_RATE dispute reason type.
     */
    REFUND_CONVERSION_RATE,
    
    /**
     * LATE_FAILURE_INSUFFICIENT_FUNDS dispute reason type.
     */
    LATE_FAILURE_INSUFFICIENT_FUNDS,
    
    /**
     * LATE_FAILURE_CONTACT_USER dispute reason type.
     */
    LATE_FAILURE_CONTACT_USER,
        
    /**
     * LATE_FAILURE_BANKACCOUNT_CLOSED dispute reason type.
     */
    LATE_FAILURE_BANKACCOUNT_CLOSED,
        
    /**
     * LATE_FAILURE_BANKACCOUNT_INCOMPATIBLE dispute reason type.
     */
    LATE_FAILURE_BANKACCOUNT_INCOMPATIBLE,
        
    /**
     * LATE_FAILURE_BANKACCOUNT_INCORRECT dispute reason type.
     */
    LATE_FAILURE_BANKACCOUNT_INCORRECT,
    
    /**
     * AUTHORISATION_DISPUTED dispute reason type.
     */
    AUTHORISATION_DISPUTED,
    
    /**
    * TRANSACTION_NOT_RECOGNIZED dispute reason type
    */
    TRANSACTION_NOT_RECOGNIZED,

    /**
    * PRODUCT_NOT_PROVIDED dispute reason type
    */
    PRODUCT_NOT_PROVIDED,

    /**
    * CANCELED_REOCCURING_TRANSACTION dispute reason type
    */
    CANCELED_REOCCURING_TRANSACTION,
	
    /**
    * REFUND_NOT_PROCESSED dispute reason type
    */
    REFUND_NOT_PROCESSED,
    
    /**
    * COUNTERFEIT_PRODUCT dispute reason type
    */   
    COUNTERFEIT_PRODUCT

}
