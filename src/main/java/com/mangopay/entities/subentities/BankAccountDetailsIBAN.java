package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankAccountDetails;

/**
 * Class represents IBAN type of bank account.
 */
public class BankAccountDetailsIBAN extends Dto implements BankAccountDetails {

    /**
     * IBAN number.
     */
    @SerializedName("IBAN")
    private String iban;

    /**
     * BIC.
     */
    @SerializedName("BIC")
    private String bic;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
