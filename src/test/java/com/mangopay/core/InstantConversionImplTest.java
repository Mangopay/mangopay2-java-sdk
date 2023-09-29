package com.mangopay.core;

import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.ConversionRate;
import com.mangopay.entities.InstantConversion;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstantConversionImplTest extends BaseTest {

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
}
