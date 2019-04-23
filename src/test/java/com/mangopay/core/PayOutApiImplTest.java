package com.mangopay.core;

import com.mangopay.core.enumerations.PayOutPaymentType;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.Refund;
import com.mangopay.entities.subentities.PayOutPaymentDetailsBankWire;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * PayOutApiImpl test methods
 */
public class PayOutApiImplTest extends BaseTest {

    @Test
    public void createBankWire() throws Exception {

        PayOut payOut = this.getJohnsPayOutBankWire();

        assertTrue(payOut.getId().length() > 0);
        assertSame(payOut.getPaymentType(), PayOutPaymentType.BANK_WIRE);
        assertTrue(payOut.getMeanOfPaymentDetails() instanceof PayOutPaymentDetailsBankWire);
    }

    @Test
    public void getPayOutRefunds() throws Exception {
        String payOutId = "38233499";//hardcoded and in sync with mangopay test database
        String expectedRefundId = "38239297";//hardcoded and in sync with mangopay test database
        PayOut payOut = this.api.getPayOutApi().get(payOutId);
        assertNotNull("PayOut object is null", payOut);

        List<Refund> refunds = this.api.getPayOutApi().getRefunds(payOutId);
        assertNotNull("Payout refunds api returns null", refunds);
        assertFalse("Payout refunds api returns empty list", refunds.isEmpty());
        assertTrue("Api returns more than 1 refund", refunds.size() == 1);
        assertTrue("Expected refund not found!", refunds.get(0).getId().equals(expectedRefundId));
    }

}
