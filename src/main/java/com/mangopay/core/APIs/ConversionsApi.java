package com.mangopay.core.APIs;

import com.mangopay.entities.*;

public interface ConversionsApi {

    /**
     * This endpoint allows the platform to get a real
     * time indicative market rate of a specific currency pair.
     * The rate returned is given in real time.
     * @param debitedCurrency The sell currency – the currency of the wallet to be debited
     * @param creditedCurrency The buy currency – the currency of the wallet to be credited.
     * @return ConversionRate object returned from API
     */
     ConversionRate getConversionRate(String debitedCurrency, String creditedCurrency) throws Exception;

    /**
     * This endpoint allows the platform to move funds between two
     * wallets of different currencies instantaneously.
     * @return InstantConversion object returned from API
     */
     Conversion createInstantConversion(CreateInstantConversion createInstantConversion, String idempotencyKey) throws Exception;

    /**
     * This call triggers a conversion, at the rate guaranteed by its quote, of the debited funds to the credited wallet.
     *
     * @return QuotedConversion
     */
    Conversion createQuotedConversion(CreateQuotedConversion quotedConversion, String idempotencyKey) throws Exception;

    /**
     * This endpoint allows the platform to get
     * the details of a conversion which has been carried out.
     * @param id The unique identifier of the conversion.
     * @return InstantConversion object returned from API
     */
     Conversion getConversion(String id) throws Exception;

    /**
     * This call guarantees a conversion rate to let you Create a Quoted Conversion.
     *
     * @return Quote object returned from API
     */
    ConversionQuote createConversionQuote(CreateConversionQuote createConversionQuote, String idempotencyKey) throws Exception;

    /**
     * This endpoint allows the platform to get the details of a quote
     *
     * @param quoteId The unique identifier of the quote
     * @return Quote object returned from API
     */
    ConversionQuote getConversionQuote(String quoteId) throws Exception;

}
