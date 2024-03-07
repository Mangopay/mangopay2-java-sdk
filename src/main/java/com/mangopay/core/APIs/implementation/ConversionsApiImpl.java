package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.ConversionsApi;
import com.mangopay.entities.*;

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
    public Conversion createInstantConversion(CreateInstantConversion createInstantConversion, String idempotencyKey) throws Exception {
        return this.createObject(Conversion.class, idempotencyKey, "create_instant_conversion", createInstantConversion);
    }

    @Override
    public Conversion createQuotedConversion(CreateQuotedConversion quotedConversion, String idempotencyKey) throws Exception {
        return this.createObject(Conversion.class, idempotencyKey, "create_quoted_conversion", quotedConversion);
    }

    @Override
    public Conversion getConversion(String id) throws Exception {
        return this.getObject(Conversion.class, "get_conversion", id);
    }

    @Override
    public ConversionQuote createConversionQuote(CreateConversionQuote createConversionQuote, String idempotencyKey) throws Exception {
        return this.createObject(ConversionQuote.class, idempotencyKey, "create_conversion_quote", createConversionQuote);
    }

    @Override
    public ConversionQuote getConversionQuote(String quoteId) throws Exception {
        return this.getObject(ConversionQuote.class, "get_conversion_quote", quoteId);
    }
}
