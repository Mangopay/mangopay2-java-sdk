package com.mangopay.core;

import com.mangopay.core.enumerations.CountryIso;

/**
 * Class represents an address.
 */
public class Address extends Dto {

    /**
     * Address line 1.
     *
     * @deprecated Use {@link #getAddressLine1()} and {@link #setAddressLine1(String)} instead.
     */
    @Deprecated
    public String AddressLine1;

    /**
     * Address line 2.
     *
     * @deprecated Use {@link #getAddressLine2()} and {@link #setAddressLine2(String)} instead.
     */
    @Deprecated
    public String AddressLine2;

    /**
     * City.
     *
     * @deprecated Use {@link #getCity()} and {@link #setCity(String)} instead.
     */
    @Deprecated
    public String City;

    /**
     * Region.
     *
     * @deprecated Use {@link #getRegion()} and {@link #setRegion(String)} instead.
     */
    @Deprecated
    public String Region;

    /**
     * Postal code.
     *
     * @deprecated Use {@link #getPostalCode()} and {@link #setPostalCode(String)} instead.
     */
    @Deprecated
    public String PostalCode;

    /**
     * Country.
     *
     * @deprecated Use {@link #getCountry()} and {@link #setCountry(CountryIso)} instead.
     */
    @Deprecated
    public CountryIso Country;

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.AddressLine2 = addressLine2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        this.Region = region;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        this.PostalCode = postalCode;
    }

    public CountryIso getCountry() {
        return Country;
    }

    public void setCountry(CountryIso country) {
        this.Country = country;
    }

    /**
     * Helper method used internally.
     *
     * @return True if the {@link Address} details are valid.
     */
    public Boolean isValid() {

        return AddressLine1 != null ||
                AddressLine2 != null ||
                City != null ||
                Region != null ||
                PostalCode != null ||
                (Country != null && Country != CountryIso.NotSpecified);

    }
}
