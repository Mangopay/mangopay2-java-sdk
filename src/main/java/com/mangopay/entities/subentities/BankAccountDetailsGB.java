package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankAccountDetails;

/**
 * Class represents GB type of bank account.
 */
public class BankAccountDetailsGB extends Dto implements BankAccountDetails {

    /**
     * Account number.
     */
    @SerializedName("AccountNumber")
    private String accountNumber;

    /**
     * Sort code.
     */
    @SerializedName("SortCode")
    private String sortCode;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }
}
