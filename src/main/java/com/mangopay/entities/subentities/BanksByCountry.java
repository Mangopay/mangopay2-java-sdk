package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CountryIso;

import java.util.List;

public class BanksByCountry extends Dto {
    @SerializedName("Banks")
    private List<Bank> banks;

    @SerializedName("Country")
    private CountryIso country;

    public List<Bank> getBanks() {
        return banks;
    }

    public BanksByCountry setBanks(List<Bank> banks) {
        this.banks = banks;
        return this;
    }

    public CountryIso getCountry() {
        return country;
    }

    public BanksByCountry setCountry(CountryIso country) {
        this.country = country;
        return this;
    }
}
