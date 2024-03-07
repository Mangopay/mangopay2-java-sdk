package com.mangopay.core;

import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.Conversion;
import com.mangopay.entities.ConversionQuote;
import com.mangopay.entities.ConversionRate;
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
    public void getQuotedConversionTest() throws Exception{
        Conversion createdConversion =  createQuotedConversion();
        Conversion conversion = this.api.getConversionsApi().getConversion(createdConversion.getId());
        assertNotNull(conversion);
        assertNotNull(conversion.getQuoteId());
    }
}
