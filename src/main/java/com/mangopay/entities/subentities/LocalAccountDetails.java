package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class LocalAccountDetails extends Dto {

    @SerializedName("Address")
    private VirtualAccountAddress address;

    @SerializedName("Account")
    private LocalAccount account;

    @SerializedName("BankName")
    private String bankName;

    public LocalAccountDetails(VirtualAccountAddress address, LocalAccount account) {
        this.address = address;
        this.account = account;
    }

    public VirtualAccountAddress getAddress() {
        return address;
    }

    public LocalAccountDetails setAddress(VirtualAccountAddress address) {
        this.address = address;
        return this;
    }


    public LocalAccount getAccount() {
        return account;
    }

    public LocalAccountDetails setAccount(LocalAccount account) {
        this.account = account;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public LocalAccountDetails setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }
}
