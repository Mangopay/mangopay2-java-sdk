package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;

/**
 * Client bankwire direct entity.
 */
public class ClientBankWireDirect extends EntityBase {

    /**
     * Declared debited funds.
     */
    @SerializedName("DeclaredDebitedFunds")
    private Money declaredDebitedFunds;

    /**
     * Credited wallet alias.
     */
    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    public ClientBankWireDirect(String creditedWalletAlias, Money declaredDebitedFunds) {
        this.creditedWalletId = creditedWalletAlias;
        this.declaredDebitedFunds = declaredDebitedFunds;
    }

    public Money getDeclaredDebitedFunds() {
        return declaredDebitedFunds;
    }

    public void setDeclaredDebitedFunds(Money declaredDebitedFunds) {
        this.declaredDebitedFunds = declaredDebitedFunds;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }
}
