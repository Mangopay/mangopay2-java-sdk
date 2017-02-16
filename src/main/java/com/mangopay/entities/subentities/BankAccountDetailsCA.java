package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.BankAccountDetails;

/**
 * Class represents CA type of bank account.
 */
public class BankAccountDetailsCA extends Dto implements BankAccountDetails {

    /**
     * Bank name.
     *
     * @deprecated Use {@link #getBankName()} and {@link #setBankName(String)} instead.
     */
    @Deprecated
    public String BankName;

    /**
     * Institution number.
     *
     * @deprecated Use {@link #getInstitutionNumber()} and {@link #setInstitutionNumber(String)} instead.
     */
    @Deprecated
    public String InstitutionNumber;

    /**
     * Branch code.
     *
     * @deprecated Use {@link #getBranchCode()} and {@link #setBranchCode(String)} instead.
     */
    @Deprecated
    public String BranchCode;

    /**
     * Account number.
     *
     * @deprecated Use {@link #getAccountNumber()} and {@link #setAccountNumber(String)} instead.
     */
    @Deprecated
    public String AccountNumber;

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        this.BankName = bankName;
    }

    public String getInstitutionNumber() {
        return InstitutionNumber;
    }

    public void setInstitutionNumber(String institutionNumber) {
        this.InstitutionNumber = institutionNumber;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String branchCode) {
        this.BranchCode = branchCode;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.AccountNumber = accountNumber;
    }
}
