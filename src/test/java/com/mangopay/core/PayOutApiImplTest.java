package com.mangopay.core;

import com.mangopay.core.enumerations.PayOutPaymentType;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.Refund;
import com.mangopay.entities.subentities.PayOutPaymentDetailsBankWire;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * PayOutApiImpl test methods
 */
public class PayOutApiImplTest extends BaseTest {

    @Test
    public void createBankWire() {
        try {
            PayIn payIn = this.getJohnsPayInCardWeb();
            PayOut payOut = this.getJohnsPayOutBankWire();

            assertTrue(payOut.getId().length() > 0);
            assertTrue(payOut.getPaymentType() == PayOutPaymentType.BANK_WIRE);
            assertTrue(payOut.getMeanOfPaymentDetails() instanceof PayOutPaymentDetailsBankWire);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void getPayOutRefunds() throws Exception {
        PayOut johnsPayOutBankWire = this.getJohnsPayOutBankWire();
        List<Refund> refunds = api.getPayOutApi().getRefunds(johnsPayOutBankWire.getId());
        assertNotNull(johnsPayOutBankWire);
    }

}
