package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.List;

public class Bank extends Dto {
    @SerializedName("BankName")
    private String bankName;

    @SerializedName("Scheme")
    private List<String> scheme;

    @SerializedName("Name")
    private String name;

    public String getBankName() {
        return bankName;
    }

    public Bank setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public List<String> getScheme() {
        return scheme;
    }

    public Bank setScheme(List<String> scheme) {
        this.scheme = scheme;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bank setName(String name) {
        this.name = name;
        return this;
    }
}
