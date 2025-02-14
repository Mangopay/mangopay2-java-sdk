package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class RecipientAddressPropertySchema extends Dto {
    @SerializedName("AddressLine1")
    private RecipientPropertySchema addressLine1;

    @SerializedName("AddressLine2")
    private RecipientPropertySchema addressLine2;

    @SerializedName("City")
    private RecipientPropertySchema city;

    @SerializedName("Region")
    private RecipientPropertySchema region;

    @SerializedName("PostalCode")
    private RecipientPropertySchema postalCode;

    @SerializedName("Country")
    private RecipientPropertySchema country;

    public RecipientPropertySchema getAddressLine1() {
        return addressLine1;
    }

    public RecipientAddressPropertySchema setAddressLine1(RecipientPropertySchema addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public RecipientPropertySchema getAddressLine2() {
        return addressLine2;
    }

    public RecipientAddressPropertySchema setAddressLine2(RecipientPropertySchema addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public RecipientPropertySchema getCity() {
        return city;
    }

    public RecipientAddressPropertySchema setCity(RecipientPropertySchema city) {
        this.city = city;
        return this;
    }

    public RecipientPropertySchema getRegion() {
        return region;
    }

    public RecipientAddressPropertySchema setRegion(RecipientPropertySchema region) {
        this.region = region;
        return this;
    }

    public RecipientPropertySchema getPostalCode() {
        return postalCode;
    }

    public RecipientAddressPropertySchema setPostalCode(RecipientPropertySchema postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public RecipientPropertySchema getCountry() {
        return country;
    }

    public RecipientAddressPropertySchema setCountry(RecipientPropertySchema country) {
        this.country = country;
        return this;
    }
}
