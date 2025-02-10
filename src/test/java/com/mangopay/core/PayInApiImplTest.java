package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * API PayIns test methods
 */
public class PayInApiImplTest extends BaseTest {

    @Test
    public void createCardWeb() {
        try {
            PayIn payIn = this.getJohnsPayInCardWeb();

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
            PayIn payIn = this.getJohnsPayInCardWeb();

            PayIn getPayIn = this.api.getPayInApi().get(payIn.getId());

            assertTrue(payIn.getId().equals(getPayIn.getId()));
            assertTrue(payIn.getPaymentType() == PayInPaymentType.CARD);
            assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsCard);
            assertTrue(payIn.getExecutionType() == PayInExecutionType.WEB);
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsWeb);

            assertEqualInputProps(payIn, getPayIn);

            assertTrue(getPayIn.getStatus() == TransactionStatus.CREATED);
            assertTrue(getPayIn.getExecutionDate() == null);

            assertNotNull(((PayInExecutionDetailsWeb) getPayIn.getExecutionDetails()).getRedirectUrl());
            assertNotNull(((PayInExecutionDetailsWeb) getPayIn.getExecutionDetails()).getReturnUrl());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createCardDirect() {
        try {
            Wallet johnWallet = this.getJohnsWalletWithMoney();
            Wallet beforeWallet = this.api.getWalletApi().get(johnWallet.getId());

            PayIn payIn = this.getNewPayInCardDirect();
            Wallet wallet = this.api.getWalletApi().get(johnWallet.getId());
            UserNatural user = this.getJohn();

            check(user, payIn, wallet, beforeWallet);
            assertEquals("TelephoneOrder", ((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getPaymentCategory());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    private void check(User user, PayIn payIn, Wallet wallet, Wallet beforeWallet) {
        assertTrue(payIn.getId().length() > 0);
        assertEquals(wallet.getId(), payIn.getCreditedWalletId());
        assertTrue(payIn.getPaymentType() == PayInPaymentType.CARD);
        assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsCard);
        assertTrue(payIn.getExecutionType() == PayInExecutionType.DIRECT);
        assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
        assertTrue(payIn.getDebitedFunds() != null);
        assertTrue(payIn.getCreditedFunds() != null);
        assertTrue(payIn.getFees() != null);
        assertEquals(user.getId(), payIn.getAuthorId());
        assertTrue(wallet.getBalance().getAmount() == beforeWallet.getBalance().getAmount() + payIn.getCreditedFunds().getAmount());
        assertTrue(payIn.getStatus() == TransactionStatus.SUCCEEDED);
        assertTrue(payIn.getType() == TransactionType.PAYIN);
    }

    @Test
    public void createCardDirectWithBilling() {
        try {
            Wallet johnWallet = this.getJohnsWalletWithMoney();
            Wallet beforeWallet = this.api.getWalletApi().get(johnWallet.getId());

            PayIn payIn = this.getNewPayInCardDirectWithBilling();
            Wallet wallet = this.api.getWalletApi().get(johnWallet.getId());
            UserNatural user = this.getJohn();

            check(user, payIn, wallet, beforeWallet);

            PayInExecutionDetailsDirect executionDetails = (PayInExecutionDetailsDirect) payIn.getExecutionDetails();
            assertNotNull(executionDetails.getSecurityInfo());
            assertNotNull(executionDetails.getSecurityInfo().getAvsResult());
            assertTrue(executionDetails.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createCardDirectWithRequested3DSVersion() {
        try {
            Wallet johnWallet = this.getJohnsWalletWithMoney();
            Wallet beforeWallet = this.api.getWalletApi().get(johnWallet.getId());

            PayIn payIn = this.getNewPayInCardDirectWithRequested3DSVersion();
            Wallet wallet = this.api.getWalletApi().get(johnWallet.getId());
            UserNatural user = this.getJohn();

            check(user, payIn, wallet, beforeWallet);

            PayInExecutionDetailsDirect executionDetails = (PayInExecutionDetailsDirect) payIn.getExecutionDetails();
            assertNotNull(executionDetails.getSecurityInfo());
            assertNotNull(executionDetails.getSecurityInfo().getAvsResult());
            assertTrue(executionDetails.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
            assertNotNull(executionDetails.getRequested3DSVersion());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createCardDirectWithBrowserInfo() {
        try {
            Wallet johnWallet = this.getJohnsWalletWithMoney();
            Wallet beforeWallet = this.api.getWalletApi().get(johnWallet.getId());

            PayIn payIn = this.getNewPayInCardDirectWithBrowserInfo();
            Wallet wallet = this.api.getWalletApi().get(johnWallet.getId());
            UserNatural user = this.getJohn();

            check(user, payIn, wallet, beforeWallet);

            PayInExecutionDetailsDirect executionDetails = (PayInExecutionDetailsDirect) payIn.getExecutionDetails();
            assertNotNull(executionDetails.getSecurityInfo());
            assertNotNull(executionDetails.getSecurityInfo().getAvsResult());
            assertTrue(executionDetails.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createCardDirectIpAddress() {
        try {
            Wallet johnWallet = this.getJohnsWalletWithMoney();
            Wallet beforeWallet = this.api.getWalletApi().get(johnWallet.getId());

            PayIn payIn = this.getNewPayInCardDirectWithIpAddress();
            Wallet wallet = this.api.getWalletApi().get(johnWallet.getId());
            UserNatural user = this.getJohn();

            check(user, payIn, wallet, beforeWallet);

            PayInExecutionDetailsDirect executionDetails = (PayInExecutionDetailsDirect) payIn.getExecutionDetails();
            assertNotNull(executionDetails.getSecurityInfo());
            assertNotNull(executionDetails.getSecurityInfo().getAvsResult());
            assertTrue(executionDetails.getSecurityInfo().getAvsResult() == AVSResult.NO_CHECK);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void getCardDirect() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();

            PayIn getPayIn = this.api.getPayInApi().get(payIn.getId());

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
    public void cardDirectGetPaymentMethodsMetadata() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();

            PaymentMethodMetadata paymentMethodMetadata = new PaymentMethodMetadata();
            paymentMethodMetadata.setType("BIN");
            paymentMethodMetadata.setBin(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardInfo().getBin());

            PaymentMethodMetadata resultMetadata = this.api.getPayInApi().getPaymentMethodMetadata(paymentMethodMetadata);
            assertTrue(resultMetadata.getBin().equals(paymentMethodMetadata.getBin()));
            assertNotNull(resultMetadata.getIssuerCountryCode());
            assertNotNull(resultMetadata.getIssuingBank());
            assertNotNull(resultMetadata.getBinData());
            assertNotNull(resultMetadata.getBinData().get(0).getCardType());

        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createRefundCardDirect() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();
            Wallet wallet = this.getJohnsWalletWithMoney();
            Wallet walletBefore = this.api.getWalletApi().get(wallet.getId());

            Refund refund = this.getNewRefundForPayIn(payIn);
            Wallet walletAfter = this.api.getWalletApi().get(wallet.getId());

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
    public void createPartialRefundCardDirect() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();
            Wallet wallet = this.getJohnsWalletWithMoney();
            Wallet walletBefore = this.api.getWalletApi().get(wallet.getId());

            Refund refund = this.getPartialRefundForPayIn(payIn);
            Wallet walletAfter = this.api.getWalletApi().get(wallet.getId());

            assertTrue(refund.getId().length() > 0);
            assertTrue(walletAfter.getBalance().getAmount() == (walletBefore.getBalance().getAmount() - refund.getDebitedFunds().getAmount()));
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
            payIn.getDebitedFunds().setAmount(100);
            payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
            payIn.setFees(new Money());
            payIn.getFees().setAmount(0);
            payIn.getFees().setCurrency(CurrencyIso.EUR);

            // payment type as CARD
            payIn.setPaymentDetails(new PayInPaymentDetailsPreAuthorized());
            ((PayInPaymentDetailsPreAuthorized) payIn.getPaymentDetails()).setPreauthorizationId(cardPreAuthorization.getId());

            // execution type as DIRECT
            payIn.setExecutionDetails(new PayInExecutionDetailsDirect());
            ((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).setSecureModeReturnUrl("http://test.com");

            PayIn createPayIn = this.api.getPayInApi().create(payIn);

            // wait 2 seconds for the transactions to be created in the API
            Thread.sleep(2000);

            List<Transaction> preAuthTransactions = this.api.getCardPreAuthorizationApi().getTransactions(cardPreAuthorization.getId(), new Pagination(1, 1));

            assertTrue(!"".equals(createPayIn.getId()));
            assertEquals(wallet.getId(), createPayIn.getCreditedWalletId());
            assertTrue(createPayIn.getPaymentType() == PayInPaymentType.PREAUTHORIZED);
            assertTrue(createPayIn.getPaymentDetails() instanceof PayInPaymentDetailsPreAuthorized);
            assertTrue(createPayIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(createPayIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            assertTrue(createPayIn.getDebitedFunds() != null);
            assertTrue(createPayIn.getCreditedFunds() != null);
            assertTrue(createPayIn.getFees() != null);
            assertEquals(user.getId(), createPayIn.getAuthorId());
            assertTrue(createPayIn.getStatus() == TransactionStatus.SUCCEEDED);
            assertTrue(createPayIn.getType() == TransactionType.PAYIN);
            assertTrue(preAuthTransactions.get(0).getStatus() == TransactionStatus.SUCCEEDED);
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

            PayIn createPayIn = this.api.getPayInApi().create(payIn);

            assertTrue(!"".equals(createPayIn.getId()));
            assertEquals(wallet.getId(), createPayIn.getCreditedWalletId());
            assertTrue(createPayIn.getPaymentType() == PayInPaymentType.BANK_WIRE);
            assertTrue(createPayIn.getPaymentDetails() instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getDeclaredDebitedFunds() != null);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getDeclaredFees() != null);
            assertTrue(createPayIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(createPayIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            assertEquals(user.getId(), createPayIn.getAuthorId());
            assertTrue(createPayIn.getStatus() == TransactionStatus.CREATED);
            assertTrue(createPayIn.getType() == TransactionType.PAYIN);
            assertNotNull(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getWireReference());
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount() != null);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getType() == BankAccountType.IBAN);
            assertTrue(((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getDetails() instanceof BankAccountDetailsIBAN);
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getDetails()).getIban());
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) createPayIn.getPaymentDetails()).getBankAccount().getDetails()).getBic());
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
            PayIn createdPayIn = this.api.getPayInApi().create(payIn);

            PayIn getPayIn = this.api.getPayInApi().get(createdPayIn.getId());

            assertEquals(getPayIn.getId(), createdPayIn.getId());
            assertTrue(getPayIn.getPaymentType() == PayInPaymentType.BANK_WIRE);
            assertTrue(getPayIn.getPaymentDetails() instanceof PayInPaymentDetailsBankWire);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getDeclaredDebitedFunds() != null);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getDeclaredFees() != null);
            assertTrue(getPayIn.getExecutionType() == PayInExecutionType.DIRECT);
            assertTrue(getPayIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            assertEquals(user.getId(), getPayIn.getAuthorId());
            assertTrue(getPayIn.getType() == TransactionType.PAYIN);
            assertNotNull(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getWireReference());
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount() != null);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getType() == BankAccountType.IBAN);
            assertTrue(((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getDetails() instanceof BankAccountDetailsIBAN);
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getDetails()).getIban());
            assertNotNull(((BankAccountDetailsIBAN) ((PayInPaymentDetailsBankWire) getPayIn.getPaymentDetails()).getBankAccount().getDetails()).getBic());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void getBankWireExternalInstructionIBAN() {
        try {
            PayIn payIn = this.api.getPayInApi().get("payin_m_01JK6199ED4VGBP98ABRJVDS9D");

            assertTrue(payIn.getPaymentType() == PayInPaymentType.BANK_WIRE);
            assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsBankWire);
            assertTrue(payIn.getExecutionType() == PayInExecutionType.EXTERNAL_INSTRUCTION);
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsBankingAlias);
            assertTrue(((PayInExecutionDetailsBankingAlias) payIn.getExecutionDetails()).getDebitedBankAccount().getType() == BankAccountType.IBAN);

            assertTrue(payIn.getStatus() == TransactionStatus.SUCCEEDED);
            assertTrue(payIn.getExecutionDate() != null);

            assertNotNull(((PayInExecutionDetailsBankingAlias) payIn.getExecutionDetails()).getDebitedBankAccount().getIban());
            assertNull(((PayInExecutionDetailsBankingAlias) payIn.getExecutionDetails()).getDebitedBankAccount().getAccountNumber());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    @Ignore("Expired payin ID")
    public void getBankWireExternalInstructionAccountNumber() {
        try {
            PayIn payIn = this.api.getPayInApi().get("74981216");

            assertTrue(payIn.getPaymentType() == PayInPaymentType.BANK_WIRE);
            assertTrue(payIn.getPaymentDetails() instanceof PayInPaymentDetailsBankWire);
            assertTrue(payIn.getExecutionType() == PayInExecutionType.EXTERNAL_INSTRUCTION);
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsBankingAlias);
            assertTrue(((PayInExecutionDetailsBankingAlias) payIn.getExecutionDetails()).getDebitedBankAccount().getType() == BankAccountType.OTHER);

            assertTrue(payIn.getStatus() == TransactionStatus.SUCCEEDED);
            assertTrue(payIn.getExecutionDate() != null);

            assertNull(((PayInExecutionDetailsBankingAlias) payIn.getExecutionDetails()).getDebitedBankAccount().getIban());
            assertNotNull(((PayInExecutionDetailsBankingAlias) payIn.getExecutionDetails()).getDebitedBankAccount().getAccountNumber());
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
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).setReturnUrl("http://www.mysite.com/returnURL/");
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).setCulture(CultureCode.FR);
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).setTemplateURLOptions(new PayInTemplateURLOptions());
            ((PayInExecutionDetailsWeb) payIn.getExecutionDetails()).getTemplateURLOptions().PAYLINE = "https://www.maysite.com/payline_template/";

            PayIn createPayIn = this.api.getPayInApi().create(payIn);

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
            assertTrue(createPayIn.getDebitedFunds() != null);
            assertTrue(10000 == createPayIn.getDebitedFunds().getAmount());
            assertTrue(createPayIn.getDebitedFunds().getCurrency() == CurrencyIso.EUR);
            assertTrue(createPayIn.getCreditedFunds() != null);
            assertTrue(9900 == createPayIn.getCreditedFunds().getAmount());
            assertTrue(createPayIn.getCreditedFunds().getCurrency() == CurrencyIso.EUR);
            assertTrue(createPayIn.getFees() != null);
            assertTrue(100 == createPayIn.getFees().getAmount());
            assertTrue(createPayIn.getFees().getCurrency() == CurrencyIso.EUR);
            assertNotNull(((PayInExecutionDetailsWeb) createPayIn.getExecutionDetails()).getReturnUrl());
            assertNotNull(((PayInExecutionDetailsWeb) createPayIn.getExecutionDetails()).getRedirectUrl());

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
        mandatePost.setReturnUrl(returnUrl);
        Mandate mandate = this.api.getMandateApi().create(mandatePost);

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

        PayIn createPayIn = this.api.getPayInApi().create(payIn);

        assertNotNull(createPayIn);
        assertNotEquals("In order to make this test pass, after creating mandate and before creating the payin you have to navigate to URL the mandate.RedirectURL property points to and click CONFIRM button.", TransactionStatus.FAILED, createPayIn.getStatus());

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

    @Test
    public void createPayPalWeb() throws Exception {
        UserNatural john = getJohn();
        Wallet wallet = getJohnsWallet();

        PayIn payIn = new PayIn();
        payIn.setAuthorId(john.getId());
        payIn.setCreditedUserId(john.getId());
        payIn.setDebitedFunds(new Money());
        payIn.getDebitedFunds().setAmount(1000);
        payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
        payIn.setFees(new Money());
        payIn.getFees().setAmount(5);
        payIn.getFees().setCurrency(CurrencyIso.EUR);
        payIn.setCreditedWalletId(wallet.getId());
        PayInPaymentDetailsPayPal paymentDetails = new PayInPaymentDetailsPayPal();
        paymentDetails.setShippingAddress(new ShippingAddress());
        paymentDetails.getShippingAddress().setRecipientName(john.getFirstName() + " " + john.getLastName());
        paymentDetails.getShippingAddress().setAddress(getNewAddress());
        payIn.setPaymentDetails(paymentDetails);
        PayInExecutionDetailsWeb executionDetails = new PayInExecutionDetailsWeb();
        executionDetails.setReturnUrl("https://test.com");
        payIn.setExecutionDetails(executionDetails);

        PayIn createdPayIn = api.getPayInApi().create(payIn);

        assertNotNull(createdPayIn);
        assertEqualInputProps(payIn, createdPayIn);
        assertNotNull(createdPayIn.getPaymentDetails());
        assertEqualInputProps(payIn.getPaymentDetails(), createdPayIn.getPaymentDetails());
    }

    @Test
    public void createPayPalWebV2() throws Exception {
        UserNatural john = getJohn();
        Wallet wallet = getJohnsWallet();

        PayIn payIn = new PayIn();
        payIn.setAuthorId(john.getId());

        payIn.setDebitedFunds(new Money());
        payIn.getDebitedFunds().setAmount(1000);
        payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);

        payIn.setFees(new Money());
        payIn.getFees().setAmount(5);
        payIn.getFees().setCurrency(CurrencyIso.EUR);

        payIn.setCreditedWalletId(wallet.getId());

        PayInPaymentDetailsPayPal paymentDetails = new PayInPaymentDetailsPayPal();
        paymentDetails.setShipping(new Shipping());
        paymentDetails.getShipping().setFirstName(john.getFirstName());
        paymentDetails.getShipping().setLastName(john.getLastName());
        paymentDetails.getShipping().setAddress(getNewAddress());

        List<LineItem> lineItems = new ArrayList<>();
        lineItems.add(new LineItem(
                "test",
                1,
                1000,
                0,
                "test descr"
        )
                .setCategory("PHYSICAL_GOODS"));
        paymentDetails.setLineItems(lineItems);
        paymentDetails.setShippingPreference(ShippingPreference.GET_FROM_FILE);
        paymentDetails.setReference("Reference");
        paymentDetails.setStatementDescriptor("sttm");
        paymentDetails.setCancelUrl("http://cancelurl.com");

        payIn.setPaymentDetails(paymentDetails);

        PayInExecutionDetailsWeb executionDetails = new PayInExecutionDetailsWeb();
        executionDetails.setReturnUrl("http://mangopay.com");
        executionDetails.setCulture(CultureCode.FR);
        payIn.setExecutionDetails(executionDetails);

        payIn.setTag("tag");

        PayIn createdPayIn = api.getPayInApi().createPayPal(payIn);

        assertNotNull(createdPayIn);
        assertNotNull(createdPayIn.getPaymentDetails());
        assertEquals(PayInPaymentType.PAYPAL, createdPayIn.getPaymentType());
        assertEquals(PayInExecutionType.WEB, createdPayIn.getExecutionType());
        assertFalse(((PayInPaymentDetailsPayPal) createdPayIn.getPaymentDetails()).getLineItems().isEmpty());
        assertTrue(((PayInPaymentDetailsPayPal) createdPayIn.getPaymentDetails()).getLineItems().get(0) instanceof LineItem);
        assertNotNull(((PayInPaymentDetailsPayPal) createdPayIn.getPaymentDetails()).getLineItems().get(0).getCategory());
    }

    @Test
    public void createPayconiqWeb() throws Exception {
        UserNatural john = getJohn();
        Wallet wallet = getJohnsWallet();

        PayIn payIn = new PayIn();
        payIn.setAuthorId(john.getId());
        payIn.setCreditedUserId(john.getId());
        payIn.setDebitedFunds(new Money());
        payIn.getDebitedFunds().setAmount(1000);
        payIn.getDebitedFunds().setCurrency(CurrencyIso.EUR);
        payIn.setFees(new Money());
        payIn.getFees().setAmount(5);
        payIn.getFees().setCurrency(CurrencyIso.EUR);
        payIn.setCreditedWalletId(wallet.getId());
        PayInPaymentDetailsPayconiq paymentDetails = new PayInPaymentDetailsPayconiq();
        paymentDetails.setCountry("BE");
        payIn.setPaymentDetails(paymentDetails);
        PayInExecutionDetailsWeb executionDetails = new PayInExecutionDetailsWeb();
        executionDetails.setReturnUrl("http://www.my-site.com/returnURL");
        payIn.setExecutionDetails(executionDetails);

        PayIn createdPayIn = api.getPayInApi().create(payIn);

        assertNotNull(createdPayIn);
        assertEqualInputProps(payIn, createdPayIn);
        assertNotNull(createdPayIn.getPaymentDetails());
    }

    @Test
    public void getPayInRefunds() throws Exception {
        PayIn payIn = getNewPayInCardDirect();
        Refund firstRefund = getNewRefundForPayIn(payIn);
        Thread.sleep(5000);//wait to create second refund
        Refund secondRefund = getNewRefundForPayIn(payIn);
        Pagination pagination = new Pagination(1, 1);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.asc);
        List<Refund> firstPage = this.api.getPayInApi().getRefunds(payIn.getId(), pagination, sorting);
        pagination.setPage(2);
        List<Refund> secondPage = this.api.getPayInApi().getRefunds(payIn.getId(), pagination, sorting);


        assertNotNull("Refunds first page is null", firstPage);
        assertNotNull("Refunds second page is null", secondPage);
        assertTrue("Refund first page size is not 1", firstPage.size() == 1);
        assertTrue("Refund second page size is not 1", secondPage.size() == 1);
        assertTrue("First page does not contain first refund", firstPage.get(0).getId().equals(firstRefund.getId()));
        assertTrue("Second page does not contain second refund", secondPage.get(0).getId().equals(secondRefund.getId()));

    }

    @Test
    @Ignore("Can't be tested - returned value is null")
    public void testPayPalAccountEmail() throws Exception {
        String payInId = "54088959";
        String payPalBuyerEmail = "paypal-buyer-user@mangopay.com";
        PayIn payIn = this.api.getPayInApi().get(payInId);

        assertNotNull("PayIn is null", payIn);
        assertEquals("Payment is not of PayPal type", PayInPaymentType.PAYPAL, payIn.getPaymentType());

        PayInPaymentDetailsPayPal paymentDetails = (PayInPaymentDetailsPayPal) payIn.getPaymentDetails();
        assertNotNull("Payment details are null", paymentDetails);
        assertNotNull("Payment account email is not null", paymentDetails.getPaypalBuyerAccountEmail());
        assertEquals("Expected PayPal buyer account doesn't match", payPalBuyerEmail, paymentDetails.getPaypalBuyerAccountEmail());
    }

    @Test
    public void testDirectPayInCultureCode() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();

            assertNotNull(payIn);
            assertNotNull(payIn.getExecutionDetails());
            assertTrue(payIn.getExecutionDetails() instanceof PayInExecutionDetailsDirect);
            PayInExecutionDetailsDirect executionDetails = (PayInExecutionDetailsDirect) payIn.getExecutionDetails();
            assertNotNull("Culture code is null", executionDetails.getCulture());
            assertEquals(((PayInExecutionDetailsDirect) payIn.getExecutionDetails()).getCulture(), executionDetails.getCulture());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDirectPayInCheckCardInfo() {
        try {
            PayIn payIn = this.getNewPayInCardDirect();

            assertNotNull(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardInfo());
            assertNotNull(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardInfo().getBrand());
            assertNotNull(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardInfo().getType());
            assertNotNull(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardInfo().getIssuingBank());
            assertNotNull(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardInfo().getBin());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDirectApplepayPayin() {
        try {
            Wallet wallet = getJohnsWallet();
            PaymentData paymentData = new PaymentData()
                    .setTransactionId("061EB32181A2D9CA42AD16031B476EEBAA62A9A095AD660E2759FBA52B51A61")
                    .setNetwork("VISA")
                    .setTokenData("{\"version\":\"EC_v1\"," +
                            "\"data\":\"w4HMBVqNC9ghPP4zncTA\\/0oQAsduERfsx78oxgniynNjZLANTL6+0koEtkQnW\\/K38Zew8qV1GLp+fLHo+qCBpiKCIwlz3eoFBTbZU+8pYcjaeIYBX9SOxcwxXsNGrGLk+kBUqnpiSIPaAG1E+WPT8R1kjOCnGvtdombvricwRTQkGjtovPfzZo8LzD3ZQJnHMsWJ8QYDLyr\\/ZN9gtLAtsBAMvwManwiaG3pOIWpyeOQOb01YcEVO16EZBjaY4x4C\\/oyFLWDuKGvhbJwZqWh1d1o9JT29QVmvy3Oq2JEjq3c3NutYut4rwDEP4owqI40Nb7mP2ebmdNgnYyWfPmkRfDCRHIWtbMC35IPg5313B1dgXZ2BmyZRXD5p+mr67vAk7iFfjEpu3GieFqwZrTl3\\/pI5V8Sxe3SIYKgT5Hr7ow==\"," +
                            "\"signature\":\"MIAGCSqGSIb3DQEHAqCAMIACAQExDzANBglghkgBZQMEAgEFADCABgkqhkiG9w0BBwEAAKCAMIID5jCCA4ugAwIBAgIIaGD2mdnMpw8wCgYIKoZIzj0EAwIwejEuMCwGA1UEAwwlQXBwbGUgQXBwbGljYXRpb24gSW50ZWdyYXRpb24gQ0EgLSBHMzEmMCQGA1UECwwdQXBwbGUgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkxEzARBgNVBAoMCkFwcGxlIEluYy4xCzAJBgNVBAYTAlVTMB4XDTE2MDYwMzE4MTY0MFoXDTIxMDYwMjE4MTY0MFowYjEoMCYGA1UEAwwfZWNjLXNtcC1icm9rZXItc2lnbl9VQzQtU0FOREJPWDEUMBIGA1UECwwLaU9TIFN5c3RlbXMxEzARBgNVBAoMCkFwcGxlIEluYy4xCzAJBgNVBAYTAlVTMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEgjD9q8Oc914gLFDZm0US5jfiqQHdbLPgsc1LUmeY+M9OvegaJajCHkwz3c6OKpbC9q+hkwNFxOh6RCbOlRsSlaOCAhEwggINMEUGCCsGAQUFBwEBBDkwNzA1BggrBgEFBQcwAYYpaHR0cDovL29jc3AuYXBwbGUuY29tL29jc3AwNC1hcHBsZWFpY2EzMDIwHQYDVR0OBBYEFAIkMAua7u1GMZekplopnkJxghxFMAwGA1UdEwEB\\/wQCMAAwHwYDVR0jBBgwFoAUI\\/JJxE+T5O8n5sT2KGw\\/orv9LkswggEdBgNVHSAEggEUMIIBEDCCAQwGCSqGSIb3Y2QFATCB\\/jCBwwYIKwYBBQUHAgIwgbYMgbNSZWxpYW5jZSBvbiB0aGlzIGNlcnRpZmljYXRlIGJ5IGFueSBwYXJ0eSBhc3N1bWVzIGFjY2VwdGFuY2Ugb2YgdGhlIHRoZW4gYXBwbGljYWJsZSBzdGFuZGFyZCB0ZXJtcyBhbmQgY29uZGl0aW9ucyBvZiB1c2UsIGNlcnRpZmljYXRlIHBvbGljeSBhbmQgY2VydGlmaWNhdGlvbiBwcmFjdGljZSBzdGF0ZW1lbnRzLjA2BggrBgEFBQcCARYqaHR0cDovL3d3dy5hcHBsZS5jb20vY2VydGlmaWNhdGVhdXRob3JpdHkvMDQGA1UdHwQtMCswKaAnoCWGI2h0dHA6Ly9jcmwuYXBwbGUuY29tL2FwcGxlYWljYTMuY3JsMA4GA1UdDwEB\\/wQEAwIHgDAPBgkqhkiG92NkBh0EAgUAMAoGCCqGSM49BAMCA0kAMEYCIQDaHGOui+X2T44R6GVpN7m2nEcr6T6sMjOhZ5NuSo1egwIhAL1a+\\/hp88DKJ0sv3eT3FxWcs71xmbLKD\\/QJ3mWagrJNMIIC7jCCAnWgAwIBAgIISW0vvzqY2pcwCgYIKoZIzj0EAwIwZzEbMBkGA1UEAwwSQXBwbGUgUm9vdCBDQSAtIEczMSYwJAYDVQQLDB1BcHBsZSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTETMBEGA1UECgwKQXBwbGUgSW5jLjELMAkGA1UEBhMCVVMwHhcNMTQwNTA2MjM0NjMwWhcNMjkwNTA2MjM0NjMwWjB6MS4wLAYDVQQDDCVBcHBsZSBBcHBsaWNhdGlvbiBJbnRlZ3JhdGlvbiBDQSAtIEczMSYwJAYDVQQLDB1BcHBsZSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTETMBEGA1UECgwKQXBwbGUgSW5jLjELMAkGA1UEBhMCVVMwWTATBgcqhkjOPQIBBggqhkjOPQMBBwNCAATwFxGEGddkhdUaXiWBB3bogKLv3nuuTeCN\\/EuT4TNW1WZbNa4i0Jd2DSJOe7oI\\/XYXzojLdrtmcL7I6CmE\\/1RFo4H3MIH0MEYGCCsGAQUFBwEBBDowODA2BggrBgEFBQcwAYYqaHR0cDovL29jc3AuYXBwbGUuY29tL29jc3AwNC1hcHBsZXJvb3RjYWczMB0GA1UdDgQWBBQj8knET5Pk7yfmxPYobD+iu\\/0uSzAPBgNVHRMBAf8EBTADAQH\\/MB8GA1UdIwQYMBaAFLuw3qFYM4iapIqZ3r6966\\/ayySrMDcGA1UdHwQwMC4wLKAqoCiGJmh0dHA6Ly9jcmwuYXBwbGUuY29tL2FwcGxlcm9vdGNhZzMuY3JsMA4GA1UdDwEB\\/wQEAwIBBjAQBgoqhkiG92NkBgIOBAIFADAKBggqhkjOPQQDAgNnADBkAjA6z3KDURaZsYb7NcNWymK\\/9Bft2Q91TaKOvvGcgV5Ct4n4mPebWZ+Y1UENj53pwv4CMDIt1UQhsKMFd2xd8zg7kGf9F3wsIW2WT8ZyaYISb1T4en0bmcubCYkhYQaZDwmSHQAAMYIBizCCAYcCAQEwgYYwejEuMCwGA1UEAwwlQXBwbGUgQXBwbGljYXRpb24gSW50ZWdyYXRpb24gQ0EgLSBHMzEmMCQGA1UECwwdQXBwbGUgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkxEzARBgNVBAoMCkFwcGxlIEluYy4xCzAJBgNVBAYTAlVTAghoYPaZ2cynDzANBglghkgBZQMEAgEFAKCBlTAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEPFw0xOTA1MjMxMTA1MDdaMCoGCSqGSIb3DQEJNDEdMBswDQYJYIZIAWUDBAIBBQChCgYIKoZIzj0EAwIwLwYJKoZIhvcNAQkEMSIEIIvfGVQYBeOilcB7GNI8m8+FBVZ28QfA6BIXaggBja2PMAoGCCqGSM49BAMCBEYwRAIgU01yYfjlx9bvGeC5CU2RS5KBEG+15HH9tz\\/sg3qmQ14CID4F4ZJwAz+tXAUcAIzoMpYSnM8YBlnGJSTSp+LhspenAAAAAAAA\"," +
                            "\"header\":" +
                            "{\"ephemeralPublicKey\":\"MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE0rs3wRpirXjPbFDQfPRdfEzRIZDWm0qn7Y0HB0PNzV1DDKfpYrnhRb4GEhBF\\/oEXBOe452PxbCnN1qAlqcSUWw==\"," +
                            "\"publicKeyHash\":\"saPRAqS7TZ4bAYwzBj8ezDDC55ZolyH1FL+Xc8fd93o=\"," +
                            "\"transactionId\":\"b061eb32181a2d9ca42ad16031b476eebaa62a9a095ad660e2759fba52b51a61\"}}");
            PayIn applePayPayin = new PayIn();
            applePayPayin.setCreditedWalletId(wallet.getId());
            applePayPayin.setAuthorId(this.getMatrixOwner().getId());
            applePayPayin.setCreditedUserId(this.getMatrixOwner().getId());
            applePayPayin.setDebitedFunds(new Money()
                .setAmount(5)
                    .setCurrency(CurrencyIso.EUR)
            );
            applePayPayin.setFees(new Money()
                .setAmount(0)
                    .setCurrency(CurrencyIso.EUR)
            );
            applePayPayin.setPaymentType(PayInPaymentType.APPLEPAY);
            applePayPayin.setExecutionType(PayInExecutionType.DIRECT);
            applePayPayin.setPaymentDetails(new PayInPaymentDetailsApplePay()
                    .setPaymentData(paymentData)
                    .setStatementDescriptor("Java"));
            applePayPayin.setTag("Create an ApplePay card direct Payin");

            PayIn createdPayin = this.api.getPayInApi().create(applePayPayin);

            assertNotNull(createdPayin);
            assertEquals(applePayPayin.getAuthorId(), createdPayin.getAuthorId());
            assertEquals(createdPayin.getPaymentType(), PayInPaymentType.APPLEPAY);

            // SUCCEEDED payment can only be tested manually with updated payment data
//            assertEquals(createdPayin.getStatus(), TransactionStatus.SUCCEEDED);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Ignore("Deprecated")
    @Test
    public void testDirectGooglepayPayin() {
        try {
            Wallet wallet = getJohnsWallet();
            PaymentData paymentData = new PaymentData()
                    .setTransactionId("placeholder")
                    .setNetwork("placeholder")
                    .setTokenData("placeholder");
            PayIn googlePayIn = new PayIn();
            googlePayIn.setCreditedWalletId(wallet.getId());
            googlePayIn.setAuthorId(this.getMatrixOwner().getId());
            googlePayIn.setCreditedUserId(this.getMatrixOwner().getId());
            googlePayIn.setDebitedFunds(new Money()
                    .setAmount(199)
                    .setCurrency(CurrencyIso.EUR)
            );
            googlePayIn.setFees(new Money()
                    .setAmount(1)
                    .setCurrency(CurrencyIso.EUR)
            );
            googlePayIn.setPaymentType(PayInPaymentType.GOOGLEPAY);
            googlePayIn.setExecutionType(PayInExecutionType.DIRECT);
            googlePayIn.setPaymentDetails(new PayInPaymentDetailsGooglePay()
                    .setPaymentData(paymentData)
                    .setBilling(new Billing())
                    .setStatementDescriptor("Java"));
            googlePayIn.setTag("Create an GooglePay card direct Payin");

            PayIn createdPayIn = this.api.getPayInApi().create(googlePayIn);

            assertNotNull(createdPayIn);
            assertEquals(googlePayIn.getAuthorId(), createdPayIn.getAuthorId());
            assertEquals(createdPayIn.getPaymentType(), PayInPaymentType.GOOGLEPAY);
            assertEquals(createdPayIn.getStatus(), TransactionStatus.SUCCEEDED);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Ignore("Cannot generate payment data in tests")
    public void testDirectGooglepayV2Payin() {
        try {
            Wallet wallet = getJohnsWallet();

            String paymentData = "{\"signature\":\"MEUCIEMVk9qrfoJ/ku5qvHCZuv9zPC1QVH6NMMrkZ6wLmt8FAiEAjNduo5gvMGE4KgTeTIuwevdvxJdkQP03ru9lp/5rKhk\\u003d\",\"intermediateSigningKey\":{\"signedKey\":\"{\\\"keyValue\\\":\\\"MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEC1gn5CSvw/UxS9+PCVhgPWNTMGxTBUHpenGNWirrNlmi5bJts3FO92DjcUQmLaCmM1hQwtZ9KCzkc0SGh99X4A\\\\u003d\\\\u003d\\\",\\\"keyExpiration\\\":\\\"1694758343052\\\"}\",\"signatures\":[\"MEUCIG+oaBGEl63CqCy+C7OwQCFvr/K9cSYWtQ/ku2UejCTKAiEAnhJ1LXd+JMMvueEorp0Kha922H9wRMR6tPvnGIZ6cM4\\u003d\"]},\"protocolVersion\":\"ECv2\",\"signedMessage\":\"{\\\"encryptedMessage\\\":\\\"HmCQdP5BOdsv33ACkGyYJYKFHEnxRbe+TTaTI79tJm/v8NP4XH5Iim9H/a1jj2OmZTgQDklZ6pv1v6XNjKkkaEMPW1MZbtZ2P8GcwAWRKKJx8W4ZmDexb564GP8EvLw4dGzlYE8L5nY7khunPZKAfioQGmNSTIBpB1MLRtgArGA9T/w3EcjU1+gdGAce7NpcZeVIrIX4tNLL5TlpGdAHRU5XNlA/q0HcuvKpmgCfpnSJKu1xPO8Xzoa7C7toX6GmmGlkdhH0Y+vK+mKFpI02uGItSPR64vaZYFD7qPMzXOsp7KjyGw1Tr6fx0Qrmc3CeDcZ3Dzc/WVbM0jw1gMz/gjnZ7KILoqMNxcEz1h8rkLp7FHjCNlls0i6VYNINWWl1PMqHTDBsTsHVdYJlAqycoBJTssHy44ASBIF8epBw3oAydhFV4ZkeLPX/x+QlrS+IEi3af8xj//nhtZ5CwwW5IOuMF0sqAa0PcRVpgw9BrQSXNprymtatS3qtwRrL0LHJsIii+xSI5XY4dfy6Z6j1QCvWriCwfbS9TasvbMb6dbh0S6sS5XBHd5wp/FtHfYBAh9iK08DQ8uKcKfnZx4zmvU5TsSTTbrj/SEFJiJ3rBegIweEpYM3m1QifErNAVhBIpm67tg\\\\u003d\\\\u003d\\\",\\\"ephemeralPublicKey\\\":\\\"BCr5xXtNJMkCYutxBQi8sQBHllG4RcSrxalvi0bf23Jwvyr46OwNGfMe45518pxNzPC8yPUXrGTbKXoQeJR16Ew\\\\u003d\\\",\\\"tag\\\":\\\"5W+s9OGQTFEojaZ5K3ynKuUVninxOVep9pkmqI/+ed4\\\\u003d\\\"}\"}";
            PayIn googlePayIn = new PayIn();
            googlePayIn.setCreditedWalletId(wallet.getId());
            googlePayIn.setAuthorId(this.getMatrixOwner().getId());
            googlePayIn.setDebitedFunds(new Money()
                    .setAmount(112)
                    .setCurrency(CurrencyIso.EUR)
            );
            googlePayIn.setFees(new Money()
                    .setAmount(1)
                    .setCurrency(CurrencyIso.EUR)
            );
            googlePayIn.setPaymentType(PayInPaymentType.GOOGLE_PAY);
            googlePayIn.setExecutionType(PayInExecutionType.DIRECT);
            googlePayIn.setPaymentDetails(new PayInPaymentDetailsGooglePayV2()
                    .setPaymentData(paymentData)
                    .setShipping(this.getNewShipping())
                    .setIpAddress("127.0.0.1")
                    .setStatementDescriptor("Java")
                    .setBrowserInfo(this.getNewBrowserInfo()));

            googlePayIn.setExecutionDetails(new PayInExecutionDetailsDirect()
                    .setSecureModeReturnUrl("http://www.my-site.com/returnUrl")
                    .setSecureModeRedirectUrl("http://www.my-site.com/redirectUrl"));
            googlePayIn.setTag("Create an GooglePay card direct Payin");

            PayIn createdPayIn = this.api.getPayInApi().create(googlePayIn);
            assertNotNull(createdPayIn);
            assertEquals(googlePayIn.getAuthorId(), createdPayIn.getAuthorId());
            assertEquals(createdPayIn.getPaymentType(), PayInPaymentType.GOOGLE_PAY);
        } catch (Exception e) {
            fail(String.valueOf(e));
        }
    }

    @Test
    public void testCreateRecurringPayment() {
        try {
            RecurringPayment result = this.createJohnsRecurringPayment();
            assertNotNull(result);
            assertNotNull(result.getFreeCycles());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetRecurringPayment() {
        try {
            RecurringPayment result = this.createJohnsRecurringPayment();
            assertNotNull(result);

            RecurringPaymentExtended get = this.api.getPayInApi().getRecurringPayment(result.getId());
            assertNotNull(get);
            assertNotNull(get.getCurrentState());
            assertNotNull(get.getFreeCycles());
            assertTrue(get.getId().equals(result.getId()));

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testUpdateRecurringPayment() {
        try {
            RecurringPayment result = this.createJohnsRecurringPayment();
            assertNotNull(result);

            RecurringPaymentExtended get = this.api.getPayInApi().getRecurringPayment(result.getId());
            assertNotNull(get);
            assertNotNull(get.getCurrentState());
            assertTrue(get.getId().equals(result.getId()));
            RecurringPaymentUpdate update = new RecurringPaymentUpdate();
            update.setBilling(this.getNewBilling());
            update.getBilling().setFirstName("TEST");
            update.setShipping(this.getNewShipping());
            update.setStatus("ENDED");

            RecurringPaymentExtended updated = this.api.getPayInApi().updateRecurringPayment(get.getId(), update);
            assertNotNull(updated);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateRecurringPaymentCIT() {
        try {
            RecurringPayment result = this.createJohnsRecurringPayment();

            RecurringPayInCIT cit = new RecurringPayInCIT();
            cit.setRecurringPayInRegistrationId(result.getId());
            cit.setIpAddress("2001:0620:0000:0000:0211:24FF:FE80:C12C");
            cit.setSecureModeReturnURL("http://www.my-site.com/returnurl");
            cit.setStatementDescriptor("lorem");
            cit.setTag("custom meta");
            cit.setBrowserInfo(this.getNewBrowserInfo());
            RecurringPayIn createdCit = this.api.getPayInApi().createRecurringPayInCIT(null, cit);

            PayIn getAsPayIn = this.api.getPayInApi().get(createdCit.getId());

            assertNotNull(createdCit);
            assertNotNull(createdCit.getExecutionDetails());

            PayInExecutionDetailsDirect direct = (PayInExecutionDetailsDirect) createdCit.getExecutionDetails();

            assertNotNull(direct.getSecureModeReturnUrl());
            assertNotNull(getAsPayIn);
            PayInExecutionDetailsDirect payInGetDirect = (PayInExecutionDetailsDirect) getAsPayIn.getExecutionDetails();
            assertEquals(payInGetDirect.getRecurringPayInRegistrationId(), result.getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateRecurringPaymentMIT() {
        try {
            Map<String, String> data = this.getJohnsWalletWithMoney3DSecure(1000);
            UserNatural john = this.getJohn();

            CreateRecurringPayment createRecurringPayment = new CreateRecurringPayment();
            createRecurringPayment.setAuthorId(john.getId());
            createRecurringPayment.setCardId(data.get("cardId"));
            createRecurringPayment.setCreditedUserId(john.getId());
            createRecurringPayment.setCreditedWalletId(data.get("walletId"));
            createRecurringPayment.setFirstTransactionDebitedFunds(new Money().setAmount(10).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setFirstTransactionFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setShipping(this.getNewShipping());
            createRecurringPayment.setBilling(this.getNewBilling());
            createRecurringPayment.setEndDate(1833374495L);
            createRecurringPayment.setMigration(true);
            createRecurringPayment.setNextTransactionDebitedFunds(new Money().setAmount(12).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setNextTransactionFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setFrequency("Daily");
            createRecurringPayment.setFixedNextAmount(true);
            createRecurringPayment.setFractionedPayment(false);

            RecurringPayment result = api.getPayInApi().createRecurringPayment(null, createRecurringPayment);

            RecurringPayInCIT cit = new RecurringPayInCIT();
            cit.setRecurringPayInRegistrationId(result.getId());
            cit.setIpAddress("2001:0620:0000:0000:0211:24FF:FE80:C12C");
            cit.setSecureModeReturnURL("http://www.my-site.com/returnurl");
            cit.setStatementDescriptor("lorem");
            cit.setTag("custom meta");
            cit.setBrowserInfo(this.getNewBrowserInfo());
            cit.setFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            cit.setDebitedFunds(new Money().setAmount(11).setCurrency(CurrencyIso.EUR));
            RecurringPayIn createdCit = this.api.getPayInApi().createRecurringPayInCIT(null, cit);

            RecurringPayInMIT mit = new RecurringPayInMIT();
            mit.setRecurringPayInRegistrationId(result.getId());
            mit.setFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            mit.setDebitedFunds(new Money().setAmount(12).setCurrency(CurrencyIso.EUR));
            mit.setStatementDescriptor("lorem");
            mit.setTag("custom meta");
            RecurringPayIn createdMit = this.api.getPayInApi().createRecurringPayInMIT(null, mit);

            PayIn getAsPayIn = this.api.getPayInApi().get(createdMit.getId());

            assertNotNull(createdMit);
            assertNotNull(createdMit.getExecutionDetails());

            PayInExecutionDetailsDirect direct = (PayInExecutionDetailsDirect) createdMit.getExecutionDetails();

            assertNotNull(getAsPayIn);
            PayInExecutionDetailsDirect payInGetDirect = (PayInExecutionDetailsDirect) getAsPayIn.getExecutionDetails();
            assertEquals(payInGetDirect.getRecurringPayInRegistrationId(), result.getId());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateRecurringPaymentMITCheckCardInfo() {
        try {
            Map<String, String> data = this.getJohnsWalletWithMoney3DSecure(1000);
            UserNatural john = this.getJohn();

            CreateRecurringPayment createRecurringPayment = new CreateRecurringPayment();
            createRecurringPayment.setAuthorId(john.getId());
            createRecurringPayment.setCardId(data.get("cardId"));
            createRecurringPayment.setCreditedUserId(john.getId());
            createRecurringPayment.setCreditedWalletId(data.get("walletId"));
            createRecurringPayment.setFirstTransactionDebitedFunds(new Money().setAmount(10).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setFirstTransactionFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setShipping(this.getNewShipping());
            createRecurringPayment.setBilling(this.getNewBilling());
            createRecurringPayment.setEndDate(1833374495L);
            createRecurringPayment.setMigration(true);
            createRecurringPayment.setNextTransactionDebitedFunds(new Money().setAmount(12).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setNextTransactionFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            createRecurringPayment.setFrequency("Daily");
            createRecurringPayment.setFixedNextAmount(true);
            createRecurringPayment.setFractionedPayment(false);

            RecurringPayment result = api.getPayInApi().createRecurringPayment(null, createRecurringPayment);

            RecurringPayInCIT cit = new RecurringPayInCIT();
            cit.setRecurringPayInRegistrationId(result.getId());
            cit.setIpAddress("2001:0620:0000:0000:0211:24FF:FE80:C12C");
            cit.setSecureModeReturnURL("http://www.my-site.com/returnurl");
            cit.setStatementDescriptor("lorem");
            cit.setTag("custom meta");
            cit.setBrowserInfo(this.getNewBrowserInfo());
            cit.setFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            cit.setDebitedFunds(new Money().setAmount(11).setCurrency(CurrencyIso.EUR));
            RecurringPayIn createdCit = this.api.getPayInApi().createRecurringPayInCIT(null, cit);

            assertNotNull(((PayInPaymentDetailsCard) createdCit.getPaymentDetails()).getCardInfo());
            assertNotNull(((PayInPaymentDetailsCard) createdCit.getPaymentDetails()).getCardInfo().getBrand());
            assertNotNull(((PayInPaymentDetailsCard) createdCit.getPaymentDetails()).getCardInfo().getType());
            assertNotNull(((PayInPaymentDetailsCard) createdCit.getPaymentDetails()).getCardInfo().getIssuingBank());
            assertNotNull(((PayInPaymentDetailsCard) createdCit.getPaymentDetails()).getCardInfo().getBin());

            RecurringPayInMIT mit = new RecurringPayInMIT();
            mit.setRecurringPayInRegistrationId(result.getId());
            mit.setFees(new Money().setAmount(1).setCurrency(CurrencyIso.EUR));
            mit.setDebitedFunds(new Money().setAmount(12).setCurrency(CurrencyIso.EUR));
            mit.setStatementDescriptor("lorem");
            mit.setTag("custom meta");
            RecurringPayIn createdMit = this.api.getPayInApi().createRecurringPayInMIT(null, mit);

            assertNotNull(((PayInPaymentDetailsCard) createdMit.getPaymentDetails()).getCardInfo());
            assertNotNull(((PayInPaymentDetailsCard) createdMit.getPaymentDetails()).getCardInfo().getBrand());
            assertNotNull(((PayInPaymentDetailsCard) createdMit.getPaymentDetails()).getCardInfo().getType());
            assertNotNull(((PayInPaymentDetailsCard) createdMit.getPaymentDetails()).getCardInfo().getIssuingBank());
            assertNotNull(((PayInPaymentDetailsCard) createdMit.getPaymentDetails()).getCardInfo().getBin());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIssue220() {
        try {
            Wallet wallet = getJohnsWallet();
            UserNatural user = getJohn();

            PayIn payIn = new PayIn();
            payIn.setPaymentType(PayInPaymentType.CARD);

            payIn.setCreditedWalletId(wallet.getId());
            payIn.setAuthorId(user.getId());

            PayInPaymentDetailsCard pay = new PayInPaymentDetailsCard();
            pay.setCardType(CardType.CB_VISA_MASTERCARD);
            payIn.setPaymentDetails(pay);

            payIn.setDebitedFunds(new Money(CurrencyIso.EUR,
                    20)); //cents
            payIn.setFees(new Money(CurrencyIso.EUR, 2));

            payIn.setExecutionType(PayInExecutionType.WEB);
            PayInExecutionDetailsWeb payInExecutionDetailsWeb = new PayInExecutionDetailsWeb();
            payInExecutionDetailsWeb.setReturnUrl("http://www.mysite.com/returnURL/");
            payInExecutionDetailsWeb.setCulture(CultureCode.EN);

            payIn.setExecutionDetails(payInExecutionDetailsWeb);

            PayIn created = api.getPayInApi().create(payIn);
            String returnUrlCreated = ((PayInExecutionDetailsWeb) created.getExecutionDetails()).getReturnUrl();

            assertNotNull(created);
            assertNotNull(created.getExecutionDetails());
            assertNotNull(returnUrlCreated);
            assertTrue(returnUrlCreated.contains("http://www.mysite.com/returnURL/"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Ignore("Manual deposit confirmation needed")
    @Test
    public void testCreateCardPreAuthorizedDepositPayIn() {
        try {
            Deposit deposit = this.createNewDeposit();
            Wallet wallet = this.getJohnsWallet();

            Money debitedFunds = new Money(CurrencyIso.EUR, 1000);
            Money fees = new Money(CurrencyIso.EUR, 0);

            CreateCardPreAuthorizedDepositPayIn dto = new CreateCardPreAuthorizedDepositPayIn(
                    wallet.getId(),
                    debitedFunds,
                    fees,
                    deposit.getId()
            );

            CardPreAuthorizedDepositPayIn payIn = this.api.getPayInApi().createCardPreAuthorizedDepositPayIn(dto, null);

            Assert.assertNotNull(payIn);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void createMbwayWeb() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWalletWithMoney();
            PayIn payIn = this.getNewPayInMbwayWeb(user.getId());

            PayIn created = api.getPayInApi().create(payIn);

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, payIn.getStatus());
            assertEquals(PayInPaymentType.MBWAY, payIn.getPaymentType());
            assertEquals(PayInExecutionType.WEB, payIn.getExecutionType());
            assertEquals(wallet.getId(), payIn.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createSatispayWebPayIn() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWalletWithMoney();
            PayIn created = this.getNewPayInSatispayWeb(user.getId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.SATISPAY, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createBlikWebPayIn() {
        try {
            UserNatural user = this.getJohn();
            PayIn created = this.getNewPayInBlikWeb(user.getId());
            Wallet wallet = api.getWalletApi().get(created.getCreditedWalletId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.BLIK, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createMultibancoWebPayIn() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWalletWithMoney();
            PayIn created = this.getNewPayInMultibancoWeb(user.getId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.MULTIBANCO, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createKlarnaWeb() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWalletWithMoney();
            PayIn created = this.getNewPayInKlarnaWeb(user.getId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.KLARNA, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createIdealWeb() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWalletWithMoney();
            PayIn created = this.getNewPayInIdealWeb(user.getId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.IDEAL, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createGiropayWeb() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWalletWithMoney();
            PayIn created = this.getNewPayInGiropayWeb(user.getId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.GIROPAY, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createTwintWeb() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWallet(CurrencyIso.CHF);
            PayIn created = this.getNewPayInTwintWeb(user.getId(), wallet.getId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.TWINT, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createBancontactWeb() {
        try {
            UserNatural user = this.getJohn();
            Wallet wallet = this.getJohnsWalletWithMoney();
            PayIn created = this.getNewPayInBancontactWeb(user.getId());

            assertNotNull(created);
            assertEquals(TransactionStatus.CREATED, created.getStatus());
            assertEquals(PayInPaymentType.BCMC, created.getPaymentType());
            assertEquals(PayInExecutionType.WEB, created.getExecutionType());
            assertEquals(wallet.getId(), created.getCreditedWalletId());

            PayIn fetched = api.getPayInApi().get(created.getId());
            assertNotNull(fetched);
            assertEquals(created.getId(), fetched.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createLegacyIdealPayIn() {
        try {
            Wallet wallet = getJohnsWallet();
            UserNatural user = getJohn();

            PayIn payIn = new PayIn();
            payIn.setPaymentType(PayInPaymentType.CARD);

            payIn.setCreditedWalletId(wallet.getId());
            payIn.setAuthorId(user.getId());

            PayInPaymentDetailsCard pay = new PayInPaymentDetailsCard();
            pay.setCardType(CardType.IDEAL);
            pay.setBic("ABNANL2A");
            payIn.setPaymentDetails(pay);

            payIn.setDebitedFunds(new Money(CurrencyIso.EUR, 1000));
            payIn.setFees(new Money(CurrencyIso.EUR, 100));

            payIn.setExecutionType(PayInExecutionType.WEB);
            PayInExecutionDetailsWeb payInExecutionDetailsWeb = new PayInExecutionDetailsWeb();
            payInExecutionDetailsWeb.setReturnUrl("http://www.mysite.com/returnURL/");
            payInExecutionDetailsWeb.setCulture(CultureCode.EN);

            payIn.setExecutionDetails(payInExecutionDetailsWeb);

            PayIn created = api.getPayInApi().create(payIn);

            assertNotNull(created);
            assertNotNull(((PayInPaymentDetailsCard) created.getPaymentDetails()).getBankName());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
