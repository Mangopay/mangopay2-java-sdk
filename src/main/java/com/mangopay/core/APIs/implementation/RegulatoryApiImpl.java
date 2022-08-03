package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.RegulatoryApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.entities.CountryAuthorization;

import java.util.List;

public class RegulatoryApiImpl extends ApiBase implements RegulatoryApi {
    /**
     * Creates new API instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public RegulatoryApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public CountryAuthorization getCountryAuthorizations(CountryIso countryCode) throws Exception {
        return this.getObjectNoClientId(CountryAuthorization.class, "country_authorization_get", countryCode);
    }

    @Override
    public List<CountryAuthorization> getAllCountriesAuthorizations(Pagination pagination, Sorting sorting) throws Exception {
        return this.getListNoClientId(CountryAuthorization[].class, CountryAuthorization.class, "country_authorization_all", pagination, sorting);
    }
}
