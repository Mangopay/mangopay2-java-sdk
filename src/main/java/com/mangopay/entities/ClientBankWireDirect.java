package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;

/**
 * Client bankwire direct entity.
 */
public class ClientBankWireDirect extends EntityBase {
    
    public ClientBankWireDirect(String creditedWalletAlias, Money declaredDebitedFunds)
    {
        CreditedWalletId = creditedWalletAlias;
        DeclaredDebitedFunds = declaredDebitedFunds;
    }
    
    /**
     * Declared debited funds.
     */
    public Money DeclaredDebitedFunds;

    /**
     * Credited wallet alias.
     */
    public String CreditedWalletId;
}
