package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankAccountDetails;
import com.mangopay.core.enumerations.CountryIso;

/**
 * Class represents OTHER type of bank account.
 */
public class BankAccountDetailsOTHER extends Dto implements BankAccountDetails {
    
    /**
     * type.
     */
    //public String type;
    
    /**
     * The country associated to the BankAccount.
     */
    @SerializedName("country")
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
