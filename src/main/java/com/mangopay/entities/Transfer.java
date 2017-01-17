package com.mangopay.entities;

/**
 * Transfer entity.
 */
public class Transfer extends Transaction {

    /**
     * Debited wallet identifier.
     *
     * @deprecated Use {@link #getDebitedWalletId()} and {@link #setDebitedWalletId(String)} instead.
     */
    @Deprecated
    public String DebitedWalletId;

    /**
     * Credited wallet identifier.
     *
     * @deprecated Use {@link #getCreditedWalletId()} and {@link #setCreditedWalletId(String)} instead.
     */
    @Deprecated
    public String CreditedWalletId;

    public String getDebitedWalletId() {
        return DebitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.DebitedWalletId = debitedWalletId;
    }

    public String getCreditedWalletId() {
        return CreditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.CreditedWalletId = creditedWalletId;
    }
}
