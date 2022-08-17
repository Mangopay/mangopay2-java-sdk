package com.mangopay.core;

import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.entities.CountryAuthorization;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RegulatoryApiImplTest extends BaseTest{

    @Test
    public void getCountryAuthorizations() throws Exception {
        CountryAuthorization countryAuthorization = this.api.getRegulatoryApi().getCountryAuthorizations(CountryIso.FR);

        assertNotNull(countryAuthorization);
        assertNotNull(countryAuthorization.getCountryCode());
        assertNotNull(countryAuthorization.getCountryName());
        assertNotNull(countryAuthorization.getAuthorization());
        assertNotNull(countryAuthorization.getAuthorization().getBlockBankAccountCreation());
        assertNotNull(countryAuthorization.getAuthorization().getBlockPayout());
        assertNotNull(countryAuthorization.getAuthorization().getBlockUserCreation());
        assertNotNull(countryAuthorization.getLastUpdate());
    }

    @Test
    public void getAllCountriesAuthorizations() throws Exception{
        Pagination pagination = new Pagination(1, 20);
        List<CountryAuthorization> countryAuthorizations = this.api.getRegulatoryApi().getAllCountriesAuthorizations(pagination, null);

        assertNotNull(countryAuthorizations);
        assertTrue(countryAuthorizations.size() > 0);

        assertNotNull(countryAuthorizations.get(0).getCountryCode());
        assertNotNull(countryAuthorizations.get(0).getCountryName());
        assertNotNull(countryAuthorizations.get(0).getAuthorization());
        assertNotNull(countryAuthorizations.get(0).getAuthorization().getBlockBankAccountCreation());
        assertNotNull(countryAuthorizations.get(0).getAuthorization().getBlockPayout());
        assertNotNull(countryAuthorizations.get(0).getAuthorization().getBlockUserCreation());
        assertNotNull(countryAuthorizations.get(0).getLastUpdate());
    }
}
