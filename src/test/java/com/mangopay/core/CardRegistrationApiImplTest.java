package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.CardRegistration;
import com.mangopay.entities.UserNatural;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CardRegistrationApiImpl test methods.
 */
public class CardRegistrationApiImplTest extends BaseTest {

    @Test
    public void createCardRegistration() throws Exception {
        CardRegistration cardRegistration_visa = this.getJohnsCardRegistration(CardType.CB_VISA_MASTERCARD);
        UserNatural user = this.getJohn();

        assertNotNull(cardRegistration_visa.getId());
        assertTrue(cardRegistration_visa.getId().length() > 0);

        assertNotNull(cardRegistration_visa.getAccessKey());
        assertNotNull(cardRegistration_visa.getPreregistrationData());
        assertNotNull(cardRegistration_visa.getCardRegistrationUrl());
        assertEquals(user.getId(), cardRegistration_visa.getUserId());
        assertTrue(cardRegistration_visa.getCurrency() == CurrencyIso.EUR);
        assertEquals("CREATED", cardRegistration_visa.getStatus());
        assertEquals(CardType.CB_VISA_MASTERCARD, cardRegistration_visa.getCardType());


        CardRegistration cardRegistration_maestro = this.getNewJohnsCardRegistration(CardType.MAESTRO);

        assertNotNull(cardRegistration_maestro.getId());
        assertTrue(cardRegistration_maestro.getId().length() > 0);

        assertNotNull(cardRegistration_maestro.getAccessKey());
        assertNotNull(cardRegistration_maestro.getPreregistrationData());
        assertNotNull(cardRegistration_maestro.getCardRegistrationUrl());
        assertEquals(user.getId(), cardRegistration_maestro.getUserId());
        assertTrue(cardRegistration_maestro.getCurrency() == CurrencyIso.EUR);
        assertEquals("CREATED", cardRegistration_maestro.getStatus());
        assertEquals(CardType.MAESTRO, cardRegistration_maestro.getCardType());
    }

    @Test
    public void getCardRegistration() throws Exception {
        CardRegistration cardRegistration = this.getJohnsCardRegistration();

        CardRegistration getCardRegistration = this.api.getCardRegistrationApi().get(cardRegistration.getId());

        assertTrue(getCardRegistration.getId().length() > 0);
        assertEquals(cardRegistration.getId(), getCardRegistration.getId());
    }

    @Test
    public void updateCardRegistration() throws Exception {
        CardRegistration cardRegistration = this.getJohnsCardRegistration();
        String registrationData = this.getPaylineCorrectRegistartionData(cardRegistration);
        cardRegistration.setRegistrationData(registrationData);

        CardRegistration getCardRegistration = this.api.getCardRegistrationApi().update(cardRegistration);

        assertEquals(registrationData, getCardRegistration.getRegistrationData());
        assertNotNull(getCardRegistration.getCardId());
        assertEquals("VALIDATED", getCardRegistration.getStatus());
        assertEquals("000000", getCardRegistration.getResultCode());
    }

}
