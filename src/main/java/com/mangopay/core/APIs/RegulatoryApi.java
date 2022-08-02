package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.entities.CountryAuthorization;

import java.util.List;

public interface RegulatoryApi {
    /**
     * View the restrictions for a specific country
     */
    CountryAuthorization getCountryAuthorizations(CountryIso countryCode) throws Exception;

    /**
     * View the restrictions of all the countries
     */
    List<CountryAuthorization> getAllCountriesAuthorizations(Pagination pagination, Sorting sorting) throws Exception;
}
