package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class LocalAccount extends EntityBase {

    @SerializedName("AccountNumber")
    private String accountNumber;

    @SerializedName("SortCode")
    private String sortCode;

    @SerializedName("IBAN")
    private String iban;

    @SerializedName("BIC")
    private String bic;

    @SerializedName("AchNumber")
    private String achNumber;

    @SerializedName("FedWireNumber")
    private String fedWireNumber;

    @SerializedName("AccountType")
    private String accountType;

    @SerializedName("BranchCode")
    private String branchCode;

    @SerializedName("InstitutionNumber")
    private String institutionNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalAccount setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getSortCode() {
        return sortCode;
    }

    public LocalAccount setSortCode(String sortCode) {
        this.sortCode = sortCode;
        return this;
    }

    public String getAchNumber() {
        return achNumber;
    }

    public LocalAccount setAchNumber(String achNumber) {
        this.achNumber = achNumber;
        return this;
    }

    public String getFedWireNumber() {
        return fedWireNumber;
    }

    public LocalAccount setFedWireNumber(String fedWireNumber) {
        this.fedWireNumber = fedWireNumber;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public LocalAccount setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public LocalAccount setBranchCode(String branchCode) {
        this.branchCode = branchCode;
        return this;
    }

    public String getInstitutionNumber() {
        return institutionNumber;
    }

    public LocalAccount setInstitutionNumber(String institutionNumber) {
        this.institutionNumber = institutionNumber;
        return this;
    }

    public String getIban() {
        return iban;
    }

    public LocalAccount setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public LocalAccount setBic(String bic) {
        this.bic = bic;
        return this;
    }
}
