package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankAccountDetails;

/**
 * Class represents IBAN type of bank account.
 */
public class BankAccountDetailsIBAN extends Dto implements BankAccountDetails {

    /**
     * IBAN number.
     *
     * @deprecated Use {@link #getIBAN()} and {@link #setIBAN(String)} instead.
     */
    @Deprecated
    public String IBAN;

    /**
     * BIC.
     *
     * @deprecated Use {@link #getBIC()} and {@link #setBIC(String)} instead.
     */
    @Deprecated
    public String BIC;

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }
}
