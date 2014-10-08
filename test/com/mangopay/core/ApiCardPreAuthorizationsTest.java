/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.core;

import com.mangopay.entities.CardPreAuthorization;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiCardPreAuthorizations test methods.
 */
public class ApiCardPreAuthorizationsTest extends BaseTest {
    
    @Test
    public void test_CardPreAuthorization_Create() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        
        assertTrue(!"".equals(cardPreAuthorization.Id));
        assertEquals("SUCCEEDED", cardPreAuthorization.Status);
        assertEquals("WAITING", cardPreAuthorization.PaymentStatus);
        assertEquals("DIRECT", cardPreAuthorization.ExecutionType);
        assertNull(cardPreAuthorization.PayInId);
    }
    
    @Test
    public void test_CardPreAuthorization_Get() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        
        CardPreAuthorization getCardPreAuthorization = this._api.CardPreAuthorizations.get(cardPreAuthorization.Id);
        
        assertEquals(cardPreAuthorization.Id, getCardPreAuthorization.Id);
        assertEquals("SUCCEEDED", getCardPreAuthorization.Status);
        assertEquals("000000", getCardPreAuthorization.ResultCode);
    }
    
    @Test
    public void test_CardPreAuthorization_Update() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        cardPreAuthorization.PaymentStatus = "CANCELED ";
        
        CardPreAuthorization resultCardPreAuthorization = this._api.CardPreAuthorizations.update(cardPreAuthorization);
        
        assertEquals("SUCCEEDED", resultCardPreAuthorization.Status);
        assertEquals("CANCELED", resultCardPreAuthorization.PaymentStatus);
    }
    
}
