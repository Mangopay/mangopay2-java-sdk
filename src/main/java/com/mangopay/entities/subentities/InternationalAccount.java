package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class InternationalAccount extends Dto {

    @SerializedName("IBAN")
    private String iban;

    @SerializedName("BIC")
    private String bic;

    public InternationalAccount(String iban, String bic) {
        this.iban = iban;
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public InternationalAccount setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public InternationalAccount setBic(String bic) {
        this.bic = bic;
        return this;
    }
}
