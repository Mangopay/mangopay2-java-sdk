package com.mangopay.core;

import com.mangopay.core.enumerations.InitialTransactionType;
import com.mangopay.core.enumerations.RefundReasonType;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.Refund;
import com.mangopay.entities.Transfer;
import com.mangopay.entities.UserNatural;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * API Refunds test methods.
 */
public class ApiRefundsImplTest extends BaseTest {

    @Test
    public void getRefundForTransfer() throws Exception {
        Transfer transfer = this.getNewTransfer();
        Refund refund = this.getNewRefundForTransfer(transfer);
        UserNatural user = this.getJohn();

        Refund getRefund = this.api.getRefunds().get(refund.getId());

        assertEquals(getRefund.getId(), refund.getId());
        assertEquals(getRefund.getInitialTransactionId(), transfer.getId());
        assertEquals(getRefund.getAuthorId(), user.getId());
        assertTrue(getRefund.getType() == TransactionType.TRANSFER);
        assertTrue(getRefund.getInitialTransactionType() == InitialTransactionType.TRANSFER);
        assertNotNull(getRefund.getRefundReason());
        assertTrue(getRefund.getRefundReason().getRefundReasonType() == RefundReasonType.OTHER);
    }

    @Test
    public void getRefundForPayIn() throws Exception {
        PayIn payIn = this.getNewPayInCardDirect();
        Refund refund = this.getNewRefundForPayIn(payIn);
        UserNatural user = this.getJohn();

        Refund getRefund = this.api.getRefunds().get(refund.getId());

        assertEquals(getRefund.getId(), refund.getId());
        assertEquals(getRefund.getInitialTransactionId(), payIn.getId());
        assertEquals(getRefund.getAuthorId(), user.getId());
        assertTrue(getRefund.getType() == TransactionType.PAYOUT);
        assertTrue(getRefund.getInitialTransactionType() == InitialTransactionType.PAYIN);
        assertNotNull(getRefund.getRefundReason());
        assertTrue(getRefund.getRefundReason().getRefundReasonType() == RefundReasonType.INITIALIZED_BY_CLIENT);
    }
}
