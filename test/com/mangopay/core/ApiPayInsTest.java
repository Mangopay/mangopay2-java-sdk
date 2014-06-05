package com.mangopay.core;

import com.mangopay.entities.BankAccount;
import com.mangopay.entities.CardPreAuthorization;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.Refund;
import com.mangopay.entities.UserNatural;
import com.mangopay.entities.Wallet;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * API PayIns test methods
 */
public class ApiPayInsTest extends BaseTest {
    
    @Test
    public void test_PayIns_Create_CardWeb() {
        try {
            PayIn payIn = null;
            payIn = this.getJohnsPayInCardWeb();

            assertTrue(payIn.Id.length() > 0);
            assertTrue(payIn.PaymentType.equals("CARD"));
            assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.ExecutionType.equals("WEB"));
            assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsWeb);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_Get_CardWeb() {
        try {
            PayIn payIn = null;
            payIn = this.getJohnsPayInCardWeb();
            
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
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_Create_CardDirect() {
        try {
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
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_Get_CardDirect() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();
            
            PayIn getPayIn = this._api.PayIns.get(payIn.Id);
            
            assertTrue(payIn.Id.equals(getPayIn.Id));
            assertTrue(payIn.PaymentType.equals("CARD"));
            assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.ExecutionType.equals("DIRECT"));
            assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            this.assertEqualInputProps(payIn, getPayIn);
            assertNotNull(((PayInPaymentDetailsCard)getPayIn.PaymentDetails).CardId);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_CreateRefund_CardDirect() {
        try {
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
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_PreAuthorizedDirect() {
        try {
            CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
            Wallet wallet = this.getJohnsWalletWithMoney();
            UserNatural user = this.getJohn();
            
            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.CreditedWalletId = wallet.Id;
            payIn.AuthorId = user.Id;
            payIn.DebitedFunds = new Money();
            payIn.DebitedFunds.Amount = 10000.0;
            payIn.DebitedFunds.Currency = "EUR";
            payIn.Fees = new Money();
            payIn.Fees.Amount = 0.0;
            payIn.Fees.Currency = "EUR";
            
            // payment type as CARD
            payIn.PaymentDetails = new PayInPaymentDetailsPreAuthorized();
            ((PayInPaymentDetailsPreAuthorized)payIn.PaymentDetails).PreauthorizationId = cardPreAuthorization.Id;
            
            // execution type as DIRECT
            payIn.ExecutionDetails = new PayInExecutionDetailsDirect();
            ((PayInExecutionDetailsDirect)payIn.ExecutionDetails).SecureModeReturnURL = "http://test.com";
            
            PayIn createPayIn = this._api.PayIns.create(payIn);
            
            assertTrue(!"".equals(createPayIn.Id));
            assertEquals(wallet.Id, createPayIn.CreditedWalletId);
            assertEquals("PREAUTHORIZED", createPayIn.PaymentType);
            assertTrue(createPayIn.PaymentDetails instanceof PayInPaymentDetailsPreAuthorized);
            assertEquals("DIRECT", createPayIn.ExecutionType);
            assertTrue(createPayIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            assertTrue(createPayIn.DebitedFunds instanceof Money);
            assertTrue(createPayIn.CreditedFunds instanceof Money);
            assertTrue(createPayIn.Fees instanceof Money);
            assertEquals(user.Id, createPayIn.AuthorId);
            assertEquals("SUCCEEDED", createPayIn.Status);
            assertEquals("PAYIN", createPayIn.Type);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_BankWireDirect_Create() {
        try {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();
            
            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.CreditedWalletId = wallet.Id;
            payIn.AuthorId = user.Id;
            
            // payment type as CARD
            payIn.PaymentDetails = new PayInPaymentDetailsBankWire();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds = new Money();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Amount = 10000.0;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Currency = "EUR";
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees = new Money();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Amount = 0.0;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Currency = "EUR";
            payIn.ExecutionDetails = new PayInExecutionDetailsDirect();
            
            PayIn createPayIn = this._api.PayIns.create(payIn);
            
            assertTrue(!"".equals(createPayIn.Id));
            assertEquals(wallet.Id, createPayIn.CreditedWalletId);
            assertEquals("BANK_WIRE", createPayIn.PaymentType);
            assertTrue(createPayIn.PaymentDetails instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).DeclaredDebitedFunds instanceof Money);
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).DeclaredFees instanceof Money);
            assertEquals("DIRECT", createPayIn.ExecutionType);
            assertTrue(createPayIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            assertEquals(user.Id, createPayIn.AuthorId);
            assertEquals("CREATED", createPayIn.Status);
            assertEquals("PAYIN", createPayIn.Type);
            assertNotNull(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).WireReference);
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).BankAccount instanceof BankAccount);
            assertEquals(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).BankAccount.Type, "IBAN");
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).BankAccount.Details instanceof BankAccountDetailsIBAN);
            assertNotNull(((BankAccountDetailsIBAN)((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).BankAccount.Details).IBAN);
            assertNotNull(((BankAccountDetailsIBAN)((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).BankAccount.Details).BIC);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_BankWireDirect_Get() {
        try {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();
            
            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.CreditedWalletId = wallet.Id;
            payIn.AuthorId = user.Id;
            
            // payment type as CARD
            payIn.PaymentDetails = new PayInPaymentDetailsBankWire();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds = new Money();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Amount = 10000.0;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Currency = "EUR";
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees = new Money();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Amount = 0.0;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Currency = "EUR";
            payIn.ExecutionDetails = new PayInExecutionDetailsDirect();
            PayIn createdPayIn = this._api.PayIns.create(payIn);

            PayIn getPayIn = this._api.PayIns.get(createdPayIn.Id);
            
            assertEquals(getPayIn.Id, createdPayIn.Id);
            assertEquals("BANK_WIRE", getPayIn.PaymentType);
            assertTrue(getPayIn.PaymentDetails instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).DeclaredDebitedFunds instanceof Money);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).DeclaredFees instanceof Money);
            assertEquals("DIRECT", getPayIn.ExecutionType);
            assertTrue(getPayIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            assertEquals(user.Id, getPayIn.AuthorId);
            assertEquals("PAYIN", getPayIn.Type);
            assertNotNull(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).WireReference);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount instanceof BankAccount);
            assertEquals(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Type, "IBAN");
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Details instanceof BankAccountDetailsIBAN);
            assertNotNull(((BankAccountDetailsIBAN)((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Details).IBAN);
            assertNotNull(((BankAccountDetailsIBAN)((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Details).BIC);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}
