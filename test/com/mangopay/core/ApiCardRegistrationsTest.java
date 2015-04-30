package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.CardRegistration;
import com.mangopay.entities.TemporaryPaymentCard;
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
        assertTrue(cardRegistration.Currency == CurrencyIso.EUR);
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
        String registrationData = this.getPaylineCorrectRegistartionData(cardRegistration);
        cardRegistration.RegistrationData = registrationData;
        
        CardRegistration getCardRegistration = this._api.CardRegistrations.update(cardRegistration);
        
        assertEquals(registrationData, getCardRegistration.RegistrationData);
        assertNotNull(getCardRegistration.CardId);
        assertEquals("VALIDATED", getCardRegistration.Status);
        assertEquals("000000", getCardRegistration.ResultCode);
    }
    
    
    /* The two tests below are added to cover temporary use cases, which will be
     * removed in future. */
    
    @Test
    public void test_TemporaryPaymentCard_Create() throws Exception {
        UserNatural user = this.getJohn();
        TemporaryPaymentCard paymentCard = new TemporaryPaymentCard();
        paymentCard.UserId = user.Id;
        paymentCard.Tag = "Test tag";
        paymentCard.Culture = "FR";
        paymentCard.ReturnURL = "http://test.com/test";
        paymentCard.TemplateURL = "https://test.com/test";
                       
        TemporaryPaymentCard paymentCardCreated = this._api.Cards.createTemporaryPaymentCard(paymentCard);
        
        assertTrue(paymentCardCreated.Id.length() > 0);
        assertEquals(paymentCardCreated.UserId, user.Id);
    }
    
    @Test
    public void test_TemporaryPaymentCard_Get() throws Exception {
        UserNatural user = this.getJohn();
        TemporaryPaymentCard paymentCard = new TemporaryPaymentCard();
        paymentCard.UserId = user.Id;
        paymentCard.Tag = "Test tag";
        paymentCard.Culture = "FR";
        paymentCard.ReturnURL = "http://test.com/test";
        paymentCard.TemplateURL = "https://test.com/test";
        TemporaryPaymentCard paymentCardCreated = this._api.Cards.createTemporaryPaymentCard(paymentCard);
        
        TemporaryPaymentCard paymentCardGet = this._api.Cards.getTemporaryPaymentCard(paymentCardCreated.Id);
        
        assertTrue(paymentCardGet.Id.length() > 0);
        assertEquals(paymentCardGet.Id, paymentCardCreated.Id);
    }
}
