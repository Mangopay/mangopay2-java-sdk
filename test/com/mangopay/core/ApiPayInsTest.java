package com.mangopay.core;

import com.mangopay.entities.PayIn;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * API PayIns test methods
 */
public class ApiPayInsTest extends BaseTest {
    
    @Test
    public void test_PayIns_Create_CardWeb() {
        PayIn payIn = null;
        try {
            payIn = this.getJohnsPayInCardWeb();
        } catch (Exception ex) {
            Logger.getLogger(ApiPayInsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertTrue(payIn.Id.length() > 0);
        assertTrue(payIn.PaymentType.equals("CARD"));
        assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
        assertTrue(payIn.ExecutionType.equals("WEB"));
        assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsWeb);
    }
    
    @Test
    public void test_PayIns_Get_CardWeb() throws Exception {
        PayIn payIn = null;
        try {
            payIn = this.getJohnsPayInCardWeb();
        } catch (Exception ex) {
            Logger.getLogger(ApiPayInsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PayIn getPayIn = this._api.PayIns.get(payIn.Id);
        
        assertTrue(payIn.Id.equals(getPayIn.Id));
        assertTrue(payIn.PaymentType.equals("CARD"));
        assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
        assertTrue(payIn.ExecutionType.equals("WEB"));
        assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsWeb);
        
        assertEqualInputProps(payIn, getPayIn);
        
        assertTrue(getPayIn.Status.equals("CREATED"));
        assertTrue(getPayIn.ExecutionDate == null);
        assertNotNull(((PayInPaymentDetailsCard)getPayIn.PaymentDetails).RedirectURL);
        assertNotNull(((PayInPaymentDetailsCard)getPayIn.PaymentDetails).ReturnURL);
    }
    
}
