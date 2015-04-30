package com.mangopay.core;

import com.mangopay.entities.subentities.PayOutPaymentDetailsBankWire;
import com.mangopay.core.enumerations.PayOutPaymentType;
import com.mangopay.entities.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiPayOuts test methods
 */
public class ApiPayOutsTest extends BaseTest {
    
    @Test
    public void test_PayOuts_Create_BankWire() {
        try {
            PayIn payIn = this.getJohnsPayInCardWeb();
            PayOut payOut = this.getJohnsPayOutBankWire();

            assertTrue(payOut.Id.length() > 0);
            assertTrue(payOut.PaymentType == PayOutPaymentType.BANK_WIRE);
            assertTrue(payOut.MeanOfPaymentDetails instanceof PayOutPaymentDetailsBankWire);
        }
        catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
}
