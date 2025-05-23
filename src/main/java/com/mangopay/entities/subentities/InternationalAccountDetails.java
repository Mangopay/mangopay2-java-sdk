package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class InternationalAccountDetails extends Dto {

    @SerializedName("Address")
    private VirtualAccountAddress address;

    @SerializedName("Account")
    private InternationalAccount account;

    @SerializedName("BankName")
    private String bankName;

    public InternationalAccountDetails(VirtualAccountAddress address, InternationalAccount account) {
        this.address = address;
        this.account = account;
    }

    public VirtualAccountAddress getAddress() {
        return address;
    }

    public InternationalAccountDetails setAddress(VirtualAccountAddress address) {
        this.address = address;
        return this;
    }

    public InternationalAccount getAccount() {
        return account;
    }

    public InternationalAccountDetails setAccount(InternationalAccount account) {
        this.account = account;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public InternationalAccountDetails setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }
}
