package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.ConversionQuote;
import com.mangopay.entities.ConversionRate;
import com.mangopay.entities.InstantConversion;
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
        InstantConversion instantConversion = createInstantConversion();

        assertNotNull(instantConversion);
        assertNotNull(instantConversion.creditedFunds.getAmount());
        assertNotNull(instantConversion.debitedFunds.getAmount());
        assertEquals(instantConversion.status, TransactionStatus.SUCCEEDED);
        assertEquals(instantConversion.type, TransactionType.CONVERSION);
    }

    @Test
    public void getInstantConversionTest() throws Exception {
        InstantConversion instantConversion = getInstantConversion();

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

    private ConversionQuote createConversionQuote() throws Exception {
        ConversionQuote conversionQuote = new ConversionQuote();

        Money creditedFunds = new Money();
        creditedFunds.setCurrency(CurrencyIso.USD);
        conversionQuote.setCreditedFunds(creditedFunds);

        Money debitedFunds = new Money();
        debitedFunds.setCurrency(CurrencyIso.GBP);
        debitedFunds.setAmount(100);
        conversionQuote.setDebitedFunds(debitedFunds);

        conversionQuote.setDuration(90);
        conversionQuote.setTag("Created using the Mangopay PHP SDK");

        return this.api.getConversionsApi().createConversionQuote(conversionQuote, null);
    }
}
