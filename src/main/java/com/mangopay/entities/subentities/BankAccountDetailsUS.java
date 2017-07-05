package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.DepositAccountType;
import com.mangopay.core.interfaces.BankAccountDetails;

import static com.mangopay.core.enumerations.DepositAccountType.CHECKING;

/**
 * Class represents US type of bank account.
 */
public class BankAccountDetailsUS extends Dto implements BankAccountDetails {

    /**
     * Account number.
     */
    @SerializedName("AccountNumber")
    private String accountNumber;

    /**
     * ABA.
     */
    @SerializedName("ABA")
    private String aba;

    /**
     * Deposit account type.
     */
    @SerializedName("DepositAccountType")
    private DepositAccountType depositAccountType;

    /**
     * Instantiates new BankAccountDetailsUS object.
     */
    public BankAccountDetailsUS() {
        this.depositAccountType = CHECKING;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAba() {
        return aba;
    }

    public void setAba(String aba) {
        this.aba = aba;
    }

    public com.mangopay.core.enumerations.DepositAccountType getDepositAccountType() {
        return depositAccountType;
    }

    public void setDepositAccountType(com.mangopay.core.enumerations.DepositAccountType depositAccountType) {
        this.depositAccountType = depositAccountType;
    }
}
