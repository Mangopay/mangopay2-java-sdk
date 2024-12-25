package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class LocalAccount extends EntityBase {

    @SerializedName("AccountNumber")
    private String accountNumber;

    @SerializedName("SortCode")
    private String sortCode;

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
}
