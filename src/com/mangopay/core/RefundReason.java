package com.mangopay.core;

/**
 * Class represents reason of refund.
 */
public class RefundReason extends Dto {
    
    /**
     * Message.
     */
    public String RefundReasonMessage;
    
    /**
     * Type of refund reason { BANKACCOUNT_INCORRECT, 
     *      BANKACCOUNT_HAS_BEEN_CLOSED, OWNER_DOT_NOT_MATCH_BANKACCOUNT, 
     *      WITHDRAWAL_IMPOSSIBLE_ON_SAVINGS_ACCOUNTS, INITIALIZED_BY_CLIENT, 
     *      OTHER }.
     */
    public String RefundReasonType;
}
