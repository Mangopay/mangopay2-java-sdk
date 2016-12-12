/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.entities.subentities;

import com.mangopay.core.interfaces.IPayOutPaymentDetails;
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
public class PayOutPaymentDetailsBankWireTest {
    
    public PayOutPaymentDetailsBankWireTest() {
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
     * Test of build method, of class PayOutPaymentDetailsBankWire.
     */
    @Test
    public void testBuild_String() {
        String bankAccountId = "12345678";
        PayOutPaymentDetailsBankWire detailsBankWire = PayOutPaymentDetailsBankWire.build(bankAccountId);
        assertNotNull(detailsBankWire);
        assertEquals(bankAccountId, detailsBankWire.BankAccountId);
    }

    /**
     * Test of build method, of class PayOutPaymentDetailsBankWire.
     */
    @Test
    public void testBuild_String_String() {
        String bankAccountId = "12345678";
        String bankWireRef = "WireRef";
        PayOutPaymentDetailsBankWire detailsBankWire = PayOutPaymentDetailsBankWire.build(bankAccountId, bankWireRef);
        assertNotNull(detailsBankWire);
        assertEquals(bankAccountId, detailsBankWire.BankAccountId);
        assertEquals(bankWireRef, detailsBankWire.BankWireRef);
    }
    
    
    @Test
    public void testConvert() throws Exception {
        PayOutPaymentDetailsBankWire payOutPaymentDetailsBankWire = new PayOutPaymentDetailsBankWire();
        assertNotNull(payOutPaymentDetailsBankWire);
        IPayOutPaymentDetails payOutPaymentDetails = payOutPaymentDetailsBankWire;
        assertNotNull(payOutPaymentDetails);
        payOutPaymentDetailsBankWire = PayOutPaymentDetailsBankWire.convert(payOutPaymentDetails);
        assertNotNull(payOutPaymentDetailsBankWire);
    }
    
}
