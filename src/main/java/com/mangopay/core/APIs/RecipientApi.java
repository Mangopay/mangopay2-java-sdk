package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Recipient;
import com.mangopay.entities.subentities.PayoutMethods;
import com.mangopay.entities.subentities.RecipientSchema;

import java.util.List;

public interface RecipientApi {
    /**
     * Create a User recipient
     *
     * @param recipient the recipient
     * @param userId    the user identifier
     * @return Recipient instance
     */
    Recipient create(Recipient recipient, String userId) throws Exception;

    /**
     * Create a User recipient
     *
     * @param idempotencyKey idempotency key for this request.
     * @param recipient      the recipient
     * @param userId         the user identifier
     * @return Recipient instance
     */
    Recipient create(String idempotencyKey, Recipient recipient, String userId) throws Exception;

    /**
     * Get a Recipient
     *
     * @param recipientId recipient identifier
     * @return Recipient instance
     */
    Recipient get(String recipientId) throws Exception;

    /**
     * Get all recipients associated with a specific user
     *
     * @param userId the user identifier
     * @return UserRecipients instance
     */
    List<Recipient> getUserRecipients(String userId, Pagination pagination) throws Exception;

    /**
     * Get a Recipient schema
     *
     * @param payoutMethodType Defines the payout method (e.g., LocalBankTransfer, InternationalBankTransfer).
     * @param recipientType    Specifies whether the recipient is an Individual or a Business.
     * @param currency         3-letter ISO 4217 destination currency code (e.g. EUR, USD, GBP, AUD, CAD,HKD, SGD, MXN).
     * @return RecipientSchema instance
     */
    RecipientSchema getSchema(String payoutMethodType, String recipientType, CurrencyIso currency) throws Exception;

    /**
     * Validate recipient data
     *
     * @param recipient the recipient
     * @param userId    the user identifier
     */
    void validate(Recipient recipient, String userId) throws Exception;

    /**
     * Validate recipient data
     *
     * @param idempotencyKey idempotency key for this request.
     * @param recipient      the recipient
     * @param userId         the user identifier
     */
    void validate(String idempotencyKey, Recipient recipient, String userId) throws Exception;

    /**
     * Deactivate a Recipient
     *
     * @param recipientId the recipient identifier
     */
    Recipient deactivate(String recipientId) throws Exception;

    /**
     * See payout methods available to your platform by currency and country
     *
     * @param country  The destination country of the payout method.
     * @param currency The currency of the payout method.
     */
    PayoutMethods getPayoutMethods(CountryIso country, CurrencyIso currency) throws Exception;
}