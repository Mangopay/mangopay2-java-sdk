package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class VirtualAccountAddress extends EntityBase {

    @SerializedName("StreetName")
    private String streetName;

    @SerializedName("PostCode")
    private String postCode;

    @SerializedName("TownName")
    private String townName;

    @SerializedName("CountrySubDivision")
    private String countrySubDivision;

    @SerializedName("Country")
    private String country;

    public String getStreetName() {
        return streetName;
    }

    public VirtualAccountAddress setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public VirtualAccountAddress setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getTownName() {
        return townName;
    }

    public VirtualAccountAddress setTownName(String townName) {
        this.townName = townName;
        return this;
    }

    public String getCountrySubDivision() {
        return countrySubDivision;
    }

    public VirtualAccountAddress setCountrySubDivision(String countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public VirtualAccountAddress setCountry(String country) {
        this.country = country;
        return this;
    }
}
