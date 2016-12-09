/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.entities.subentities;

import com.mangopay.core.enumerations.SecureMode;
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
        assertEquals(cardId, executionDetailsDirect.CardId);
        assertEquals(secureModeReturnURL, executionDetailsDirect.SecureModeReturnURL);
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
        assertEquals(cardId, executionDetailsDirect.CardId);
        assertEquals(secureMode, executionDetailsDirect.SecureMode);
        assertEquals(secureModeReturnURL, executionDetailsDirect.SecureModeReturnURL);
    }
    
}
