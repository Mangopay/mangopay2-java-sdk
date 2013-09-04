package com.mangopay.core;

import com.mangopay.entities.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            //this.fail("Should throw ResponseException");

            assertTrue(payOut.Id.length() > 0);
            assertEquals(payOut.PaymentType, "BANK_WIRE");
            assertTrue(payOut.MeanOfPaymentDetails instanceof PayOutPaymentDetailsBankWire);
        }
//        catch (ResponseException ex) {
//            //assertIdentical(ex.getCode(), 400);
//            //assertTrue(strpos(ex.getMessage(), "The amount you wish to spend must be smaller than the amount left in your collection") !== false);
//        }
        catch (Exception ex) {
            //this.fail("Should throw ResponseException");
        }
    }
    
}
