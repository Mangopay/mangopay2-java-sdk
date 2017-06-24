package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.CountryIso;

/**
 * Class represents an address.
 */
public class Address extends Dto {

    /**
     * Address line 1.
     */
    @SerializedName("AddressLine1")
    private String addressLine1;

    /**
     * Address line 2.
     */
    @SerializedName("AddressLine2")
    private String addressLine2;

    /**
     * City.
     */
    @SerializedName("City")
    private String city;

    /**
     * Region.
     */
    @SerializedName("Region")
    private String region;

    /**
     * Postal code.
     */
    @SerializedName("PostalCode")
    private String postalCode;

    /**
     * Country.
     */
    @SerializedName("Country")
    public CountryIso country;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CountryIso getCountry() {
        return country;
    }

    public void setCountry(CountryIso country) {
        this.country = country;
    }

    /**
     * Helper method used internally.
     *
     * @return True if the {@link Address} details are valid.
     */
    public Boolean isValid() {

        return addressLine1 != null ||
                addressLine2 != null ||
                city != null ||
                region != null ||
                postalCode != null ||
                (country != null && country != CountryIso.NotSpecified);

    }
}
