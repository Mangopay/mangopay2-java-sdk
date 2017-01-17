/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.entities.subentities;

import com.mangopay.core.interfaces.PayOutPaymentDetails;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
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
        assertEquals(bankAccountId, detailsBankWire.getBankAccountId());
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
        assertEquals(bankAccountId, detailsBankWire.getBankAccountId());
        assertEquals(bankWireRef, detailsBankWire.getBankWireRef());
    }


    @Test
    public void testConvert() throws Exception {
        PayOutPaymentDetailsBankWire payOutPaymentDetailsBankWire = new PayOutPaymentDetailsBankWire();
        assertNotNull(payOutPaymentDetailsBankWire);
        PayOutPaymentDetails payOutPaymentDetails = payOutPaymentDetailsBankWire;
        assertNotNull(payOutPaymentDetails);
        payOutPaymentDetailsBankWire = PayOutPaymentDetailsBankWire.convert(payOutPaymentDetails);
        assertNotNull(payOutPaymentDetailsBankWire);
    }

}
