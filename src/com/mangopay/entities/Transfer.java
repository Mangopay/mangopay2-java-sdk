package com.mangopay.entities;

/**
 * Transfer entity.
 */
public class Transfer extends Transaction {
    
    /**
     * Debited wallet identifier.
     */
    public String DebitedWalletId;
    
    /**
     * Credited wallet identifier.
     */
    public String CreditedWalletId;
    
}
