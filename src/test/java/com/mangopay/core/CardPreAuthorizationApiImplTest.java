/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.CardPreAuthorization;
import com.mangopay.entities.subentities.BrowserInfo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CardPreAuthorizationApiImpl test methods.
 */
public class CardPreAuthorizationApiImplTest extends BaseTest {

    @Test
    public void createCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();

        assertTrue(!"".equals(cardPreAuthorization.getId()));
        assertTrue(cardPreAuthorization.getStatus() == PreAuthorizationStatus.SUCCEEDED);
        assertTrue(cardPreAuthorization.getPaymentStatus() == PaymentStatus.WAITING);
        assertTrue(cardPreAuthorization.getExecutionType() == PreAuthorizationExecutionType.DIRECT);
        assertTrue((cardPreAuthorization.getCulture()) == CultureCode.FR);
        assertNull(cardPreAuthorization.getPayInId());
        assertNotNull(cardPreAuthorization.getRemainingFunds());
    }

    @Test
    public void createCardPreAuthorizationWithBilling() throws Exception {
        CardPreAuthorization cardPreAuthorization = getPreAuthorization();
        Billing billing = new Billing();
        Address address = new Address();
        address.setCity("Halo");
        address.setAddressLine1("Street street");
        address.setCountry(CountryIso.FR);
        address.setPostalCode("65400");
        billing.setAddress(address);
        billing.setFirstName("John");
        billing.setLastName("Doe");
        cardPreAuthorization.setBilling(billing);

        cardPreAuthorization = this.api.getCardPreAuthorizationApi().create(cardPreAuthorization);

        assertNotNull(cardPreAuthorization.getSecurityInfo());
        assertNotNull(cardPreAuthorization.getSecurityInfo().getAvsResult());
        assertTrue(cardPreAuthorization.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
    }

    @Test
    public void createCardPreAuthorizationWithRequested3DSVersion() throws Exception {
        CardPreAuthorization cardPreAuthorization = getPreAuthorization();
        Billing billing = new Billing();
        Address address = new Address();
        address.setCity("Halo");
        address.setAddressLine1("Street street");
        address.setCountry(CountryIso.FR);
        address.setPostalCode("65400");
        billing.setAddress(address);
        billing.setFirstName("John");
        billing.setLastName("Doe");
        cardPreAuthorization.setBilling(billing);
        cardPreAuthorization.setRequested3DSVersion("V1");

        cardPreAuthorization = this.api.getCardPreAuthorizationApi().create(cardPreAuthorization);

        assertNotNull(cardPreAuthorization.getSecurityInfo());
        assertNotNull(cardPreAuthorization.getSecurityInfo().getAvsResult());
        assertTrue(cardPreAuthorization.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
        assertNotNull(cardPreAuthorization.getRequested3DSVersion());
    }

    @Test
    public void createCardPreAuthorizationWithBrowserInfo() throws Exception {
        CardPreAuthorization cardPreAuthorization = getPreAuthorization();
        cardPreAuthorization.setBrowserInfo(getNewBrowserInfo());

        cardPreAuthorization = this.api.getCardPreAuthorizationApi().create(cardPreAuthorization);

        assertNotNull(cardPreAuthorization.getSecurityInfo());
        assertNotNull(cardPreAuthorization.getSecurityInfo().getAvsResult());
        assertTrue(cardPreAuthorization.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
    }

    @Test
    public void createCardPreAuthorizationWithIpAddress() throws Exception {
        CardPreAuthorization cardPreAuthorization = getPreAuthorization();
        cardPreAuthorization.setIpAddress("2001:0620:0000:0000:0211:24FF:FE80:C12C");

        cardPreAuthorization = this.api.getCardPreAuthorizationApi().create(cardPreAuthorization);

        assertNotNull(cardPreAuthorization.getSecurityInfo());
        assertNotNull(cardPreAuthorization.getSecurityInfo().getAvsResult());
        assertTrue(cardPreAuthorization.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
    }

    @Test
    public void getCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();

        CardPreAuthorization getCardPreAuthorization = this.api.getCardPreAuthorizationApi().get(cardPreAuthorization.getId());

        assertEquals(cardPreAuthorization.getId(), getCardPreAuthorization.getId());
        assertNotNull(getCardPreAuthorization.getRemainingFunds());
        assertTrue(getCardPreAuthorization.getStatus() == PreAuthorizationStatus.SUCCEEDED);
        assertEquals("000000", getCardPreAuthorization.getResultCode());
    }

    @Test
    public void updateCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        cardPreAuthorization.setPaymentStatus(PaymentStatus.CANCELED);

        CardPreAuthorization resultCardPreAuthorization = this.api.getCardPreAuthorizationApi().update(cardPreAuthorization);

        assertTrue(resultCardPreAuthorization.getStatus() == PreAuthorizationStatus.SUCCEEDED);
        assertTrue(resultCardPreAuthorization.getPaymentStatus() == PaymentStatus.CANCELED);
        assertNotNull(resultCardPreAuthorization.getRemainingFunds());
    }

}
