package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConversionsImplTest extends BaseTest {

    @Test
    public void getConversionRateTest() throws Exception {
        ConversionRate conversionRate = getConversionRate();

        assertNotNull(conversionRate);
        assertNotNull(conversionRate.clientRate);
        assertNotNull(conversionRate.marketRate);
    }

    @Test
    public void createInstantConversionTest() throws Exception {
        Conversion instantConversion = createInstantConversion();

        assertNotNull(instantConversion);
        assertNotNull(instantConversion.creditedFunds.getAmount());
        assertNotNull(instantConversion.debitedFunds.getAmount());
        assertEquals(instantConversion.status, TransactionStatus.SUCCEEDED);
        assertEquals(instantConversion.type, TransactionType.CONVERSION);
    }

    @Test
    public void getInstantConversionTest() throws Exception {
        Conversion instantConversion = getInstantConversion();

        assertNotNull(instantConversion);
        assertNotNull(instantConversion.creditedFunds.getAmount());
        assertNotNull(instantConversion.debitedFunds.getAmount());
        assertEquals(instantConversion.status, TransactionStatus.SUCCEEDED);
        assertEquals(instantConversion.type, TransactionType.CONVERSION);

    }

    @Test
    public void createConversionQuoteTest() throws Exception {
        ConversionQuote conversionQuote = createConversionQuote();

        assertNotNull(conversionQuote);
        assertNotNull(conversionQuote.getDebitedFunds());
        assertNotNull(conversionQuote.getCreditedFunds());
        assertNotNull(conversionQuote.getConversionRateResponse());
        assertEquals("ACTIVE", conversionQuote.getStatus());

    }

    @Test
    public void getConversionQuoteTest() throws Exception {
        ConversionQuote createdConversionQuote = createConversionQuote();
        ConversionQuote conversionQuote = this.api.getConversionsApi().getConversionQuote(createdConversionQuote.getId());

        assertNotNull(conversionQuote);
        assertNotNull(conversionQuote.getDebitedFunds());
        assertNotNull(conversionQuote.getCreditedFunds());
        assertNotNull(conversionQuote.getConversionRateResponse());
        assertEquals("ACTIVE", conversionQuote.getStatus());
    }

    @Test
    public void createQuotedConversionTest() throws Exception {
        Conversion conversion = createQuotedConversion();
        assertNotNull(conversion);
        assertNotNull(conversion.getQuoteId());
    }

    @Test
    public void getQuotedConversionTest() throws Exception {
        Conversion createdConversion = createQuotedConversion();
        Conversion conversion = this.api.getConversionsApi().getConversion(createdConversion.getId());
        assertNotNull(conversion);
        assertNotNull(conversion.getQuoteId());
    }

    @Test
    public void createClientWalletsQuotedConversion() throws Exception {
        ConversionQuote quote = createConversionQuote();

        CreateClientWalletsQuotedConversion conversion = new CreateClientWalletsQuotedConversion();
        conversion.setQuoteId(quote.getId());
        conversion.setDebitedWalletType("FEES");
        conversion.setCreditedWalletType("CREDIT");

        Conversion created = this.api.getConversionsApi().createClientWalletsQuotedConversion(conversion, null);

        assertNotNull(created);
        assertNotNull(created.getQuoteId());
        assertEquals(TransactionStatus.SUCCEEDED, created.getStatus());
    }

    @Test
    public void createClientWalletsInstantConversion() throws Exception {
        Money creditedFunds = new Money();
        creditedFunds.setCurrency(CurrencyIso.GBP);

        Money debitedFunds = new Money();
        debitedFunds.setCurrency(CurrencyIso.EUR);
        debitedFunds.setAmount(79);

        CreateClientWalletsInstantConversion conversion = new CreateClientWalletsInstantConversion();
        conversion.setDebitedWalletType("FEES");
        conversion.setCreditedWalletType("FEES");
        conversion.setDebitedFunds(debitedFunds);
        conversion.setCreditedFunds(creditedFunds);

        Conversion created = this.api.getConversionsApi().createClientWalletsInstantConversion(conversion, null);

        assertNotNull(created);
        assertEquals(TransactionStatus.SUCCEEDED, created.getStatus());
    }
}
