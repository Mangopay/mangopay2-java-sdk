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
        
        assertTrue(!"".equals(cardPreAuthorization.getId()));
        assertTrue(cardPreAuthorization.getStatus() == PreAuthorizationStatus.SUCCEEDED);
        assertTrue(cardPreAuthorization.getPaymentStatus() == PaymentStatus.WAITING);
        assertTrue(cardPreAuthorization.getExecutionType() == PreAuthorizationExecutionType.DIRECT);
        assertNull(cardPreAuthorization.getPayInId());
    }
    
    @Test
    public void getCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        
        CardPreAuthorization getCardPreAuthorization = this.api.getCardPreAuthorizations().get(cardPreAuthorization.getId());
        
        assertEquals(cardPreAuthorization.getId(), getCardPreAuthorization.getId());
        assertTrue(getCardPreAuthorization.getStatus() == PreAuthorizationStatus.SUCCEEDED);
        assertEquals("000000", getCardPreAuthorization.getResultCode());
    }
    
    @Test
    public void updateCardPreAuthorization() throws Exception {
        CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
        cardPreAuthorization.setPaymentStatus(PaymentStatus.CANCELED);
        
        CardPreAuthorization resultCardPreAuthorization = this.api.getCardPreAuthorizations().update(cardPreAuthorization);
        
        assertTrue(resultCardPreAuthorization.getStatus() == PreAuthorizationStatus.SUCCEEDED);
        assertTrue(resultCardPreAuthorization.getPaymentStatus() == PaymentStatus.CANCELED);
    }
    
}
