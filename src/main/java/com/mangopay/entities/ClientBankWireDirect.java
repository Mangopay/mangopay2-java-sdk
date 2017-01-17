package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;

/**
 * Client bankwire direct entity.
 */
public class ClientBankWireDirect extends EntityBase {

    /**
     * Declared debited funds.
     *
     * @deprecated Use {@link #getDeclaredDebitedFunds()} and {@link #setDeclaredDebitedFunds(Money)} instead.
     */
    @Deprecated
    public Money DeclaredDebitedFunds;

    /**
     * Credited wallet alias.
     *
     * @deprecated Use {@link #getCreditedWalletId()} and {@link #setCreditedWalletId(String)} instead.
     */
    @Deprecated
    public String CreditedWalletId;

    public ClientBankWireDirect(String creditedWalletAlias, Money declaredDebitedFunds) {
        this.CreditedWalletId = creditedWalletAlias;
        this.DeclaredDebitedFunds = declaredDebitedFunds;
    }

    public Money getDeclaredDebitedFunds() {
        return DeclaredDebitedFunds;
    }

    public void setDeclaredDebitedFunds(Money declaredDebitedFunds) {
        this.DeclaredDebitedFunds = declaredDebitedFunds;
    }

    public String getCreditedWalletId() {
        return CreditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.CreditedWalletId = creditedWalletId;
    }
}
