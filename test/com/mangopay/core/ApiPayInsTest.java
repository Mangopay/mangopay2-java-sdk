package com.mangopay.core;

import com.mangopay.entities.subentities.PayInPaymentDetailsPreAuthorized;
import com.mangopay.entities.subentities.PayInPaymentDetailsBankWire;
import com.mangopay.entities.subentities.PayInTemplateURLOptions;
import com.mangopay.entities.subentities.PayInExecutionDetailsWeb;
import com.mangopay.entities.subentities.PayInExecutionDetailsDirect;
import com.mangopay.entities.subentities.BankAccountDetailsIBAN;
import com.mangopay.entities.subentities.PayInPaymentDetailsDirectDebit;
import com.mangopay.entities.subentities.PayInPaymentDetailsCard;
import com.mangopay.core.enumerations.*;
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
            assertTrue(payIn.PaymentType == PayInPaymentType.CARD);
            assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.ExecutionType == PayInExecutionType.WEB);
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
            assertTrue(payIn.PaymentType == PayInPaymentType.CARD);
            assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.ExecutionType == PayInExecutionType.WEB);
            assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsWeb);
            
            assertEqualInputProps(payIn, getPayIn);
            
            assertTrue(getPayIn.Status == TransactionStatus.CREATED);
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
            assertTrue(payIn.PaymentType == PayInPaymentType.CARD);
            assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.ExecutionType == PayInExecutionType.DIRECT);
            assertTrue(payIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            assertTrue(payIn.DebitedFunds instanceof Money);
            assertTrue(payIn.CreditedFunds instanceof Money);
            assertTrue(payIn.Fees instanceof Money);
            assertEquals(user.Id, payIn.AuthorId);
            assertTrue(wallet.Balance.Amount == beforeWallet.Balance.Amount + payIn.CreditedFunds.Amount);
            assertTrue(payIn.Status == TransactionStatus.SUCCEEDED);
            assertTrue(payIn.Type == TransactionType.PAYIN);
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
            assertTrue(payIn.PaymentType == PayInPaymentType.CARD);
            assertTrue(payIn.PaymentDetails instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.ExecutionType == PayInExecutionType.DIRECT);
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
            assertTrue(refund.DebitedFunds.Amount == payIn.DebitedFunds.Amount);
            assertTrue(walletBefore.Balance.Amount == (walletAfter.Balance.Amount + payIn.DebitedFunds.Amount));
            assertTrue(refund.Type == TransactionType.PAYOUT);
            assertTrue(refund.Nature == TransactionNature.REFUND);
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
            payIn.DebitedFunds.Amount = 10000;
            payIn.DebitedFunds.Currency = CurrencyIso.EUR;
            payIn.Fees = new Money();
            payIn.Fees.Amount = 0;
            payIn.Fees.Currency = CurrencyIso.EUR;
            
            // payment type as CARD
            payIn.PaymentDetails = new PayInPaymentDetailsPreAuthorized();
            ((PayInPaymentDetailsPreAuthorized)payIn.PaymentDetails).PreauthorizationId = cardPreAuthorization.Id;
            
            // execution type as DIRECT
            payIn.ExecutionDetails = new PayInExecutionDetailsDirect();
            ((PayInExecutionDetailsDirect)payIn.ExecutionDetails).SecureModeReturnURL = "http://test.com";
            
            PayIn createPayIn = this._api.PayIns.create(payIn);
            
            assertTrue(!"".equals(createPayIn.Id));
            assertEquals(wallet.Id, createPayIn.CreditedWalletId);
            assertTrue(createPayIn.PaymentType == PayInPaymentType.PREAUTHORIZED);
            assertTrue(createPayIn.PaymentDetails instanceof PayInPaymentDetailsPreAuthorized);
            assertTrue(createPayIn.ExecutionType == PayInExecutionType.DIRECT);
            assertTrue(createPayIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            assertTrue(createPayIn.DebitedFunds instanceof Money);
            assertTrue(createPayIn.CreditedFunds instanceof Money);
            assertTrue(createPayIn.Fees instanceof Money);
            assertEquals(user.Id, createPayIn.AuthorId);
            assertTrue(createPayIn.Status == TransactionStatus.SUCCEEDED);
            assertTrue(createPayIn.Type == TransactionType.PAYIN);
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
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Amount = 10000;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Currency = CurrencyIso.EUR;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees = new Money();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Amount = 0;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Currency = CurrencyIso.EUR;
            payIn.ExecutionDetails = new PayInExecutionDetailsDirect();
            
            PayIn createPayIn = this._api.PayIns.create(payIn);
            
            assertTrue(!"".equals(createPayIn.Id));
            assertEquals(wallet.Id, createPayIn.CreditedWalletId);
            assertTrue(createPayIn.PaymentType == PayInPaymentType.BANK_WIRE);
            assertTrue(createPayIn.PaymentDetails instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).DeclaredDebitedFunds instanceof Money);
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).DeclaredFees instanceof Money);
            assertTrue(createPayIn.ExecutionType == PayInExecutionType.DIRECT);
            assertTrue(createPayIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            assertEquals(user.Id, createPayIn.AuthorId);
            assertTrue(createPayIn.Status == TransactionStatus.CREATED);
            assertTrue(createPayIn.Type == TransactionType.PAYIN);
            assertNotNull(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).WireReference);
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).BankAccount instanceof BankAccount);
            assertTrue(((PayInPaymentDetailsBankWire)createPayIn.PaymentDetails).BankAccount.Type == BankAccountType.IBAN);
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
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Amount = 10000;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds.Currency = CurrencyIso.EUR;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees = new Money();
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Amount = 0;
            ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredFees.Currency = CurrencyIso.EUR;
            payIn.ExecutionDetails = new PayInExecutionDetailsDirect();
            PayIn createdPayIn = this._api.PayIns.create(payIn);

            PayIn getPayIn = this._api.PayIns.get(createdPayIn.Id);
            
            assertEquals(getPayIn.Id, createdPayIn.Id);
            assertTrue(getPayIn.PaymentType == PayInPaymentType.BANK_WIRE);
            assertTrue(getPayIn.PaymentDetails instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).DeclaredDebitedFunds instanceof Money);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).DeclaredFees instanceof Money);
            assertTrue(getPayIn.ExecutionType == PayInExecutionType.DIRECT);
            assertTrue(getPayIn.ExecutionDetails instanceof PayInExecutionDetailsDirect);
            assertEquals(user.Id, getPayIn.AuthorId);
            assertTrue(getPayIn.Type == TransactionType.PAYIN);
            assertNotNull(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).WireReference);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount instanceof BankAccount);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Type == BankAccountType.IBAN);
            assertTrue(((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Details instanceof BankAccountDetailsIBAN);
            assertNotNull(((BankAccountDetailsIBAN)((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Details).IBAN);
            assertNotNull(((BankAccountDetailsIBAN)((PayInPaymentDetailsBankWire)getPayIn.PaymentDetails).BankAccount.Details).BIC);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_PayIns_DirectDebitWeb_Create() {
        try {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();

            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.CreditedWalletId = wallet.Id;
            payIn.AuthorId = user.Id;
            payIn.DebitedFunds = new Money();
            payIn.DebitedFunds.Amount = 10000;
            payIn.DebitedFunds.Currency = CurrencyIso.EUR;
            payIn.Fees = new Money();
            payIn.Fees.Amount = 100;
            payIn.Fees.Currency = CurrencyIso.EUR;

            // payment type as CARD
            payIn.PaymentDetails = new PayInPaymentDetailsDirectDebit();
            ((PayInPaymentDetailsDirectDebit)payIn.PaymentDetails).DirectDebitType = DirectDebitType.GIROPAY;
            payIn.ExecutionDetails = new PayInExecutionDetailsWeb();
            ((PayInExecutionDetailsWeb)payIn.ExecutionDetails).ReturnURL = "http://www.mysite.com/returnURL/";
            ((PayInExecutionDetailsWeb)payIn.ExecutionDetails).Culture = CountryIso.FR;
            ((PayInExecutionDetailsWeb)payIn.ExecutionDetails).TemplateURLOptions = new PayInTemplateURLOptions();
            ((PayInExecutionDetailsWeb)payIn.ExecutionDetails).TemplateURLOptions.PAYLINE = "https://www.maysite.com/payline_template/";                

            PayIn createPayIn = this._api.PayIns.create(payIn);

            assertNotNull(createPayIn.Id);
            assertEquals(wallet.Id, createPayIn.CreditedWalletId);
            assertTrue(createPayIn.PaymentType == PayInPaymentType.DIRECT_DEBIT);
            assertTrue(createPayIn.PaymentDetails instanceof PayInPaymentDetailsDirectDebit);
            assertTrue(((PayInPaymentDetailsDirectDebit)createPayIn.PaymentDetails).DirectDebitType == DirectDebitType.GIROPAY);
            assertTrue(createPayIn.ExecutionType == PayInExecutionType.WEB);
            assertTrue(createPayIn.ExecutionDetails instanceof PayInExecutionDetailsWeb);
            assertTrue(((PayInExecutionDetailsWeb)createPayIn.ExecutionDetails).Culture == CountryIso.FR);
            assertEquals(user.Id, createPayIn.AuthorId);
            assertTrue(createPayIn.Status == TransactionStatus.CREATED);
            assertTrue(createPayIn.Type == TransactionType.PAYIN);
            assertTrue(createPayIn.DebitedFunds instanceof Money);
            assertTrue(10000 == createPayIn.DebitedFunds.Amount);
            assertTrue(createPayIn.DebitedFunds.Currency == CurrencyIso.EUR);
            assertTrue(createPayIn.CreditedFunds instanceof Money);
            assertTrue(9900 == createPayIn.CreditedFunds.Amount);
            assertTrue(createPayIn.CreditedFunds.Currency == CurrencyIso.EUR);
            assertTrue(createPayIn.Fees instanceof Money);
            assertTrue(100 == createPayIn.Fees.Amount);
            assertTrue(createPayIn.Fees.Currency == CurrencyIso.EUR);
            assertNotNull(((PayInExecutionDetailsWeb)createPayIn.ExecutionDetails).ReturnURL);
            assertNotNull(((PayInExecutionDetailsWeb)createPayIn.ExecutionDetails).RedirectURL);
            assertNotNull(((PayInExecutionDetailsWeb)createPayIn.ExecutionDetails).TemplateURL);
    
        } catch (Exception ex){
            Assert.fail(ex.getMessage());
        }
    }
}
