/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.entities.subentities;

import com.mangopay.core.Address;
import com.mangopay.core.enumerations.CardType;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.interfaces.PayInPaymentDetails;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hector Espert hespert@peertopark.com
 */
public class PayInPaymentDetailsCardTest {
    
    public PayInPaymentDetailsCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of build method, of class PayInPaymentDetailsCard.
     */
    @Test
    public void testBuild_CardType_String() {
        CardType cardType = CardType.CB_VISA_MASTERCARD;
        String cardId = "12345678";
        PayInPaymentDetailsCard paymentDetailsCard = PayInPaymentDetailsCard.build(cardType, cardId);
        assertNotNull(paymentDetailsCard);
        assertEquals(cardId, paymentDetailsCard.getCardId());
        assertEquals(cardType, paymentDetailsCard.getCardType());
    }

    /**
     * Test of build method, of class PayInPaymentDetailsCard.
     */
    @Test
    public void testBuild_3args() {
        String statementDescriptor = "statementDescriptor";
        CardType cardType = CardType.CB_VISA_MASTERCARD;
        String cardId = "12345678";
        Shipping shipping = new Shipping();
        Address result = new Address();

        result.setAddressLine1("Address line 1");
        result.setAddressLine2("Address line 2");
        result.setCity("City");
        result.setCountry(CountryIso.PL);
        result.setPostalCode("11222");
        result.setRegion("Region");

        shipping.setAddress(result);


        PayInPaymentDetailsCard paymentDetailsCard = PayInPaymentDetailsCard.build(cardType, cardId, statementDescriptor, shipping);
        assertNotNull(paymentDetailsCard);
        assertEquals(cardId, paymentDetailsCard.getCardId());
        assertEquals(cardType, paymentDetailsCard.getCardType());
        assertEquals(statementDescriptor, paymentDetailsCard.getStatementDescriptor());
    }
    
    @Test
    public void testConvert() throws Exception {
        PayInPaymentDetailsCard payInPaymentDetailsCard = new PayInPaymentDetailsCard();
        assertNotNull(payInPaymentDetailsCard);
        PayInPaymentDetails payInPaymentDetails = payInPaymentDetailsCard;
        assertNotNull(payInPaymentDetails);
        payInPaymentDetailsCard = PayInPaymentDetailsCard.convert(payInPaymentDetails);
        assertNotNull(payInPaymentDetailsCard);
    }
    
}
