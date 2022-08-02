package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.entities.subentities.CountryAuthorizationData;

public class CountryAuthorization extends Dto {
    @SerializedName("CountryCode")
    private CountryIso countryCode;

    @SerializedName("CountryName")
    private String countryName;

    @SerializedName("Authorization")
    private CountryAuthorizationData authorization;

    @SerializedName("LastUpdate")
    private Long lastUpdate;

    public CountryIso getCountryCode() {
        return countryCode;
    }

    public CountryAuthorization setCountryCode(CountryIso countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public CountryAuthorization setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public CountryAuthorizationData getAuthorization() {
        return authorization;
    }

    public CountryAuthorization setAuthorization(CountryAuthorizationData authorization) {
        this.authorization = authorization;
        return this;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public CountryAuthorization setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
