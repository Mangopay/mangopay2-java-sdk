/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.core;

import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.core.enumerations.PreAuthorizationExecutionType;
import com.mangopay.core.enumerations.PreAuthorizationStatus;
import com.mangopay.entities.CardPreAuthorization;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiCardPreAuthorizations test methods.
 */
public class ApiCardPreAuthorizationsTest extends BaseTest {
    
    @Test
    public void createCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        
        assertTrue(!"".equals(cardPreAuthorization.Id));
        assertTrue(cardPreAuthorization.Status == PreAuthorizationStatus.SUCCEEDED);
        assertTrue(cardPreAuthorization.PaymentStatus == PaymentStatus.WAITING);
        assertTrue(cardPreAuthorization.ExecutionType == PreAuthorizationExecutionType.DIRECT);
        assertNull(cardPreAuthorization.PayInId);
    }
    
    @Test
    public void getCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        
        CardPreAuthorization getCardPreAuthorization = this.api.CardPreAuthorizations.get(cardPreAuthorization.Id);
        
        assertEquals(cardPreAuthorization.Id, getCardPreAuthorization.Id);
        assertTrue(getCardPreAuthorization.Status == PreAuthorizationStatus.SUCCEEDED);
        assertEquals("000000", getCardPreAuthorization.ResultCode);
    }
    
    @Test
    public void updateCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        cardPreAuthorization.PaymentStatus = PaymentStatus.CANCELED;
        
        CardPreAuthorization resultCardPreAuthorization = this.api.CardPreAuthorizations.update(cardPreAuthorization);
        
        assertTrue(resultCardPreAuthorization.Status == PreAuthorizationStatus.SUCCEEDED);
        assertTrue(resultCardPreAuthorization.PaymentStatus == PaymentStatus.CANCELED);
    }
    
}
