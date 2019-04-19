package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CountryIso;

public class Birthplace extends Dto {

    /**
     * City.
     */
    @SerializedName("City")
    private String city;

    /**
     * Country.
     */
    @SerializedName("Country")
    private CountryIso country;

    public Birthplace(String city, CountryIso country) {
        this.city=city;
        this.country=country;
    }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public CountryIso getCountry() { return country; }

    public void setCountry(CountryIso country) { this.country = country; }
}
