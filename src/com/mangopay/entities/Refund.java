package com.mangopay.entities;

/**
 * Refund entity.
 */
public class Refund extends Transaction {
    
    /**
     * Initial transaction identifier.
     */
    public String InitialTransactionId;
    
    /**
     * Debited wallet identifier.
     */
    public String DebitedWalletId;
    
    /**
     * Credited wallet identifier.
     */
    public String CreditedWalletId;
    
}
