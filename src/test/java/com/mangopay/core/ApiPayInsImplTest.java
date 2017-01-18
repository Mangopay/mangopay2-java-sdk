package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * API PayIns test methods
 */
public class ApiPayInsImplTest extends BaseTest {

    @Test
    public void createCardWeb() {
        try {
            PayIn payIn = null;
            payIn = this.getJohnsPayInCardWeb();

            assertTrue(payIn.getId().length() > 0);
            assertTrue(payIn.getPaymentType() == PayInPaymentType.CARD);
            assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.getExecutionType() == PayInExecutionType.WEB);
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsWeb);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void getCardWeb() {
        try {
            PayIn payIn = null;
            payIn = this.getJohnsPayInCardWeb();

            PayIn getPayIn = this.api.getPayIns().get(payIn.Id);

            assertTrue(payIn.getId().equals(getPayIn.Id));
            assertTrue(payIn.getPaymentType() == PayInPaymentType.CARD);
            assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.getExecutionType() == PayInExecutionType.WEB);
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsWeb);

            assertEqualInputProps(payIn, getPayIn);

            assertTrue(getPayIn.getStatus() == TransactionStatus.CREATED);
            assertTrue(getPayIn.getExecutionDate() == null);

            assertNotNull(((PayInExecutionDetailsWeb) getPayIn.getExecutionDetails()).getRedirectURL());
            assertNotNull(((PayInExecutionDetailsWeb) getPayIn.getExecutionDetails()).getReturnURL());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createCardDirect() {
        try {
            Wallet johnWallet = this.getJohnsWalletWithMoney();
            Wallet beforeWallet = this.api.getWallets().get(johnWallet.Id);

            PayIn payIn = this.getNewPayInCardDirect();
            Wallet wallet = this.api.getWallets().get(johnWallet.Id);
            UserNatural user = this.getJohn();

            assertTrue(payIn.getId().length() > 0);
            assertEquals(wallet.getId(), payIn.getCreditedWalletId());
            assertTrue(payIn.getPaymentType() == PayInPaymentType.CARD);
            assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            assertTrue(payIn.getDebitedFunds() instanceof Money);
            assertTrue(payIn.getCreditedFunds() instanceof Money);
            assertTrue(payIn.getFees() instanceof Money);
            assertEquals(user.getId(), payIn.getAuthorId());
            assertTrue(wallet.getBalance().getAmount() == beforeWallet.getBalance().getAmount() + payIn.getCreditedFunds().getAmount());
            assertTrue(payIn.getStatus() == TransactionStatus.SUCCEEDED);
            assertTrue(payIn.getType() == TransactionType.PAYIN);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void getCardDirect() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();

            PayIn getPayIn = this.api.getPayIns().get(payIn.getId());

            assertTrue(payIn.getId().equals(getPayIn.getId()));
            assertTrue(payIn.getPaymentType() == PayInPaymentType.CARD);
            assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            this.assertEqualInputProps(payIn, getPayIn);
            assertNotNull(((PayInPaymentDetailsCard) getPayIn.getPaymentDetails()).getCardId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createRefundCardDirect() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();
            Wallet wallet = this.getJohnsWalletWithMoney();
            Wallet walletBefore = this.api.getWallets().get(wallet.getId());

            Refund refund = this.getNewRefundForPayIn(payIn);
            Wallet walletAfter = this.api.getWallets().get(wallet.getId());

            assertTrue(refund.getId().length() > 0);
            assertTrue(refund.getDebitedFunds().getAmount() == payIn.getDebitedFunds().getAmount());
            assertTrue(walletBefore.getBalance().getAmount() == (walletAfter.getBalance().getAmount() + payIn.getDebitedFunds().getAmount()));
            assertTrue(refund.getType() == TransactionType.PAYOUT);
            assertTrue(refund.getNature() == TransactionNature.REFUND);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createPreAuthorizedDirect() {
        try {
            CardPreAuthorization cardPreAuthorization = this.getJohnsCardPreAuthorization();
            Wallet wallet = this.getJohnsWalletWithMoney();
            UserNatural user = this.getJohn();

            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.setCreditedWalletId(wallet.getId());
            payIn.setAuthorId(user.getId());
            payIn.setDebitedFunds(new Money());
            payIn.getDebitedFunds().setAmount(10000);
            payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payIn.setFees(new Money());
            payIn.getFees().setAmount(0);
            payIn.getFees().setCurrency(CurrencyIso.EUR);

            // payment type as CARD
            payIn.setPaymentDetails(new PayInPaymentDetailsPreAuthorized());
            ((PayInPaymentDetailsPreAuthorized) payIn.getPaymentDetails()).setPreauthorizationId(cardPreAuthorization.getId());

            // execution type as DIRECT
            payIn.setExecutionDetails(new PayInExecutionDetailsDirect());
            ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setSecureModeReturnURL("http://test.com");

            PayIn createPayIn = this.api.getPayIns().create(payIn);

            assertTrue(!"".equals(createPayIn.getId()));
            assertEquals(wallet.getId(), createPayIn.getCreditedWalletId());
            assertTrue(createPayIn.getPaymentType() == PayInPaymentType.PREAUTHORIZED);
            assertTrue(createPayIn.getPaymentDetails() instanceof PayInPaymentDetailsPreAuthorized);
            assertTrue(createPayIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(createPayIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            assertTrue(createPayIn.getDebitedFunds() instanceof Money);
            assertTrue(createPayIn.getCreditedFunds() instanceof Money);
            assertTrue(createPayIn.getFees() instanceof Money);
            assertEquals(user.getId(), createPayIn.getAuthorId());
            assertTrue(createPayIn.getStatus() == TransactionStatus.SUCCEEDED);
            assertTrue(createPayIn.getType() == TransactionType.PAYIN);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createBankWireDirect() {
        try {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();

            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.setCreditedWalletId(wallet.getId());
            payIn.setAuthorId(user.getId());

            // payment type as CARD
            payIn.setPaymentDetails(new PayInPaymentDetailsBankWire());
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).setDeclaredDebitedFunds(new Money());
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredDebitedFunds().setAmount(10000);
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredDebitedFunds().setCurrency(CurrencyIso.EUR);
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).setDeclaredFees(new Money());
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredFees().setAmount(0);
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredFees().setCurrency(CurrencyIso.EUR);
            payIn.setExecutionDetails(new PayInExecutionDetailsDirect());

            PayIn createPayIn = this.api.getPayIns().create(payIn);

            assertTrue(!"".equals(createPayIn.getId()));
            assertEquals(wallet.getId(), createPayIn.getCreditedWalletId());
            assertTrue(createPayIn.getPaymentType() == PayInPaymentType.BANK_WIRE);
            assertTrue(createPayIn.getPaymentDetails() instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getDeclaredDebitedFunds() instanceof Money);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getDeclaredFees() instanceof Money);
            assertTrue(createPayIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(createPayIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            assertEquals(user.getId(), createPayIn.getAuthorId());
            assertTrue(createPayIn.getStatus() == TransactionStatus.CREATED);
            assertTrue(createPayIn.getType() == TransactionType.PAYIN);
            assertNotNull(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getWireReference());
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount() instanceof BankAccount);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getType() == BankAccountType.IBAN);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getDetails() instanceof BankAccountDetailsIBAN);
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getDetails()).getIBAN());
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getDetails()).getBIC());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void getBankWireDirect() {
        try {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();

            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.setCreditedWalletId(wallet.getId());
            payIn.setAuthorId(user.getId());

            // payment type as CARD
            payIn.setPaymentDetails(new PayInPaymentDetailsBankWire());
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).setDeclaredDebitedFunds(new Money());
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredDebitedFunds().setAmount(10000);
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredDebitedFunds().setCurrency(CurrencyIso.EUR);
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).setDeclaredFees(new Money());
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredFees().setAmount(0);
            ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).getDeclaredFees().setCurrency(CurrencyIso.EUR);
            payIn.setExecutionDetails(new PayInExecutionDetailsDirect());
            PayIn createdPayIn = this.api.getPayIns().create(payIn);

