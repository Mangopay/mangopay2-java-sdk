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
        assertEquals(cardPreAuthorization.Status, "SUCCEEDED");
        assertEquals(cardPreAuthorization.PaymentStatus, "WAITING");
        assertEquals(cardPreAuthorization.ExecutionType, "DIRECT");
        assertNull(cardPreAuthorization.PayInId);
    }
    
    @Test
    public void test_CardPreAuthorization_Get() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        
        CardPreAuthorization getCardPreAuthorization = this._api.CardPreAuthorizations.get(cardPreAuthorization.Id);
        
        assertEquals(cardPreAuthorization.Id, getCardPreAuthorization.Id);
        assertEquals(getCardPreAuthorization.ResultCode, "000000");
    }
    
    @Test
    public void test_CardPreAuthorization_Update() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        cardPreAuthorization.PaymentStatus = "CANCELED ";
        
        CardPreAuthorization resultCardPreAuthorization = this._api.CardPreAuthorizations.update(cardPreAuthorization);
        
        assertEquals(resultCardPreAuthorization.Status, "SUCCEEDED");
        assertEquals(resultCardPreAuthorization.PaymentStatus, "CANCELED");
    }
    
}
