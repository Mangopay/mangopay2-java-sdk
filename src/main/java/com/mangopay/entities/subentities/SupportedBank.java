package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.List;

public class SupportedBank extends Dto {
    @SerializedName("Countries")
    private List<BanksByCountry> countries;

    public List<BanksByCountry> getCountries() {
        return countries;
    }

    public SupportedBank setCountries(List<BanksByCountry> countries) {
        this.countries = countries;
        return this;
    }
}