            PayIn getPayIn = this.api.getPayIns().get(createdPayIn.getId());

            assertEquals(getPayIn.getId(), createdPayIn.getId());
            assertTrue(getPayIn.getPaymentType() == PayInPaymentType.BANK_WIRE);
            assertTrue(getPayIn.getPaymentDetails() instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getDeclaredDebitedFunds() instanceof Money);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getDeclaredFees() instanceof Money);
            assertTrue(getPayIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(getPayIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            assertEquals(user.getId(), getPayIn.getAuthorId());
            assertTrue(getPayIn.getType() == TransactionType.PAYIN);
            assertNotNull(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getWireReference());
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount() instanceof BankAccount);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getType() == BankAccountType.IBAN);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getDetails() instanceof BankAccountDetailsIBAN);
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getDetails()).getIBAN());
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getDetails()).getBIC());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createDirectDebitWeb() {
        try {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();

            // create pay-in PRE-AUTHORIZED DIRECT
            PayIn payIn = new PayIn();
            payIn.setCreditedWalletId(wallet.getId());
            payIn.setAuthorId(user.getId());
            payIn.setDebitedFunds(new Money());
            payIn.getDebitedFunds().setAmount(10000);
            payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payIn.setFees(new Money());
            payIn.getFees().setAmount(100);
            payIn.getFees().setCurrency(CurrencyIso.EUR);

            // payment type as CARD
            payIn.setPaymentDetails(new PayInPaymentDetailsDirectDebit());
            ((PayInPaymentDetailsDirectDebit) payIn.getPaymentDetails()).setDirectDebitType(DirectDebitType.GIROPAY);
            payIn.setExecutionDetails(new PayInExecutionDetailsWeb());
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).setReturnURL("http://www.mysite.com/returnURL/");
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).setCulture(CultureCode.FR);
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).setTemplateURLOptions(new PayInTemplateURLOptions());
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).getTemplateURLOptions().PAYLINE = "https://www.maysite.com/payline_template/";

            PayIn createPayIn = this.api.getPayIns().create(payIn);

            assertNotNull(createPayIn.getId());
            assertEquals(wallet.getId(), createPayIn.getCreditedWalletId());
            assertTrue(createPayIn.getPaymentType() == PayInPaymentType.DIRECT_DEBIT);
            assertTrue(createPayIn.getPaymentDetails() instanceof PayInPaymentDetailsDirectDebit);
            assertTrue(((PayInPaymentDetailsDirectDebit) createPayIn.getPaymentDetails()).getDirectDebitType() == DirectDebitType.GIROPAY);
            assertTrue(createPayIn.getExecutionType() == PayInExecutionType.WEB);
            assertTrue(createPayIn.getExecutionDetails() instanceof PayInExecutionDetailsWeb);
            assertTrue(((PayInExecutionDetailsWeb) createPayIn.getExecutionDetails()).getCulture() == CultureCode.FR);
            assertEquals(user.getId(), createPayIn.getAuthorId());
            assertTrue(createPayIn.getStatus() == TransactionStatus.CREATED);
            assertTrue(createPayIn.getType() == TransactionType.PAYIN);
            assertTrue(createPayIn.getDebitedFunds() instanceof Money);
            assertTrue(10000 == createPayIn.getDebitedFunds().getAmount());
            assertTrue(createPayIn.getDebitedFunds().getCurrency() == CurrencyIso.EUR);
            assertTrue(createPayIn.getCreditedFunds() instanceof Money);
            assertTrue(9900 == createPayIn.getCreditedFunds().getAmount());
            assertTrue(createPayIn.getCreditedFunds().getCurrency() == CurrencyIso.EUR);
            assertTrue(createPayIn.getFees() instanceof Money);
            assertTrue(100 == createPayIn.getFees().getAmount());
            assertTrue(createPayIn.getFees().getCurrency() == CurrencyIso.EUR);
            assertNotNull(((PayInExecutionDetailsWeb) createPayIn.getExecutionDetails()).getReturnURL());
            assertNotNull(((PayInExecutionDetailsWeb) createPayIn.getExecutionDetails()).getRedirectURL());
            assertNotNull(((PayInExecutionDetailsWeb) createPayIn.getExecutionDetails()).getTemplateURL());

        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /*
    @Test
    public void createDirectDebitDirect() throws Exception {
        Wallet wallet = this.getJohnsWallet();
        UserNatural user = this.getJohn();

        String bankAccountId = this.getJohnsAccount().getId();
        String returnUrl = "http://test.test";
        Mandate mandatePost = new Mandate();
        mandatePost.setBankAccountId(bankAccountId);
        mandatePost.setCulture(CultureCode.EN);
        mandatePost.setReturnURL(returnUrl);
        Mandate mandate = this.api.getMandates().create(mandatePost);

        //	! IMPORTANT NOTE !
        //	
        //	In order to make this test pass, at this place you have to set a breakpoint,
        //	navigate to URL the mandate.RedirectURL property points to and click "CONFIRM" button.

        PayIn payIn = new PayIn();
        payIn.setAuthorId(user.getId());
        payIn.setDebitedFunds(new Money());
        payIn.getDebitedFunds().setAmount(1000);
        payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
        payIn.setFees(new Money());
        payIn.getFees().setAmount(0);
        payIn.getFees().setCurrency(CurrencyIso.EUR);
        payIn.setCreditedWalletId(wallet.getId());
        PayInPaymentDetailsDirectDebit paymentDetails = new PayInPaymentDetailsDirectDebit();
        paymentDetails.setMandateId(mandate.getId());
        payIn.setPaymentDetails(paymentDetails);
        PayInExecutionDetailsDirect executionDetails = new PayInExecutionDetailsDirect();
        payIn.setExecutionDetails(executionDetails);

        PayIn createPayIn = this.api.getPayIns().create(payIn);

        assertNotNull(createPayIn);
        assertNotEquals("In order to make this test pass, after creating mandate and before creating the payin you have to navigate to URL the mandate.RedirectURL property points to and click CONFIRM button.", TransactionStatus.FAILED, createPayIn.Status);

        assertFalse(createPayIn.getId().isEmpty());
        assertEquals(wallet.getId(), createPayIn.getCreditedWalletId());
        assertEquals(PayInPaymentType.DIRECT_DEBIT, createPayIn.getPaymentType());
        assertEquals(PayInExecutionType.DIRECT, createPayIn.getExecutionType());
        assertEquals(user.getId(), createPayIn.getAuthorId());
        assertEquals(TransactionStatus.CREATED, createPayIn.getStatus());
        assertEquals(TransactionType.PAYIN, createPayIn.getType());
        assertNotNull(((PayInPaymentDetailsDirectDebit) createPayIn.getPaymentDetails()).getMandateId());
        assertEquals(((PayInPaymentDetailsDirectDebit) createPayIn.getPaymentDetails()).getMandateId(), mandate.getId());
    }
    */
}
