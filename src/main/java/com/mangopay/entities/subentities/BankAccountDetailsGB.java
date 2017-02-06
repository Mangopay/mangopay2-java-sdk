package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankAccountDetails;

/**
 * Class represents GB type of bank account.
 */
public class BankAccountDetailsGB extends Dto implements BankAccountDetails {

    /**
     * Account number.
     *
     * @deprecated Use {@link #getAccountNumber()} and {@link #setAccountNumber(String)} instead.
     */
    @Deprecated
    public String AccountNumber;

    /**
     * Sort code.
     *
     * @deprecated Use {@link #getSortCode()} and {@link #setSortCode(String)} instead.
     */
    @Deprecated
    public String SortCode;

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.AccountNumber = accountNumber;
    }

    public String getSortCode() {
        return SortCode;
    }

    public void setSortCode(String sortCode) {
        this.SortCode = sortCode;
    }
}
