package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * API Refunds test methods.
 */
public class ApiRefundsTest extends BaseTest {
    
    @Test
    public void getRefundForTransfer() throws Exception {
        Transfer transfer = this.getNewTransfer();
        Refund refund = this.getNewRefundForTransfer(transfer);
        UserNatural user = this.getJohn();
        
        Refund getRefund = this.api.Refunds.get(refund.Id);
        
        assertEquals(getRefund.Id, refund.Id);
        assertEquals(getRefund.InitialTransactionId, transfer.Id);
        assertEquals(getRefund.AuthorId, user.Id);
        assertTrue(getRefund.Type == TransactionType.TRANSFER);
        assertTrue(getRefund.InitialTransactionType == InitialTransactionType.TRANSFER);
        assertNotNull(getRefund.RefundReason);
        assertTrue(getRefund.RefundReason.RefundReasonType == RefundReasonType.OTHER);
    }
    
    @Test
    public void getRefundForPayIn() throws Exception {
        PayIn payIn = this.getNewPayInCardDirect();
        Refund refund = this.getNewRefundForPayIn(payIn);
        UserNatural user = this.getJohn();

        Refund getRefund = this.api.Refunds.get(refund.Id);
        
        assertEquals(getRefund.Id, refund.Id);
        assertEquals(getRefund.InitialTransactionId, payIn.Id);
        assertEquals(getRefund.AuthorId, user.Id);
        assertTrue(getRefund.Type == TransactionType.PAYOUT);
        assertTrue(getRefund.InitialTransactionType == InitialTransactionType.PAYIN);
        assertNotNull(getRefund.RefundReason);
        assertTrue(getRefund.RefundReason.RefundReasonType == RefundReasonType.INITIALIZED_BY_CLIENT);
    }
}
