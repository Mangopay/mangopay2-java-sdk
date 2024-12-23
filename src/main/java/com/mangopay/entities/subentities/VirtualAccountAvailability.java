package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CurrencyIso;

import java.util.List;

public class VirtualAccountAvailability extends EntityBase {

    @SerializedName("Country")
    private String country;

    @SerializedName("Available")
    private Boolean available;

    @SerializedName("Currencies")
    private List<CurrencyIso> currencies;

    public String getCountry() {
        return country;
    }

    public VirtualAccountAvailability setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public VirtualAccountAvailability setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public List<CurrencyIso> getCurrencies() {
        return currencies;
    }

    public VirtualAccountAvailability setCurrencies(List<CurrencyIso> currencies) {
        this.currencies = currencies;
        return this;
    }
}
