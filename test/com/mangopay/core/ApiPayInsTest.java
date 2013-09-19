package com.mangopay.core;

import com.mangopay.entities.PayIn;
import com.mangopay.entities.Refund;
import com.mangopay.entities.UserNatural;
import com.mangopay.entities.Wallet;
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

        assertNotNull(((PayInExecutionDetailsWeb)getPayIn.ExecutionDetails).RedirectURL);
        assertNotNull(((PayInExecutionDetailsWeb)getPayIn.ExecutionDetails).ReturnURL);
    }
    
    @Test
    public void test_PayIns_Create_CardDirect() throws Exception {
        Wallet johnWallet = this.getJohnsWalletWithMoney();
        Wallet beforeWallet = this._api.Wallets.get(johnWallet.Id);
        
        PayIn payIn = this.getNewPayInCardDirect();
        Wallet wallet = this._api.Wallets.get(johnWallet.Id);
        UserNatural user = this.getJohn();
        
        assertTrue(payIn.Id.length() > 0);
        assertEquals(wallet.Id, payIn.CreditedWalletId);
        assertEquals("CARD", payIn.PaymentType);
        assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
        assertEquals("DIRECT", payIn.ExecutionType);
        assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
        assertTrue(payIn.DebitedFunds instanceof Money);
        assertTrue(payIn.CreditedFunds instanceof Money);
        assertTrue(payIn.Fees instanceof Money);
        assertEquals(user.Id, payIn.AuthorId);
        assertTrue(wallet.Balance.Amount == beforeWallet.Balance.Amount + payIn.CreditedFunds.Amount);
        assertEquals("SUCCEEDED", payIn.Status);
        assertEquals("PAYIN", payIn.Type);
    }
    
    @Test
    public void test_PayIns_Get_CardDirect() throws Exception {
        PayIn payIn = this.getNewPayInCardDirect();
        
        PayIn getPayIn = this._api.PayIns.get(payIn.Id);
        
        assertTrue(payIn.Id.equals(getPayIn.Id));
        assertTrue(payIn.PaymentType.equals("CARD"));
        assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
        assertTrue(payIn.ExecutionType.equals("DIRECT"));
        assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
        this.assertEqualInputProps(payIn, getPayIn);
        assertNotNull(((PayInExecutionDetailsDirect)getPayIn.ExecutionDetails).CardId);
    }
    
    @Test
    public void test_PayIns_CreateRefund_CardDirect() throws Exception {
        PayIn payIn = this.getNewPayInCardDirect();
        Wallet wallet = this.getJohnsWalletWithMoney();
        Wallet walletBefore = this._api.Wallets.get(wallet.Id);
                
        Refund refund = this.getNewRefundForPayIn(payIn);
        Wallet walletAfter = this._api.Wallets.get(wallet.Id);

        assertTrue(refund.Id.length() > 0);
        assertTrue(refund.DebitedFunds.Amount.equals(payIn.DebitedFunds.Amount));
        assertTrue(walletBefore.Balance.Amount.equals(walletAfter.Balance.Amount + payIn.DebitedFunds.Amount));
        assertEquals("PAYOUT", refund.Type);
        assertEquals("REFUND", refund.Nature);
    }
    
}
