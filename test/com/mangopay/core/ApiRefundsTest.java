package com.mangopay.core;

import com.mangopay.entities.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * API Refunds test methods.
 */
public class ApiRefundsTest extends BaseTest {
    
    @Test
    public void test_Refund_GetForTransfer() throws Exception {
        Transfer transfer = this.getNewTransfer();
        Refund refund = this.getNewRefundForTransfer(transfer);
        UserNatural user = this.getJohn();
        
        Refund getRefund = this._api.Refunds.get(refund.Id);
        
        assertEquals(getRefund.Id, refund.Id);
        assertEquals(getRefund.InitialTransactionId, transfer.Id);
        assertEquals(getRefund.AuthorId, user.Id);
        assertEquals(getRefund.Type, "TRANSFER");
        assertEquals(getRefund.InitialTransactionType, "TRANSFER");
    }
    
    @Test
    public void test_Refund_GetForPayIn() throws Exception {
        PayIn payIn = this.getNewPayInCardDirect();
        Refund refund = this.getNewRefundForPayIn(payIn);
        UserNatural user = this.getJohn();

        Refund getRefund = this._api.Refunds.get(refund.Id);
        
        assertEquals(getRefund.Id, refund.Id);
        assertEquals(getRefund.InitialTransactionId, payIn.Id);
        assertEquals(getRefund.AuthorId, user.Id);
        assertEquals(getRefund.Type, "PAYOUT");
        assertEquals(getRefund.InitialTransactionType, "PAYIN");
    }
}
