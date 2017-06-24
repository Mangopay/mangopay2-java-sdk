/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.entities.subentities;

import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.core.interfaces.PayInExecutionDetails;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Hector Espert hespert@peertopark.com
 */
public class PayInExecutionDetailsDirectTest {

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
     * Test of build method, of class PayInExecutionDetailsDirect.
     */
    @Test
    public void testBuild_String_String() {
        String cardId = "CARDID";
        String secureModeReturnURL = "RETURNURL";
        PayInExecutionDetailsDirect executionDetailsDirect = PayInExecutionDetailsDirect.build(cardId, secureModeReturnURL);
        assertNotNull(executionDetailsDirect);
        assertEquals(cardId, executionDetailsDirect.getCardId());
        assertEquals(secureModeReturnURL, executionDetailsDirect.getSecureModeReturnUrl());
    }

    /**
     * Test of build method, of class PayInExecutionDetailsDirect.
     */
    @Test
    public void testBuild_3args() {
        String cardId = "CARDID";
        SecureMode secureMode = SecureMode.DEFAULT;
        String secureModeReturnURL = "RETURNURL";
        PayInExecutionDetailsDirect executionDetailsDirect = PayInExecutionDetailsDirect.build(cardId, secureMode, secureModeReturnURL);
        assertNotNull(executionDetailsDirect);
        assertEquals(cardId, executionDetailsDirect.getCardId());
        assertEquals(secureMode, executionDetailsDirect.getSecureMode());
        assertEquals(secureModeReturnURL, executionDetailsDirect.getSecureModeReturnUrl());
    }

    @Test
    public void testIsSecureModeNeeded() {
        PayInExecutionDetailsDirect executionDetailsDirect = new PayInExecutionDetailsDirect();
        assertFalse(executionDetailsDirect.isSecureModeNeeded());
        executionDetailsDirect.setSecureModeNeeded("False");
        assertFalse(executionDetailsDirect.isSecureModeNeeded());
        executionDetailsDirect.setSecureModeNeeded("True");
        assertTrue(executionDetailsDirect.isSecureModeNeeded());
    }


    @Test
    public void testConvert() throws Exception {
        PayInExecutionDetailsDirect executionDetailsDirect = new PayInExecutionDetailsDirect();
        assertNotNull(executionDetailsDirect);
        PayInExecutionDetails payInExecutionDetails = executionDetailsDirect;
        assertNotNull(payInExecutionDetails);
        executionDetailsDirect = PayInExecutionDetailsDirect.convert(payInExecutionDetails);
        assertNotNull(executionDetailsDirect);
    }

}
