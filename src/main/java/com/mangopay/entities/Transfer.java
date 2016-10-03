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

    @Override
    public String toString() {
        return "Transfer{" + "Id=" + super.Id + ", DebitedWalletId=" + DebitedWalletId + ", CreditedWalletId=" + CreditedWalletId + ", Status=" + super.Status + ", ResultCode=" + super.ResultCode + ", ResultMessage=" + super.ResultMessage + '}';
    }
}
