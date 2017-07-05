package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankAccountDetails;

/**
 * Class represents CA type of bank account.
 */
public class BankAccountDetailsCA extends Dto implements BankAccountDetails {

    /**
     * Bank name.
     */
    @SerializedName("BankName")
    private String bankName;

    /**
     * Institution number.
     */
    @SerializedName("InstitutionNumber")
    private String institutionNumber;

    /**
     * Branch code.
     */
    @SerializedName("BranchCode")
    private String branchCode;

    /**
     * Account number.
     */
    @SerializedName("AccountNumber")
    private String accountNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getInstitutionNumber() {
        return institutionNumber;
    }

    public void setInstitutionNumber(String institutionNumber) {
        this.institutionNumber = institutionNumber;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
