package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.interfaces.BankAccountDetails;

/**
 * Class represents OTHER type of bank account.
 */
public class BankAccountDetailsOTHER extends Dto implements BankAccountDetails {
    
    /**
     * Type.
     */
    //public String Type;
    
    /**
     * The Country associated to the BankAccount.
     */
    @SerializedName("Country")
    private CountryIso country;
    
    /**
     * Valid BIC format.
     */
    @SerializedName("BIC")
    private String bic;
    
    /**
     * Account number.
     */
    @SerializedName("AccountNumber")
    private String accountNumber;

    public CountryIso getCountry() {
        return country;
    }

    public void setCountry(CountryIso country) {
        this.country = country;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
