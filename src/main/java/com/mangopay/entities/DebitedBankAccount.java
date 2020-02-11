package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.BankAccountType;

/**
 * Debited bank account object.
 */
public class DebitedBankAccount extends Dto {

    /**
     * Name of the account's owner.
     */
    @SerializedName("OwnerName")
    private String ownerName;

    /**
     * Number of the account.
     */
    @SerializedName("AccountNumber")
    private String accountNumber;

    /**
     * IBAN
     */
    @SerializedName("IBAN")
    private String iban;

    /**
     * BIC
     */
    @SerializedName("BIC")
    private String bic;

    /**
     * Bank account type.
     */
    @SerializedName("Type")
    private BankAccountType type;

    public DebitedBankAccount(String ownerName, String accountNumber, String iban, String bic, BankAccountType type) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.iban = iban;
        this.bic = bic;
        this.type = type;
    }

    public DebitedBankAccount() {
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

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

    public BankAccountType getType() {
        return type;
    }

    public void setType(BankAccountType type) {
        this.type = type;
    }

}
