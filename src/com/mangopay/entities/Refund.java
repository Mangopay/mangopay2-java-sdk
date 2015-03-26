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
     * Initial transaction type.
     */
    public String InitialTransactionType;
    
    /**
     * Debited wallet identifier.
     */
    public String DebitedWalletId;
    
    /**
     * Credited wallet identifier.
     */
    public String CreditedWalletId;
    
}
