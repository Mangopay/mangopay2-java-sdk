package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.ConversionsApi;
import com.mangopay.entities.ConversionQuote;
import com.mangopay.entities.ConversionRate;
import com.mangopay.entities.InstantConversion;
import com.mangopay.entities.QuotedConversion;

public class ConversionsApiImpl extends ApiBase implements ConversionsApi {

    /**
     * Creates new API instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ConversionsApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public ConversionRate getConversionRate(String debitedCurrency, String creditedCurrency) throws Exception {
        return this.getObject(ConversionRate.class, "get_conversion_rate", debitedCurrency, creditedCurrency);
    }

    @Override
    public InstantConversion createInstantConversion(InstantConversion conversion, String idempotencyKey) throws Exception {
        return this.createObject(InstantConversion.class, idempotencyKey, "create_instant_conversion", conversion);
    }

    @Override
    public InstantConversion getInstantConversion(String id) throws Exception {
        return this.getObject(InstantConversion.class, "get_instant_conversion", id);
    }

    @Override
    public ConversionQuote createConversionQuote(ConversionQuote conversionQuote, String idempotencyKey) throws Exception {
        return this.createObject(ConversionQuote.class, idempotencyKey, "create_conversion_quote", conversionQuote);
    }

    @Override
    public ConversionQuote getConversionQuote(String quoteId) throws Exception {
        return this.getObject(ConversionQuote.class, "get_conversion_quote", quoteId);
    }

    @Override
    public QuotedConversion createQuotedConversion(QuotedConversion quotedConversion, String idempotencyKey) throws Exception {
        return this.createObject(QuotedConversion.class, idempotencyKey, "create_quoted_conversion", quotedConversion);
    }
}
