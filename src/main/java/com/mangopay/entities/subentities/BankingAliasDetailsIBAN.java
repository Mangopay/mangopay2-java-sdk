package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankingAliasDetails;

/**
 * Created by thepa on 08-Feb-17.
 */
public class BankingAliasDetailsIBAN extends Dto implements BankingAliasDetails {

    /**
     * The IBAN of the banking alias.
     */
    public String IBAN;
    /**
     * The BIC of the banking alias.
     */
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
