package com.mangopay.core;

import com.mangopay.core.enumerations.CountryIso;

/**
 * Class represents an address.
 */
public class Address extends Dto {
    
    /**
     * Address line 1.
     */
    public String AddressLine1;

    /**
     * Address line 2.
     */
    public String AddressLine2;

    /**
     * City.
     */
    public String City;

    /**
     * Region.
     */
    public String Region;

    /**
     * Postal code.
     */
    public String PostalCode;

    /**
     * Country.
     */
    public CountryIso Country;
    
    /**
     * Helper method used internally.
     * @return
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
