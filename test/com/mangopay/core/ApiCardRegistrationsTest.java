package com.mangopay.core;

import com.mangopay.entities.CardRegistration;
import com.mangopay.entities.UserNatural;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiCardRegistrations test methods.
 */
public class ApiCardRegistrationsTest extends BaseTest {
    
    @Test
    public void test_CardRegistrations_Create() throws Exception {
        CardRegistration cardRegistration = this.getJohnsCardRegistration();
        UserNatural user = this.getJohn();

        assertNotNull(cardRegistration.Id);
        assertTrue(cardRegistration.Id.length() > 0);

        assertNotNull(cardRegistration.AccessKey);
        assertNotNull(cardRegistration.PreregistrationData);
        assertNotNull(cardRegistration.CardRegistrationURL);
        assertEquals(user.Id, cardRegistration.UserId);
        assertEquals("EUR", cardRegistration.Currency);
        assertEquals("CREATED", cardRegistration.Status);
    }
    
    @Test
    public void test_CardRegistrations_Get() throws Exception {
        CardRegistration cardRegistration = this.getJohnsCardRegistration();

        CardRegistration getCardRegistration = this._api.CardRegistrations.get(cardRegistration.Id);
        
        assertTrue(getCardRegistration.Id.length() > 0);
        assertEquals(cardRegistration.Id, getCardRegistration.Id);
    }
    
    @Test
    public void test_CardRegistrations_Update() throws Exception {
        CardRegistration cardRegistration = this.getJohnsCardRegistration();
        cardRegistration.RegistrationData = "test RegistrationData";

        CardRegistration getCardRegistration = this._api.CardRegistrations.update(cardRegistration);
        
        assertEquals("test RegistrationData", getCardRegistration.RegistrationData);
    }
    
}
