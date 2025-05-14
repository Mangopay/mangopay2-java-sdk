package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.RecipientApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Recipient;
import com.mangopay.entities.subentities.PayoutMethods;
import com.mangopay.entities.subentities.RecipientSchema;

import java.util.List;

public class RecipientApiImpl extends ApiBase implements RecipientApi {
    /**
     * Creates new RecipientApi instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public RecipientApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Recipient create(Recipient recipient, String userId) throws Exception {
        return this.create(null, recipient, userId);
    }

    @Override
    public Recipient create(String idempotencyKey, Recipient recipient, String userId) throws Exception {
        return this.createObject(Recipient.class, idempotencyKey, "recipient_create", recipient, userId);
    }

    @Override
    public Recipient get(String recipientId) throws Exception {
        return this.getObject(Recipient.class, "recipient_get", recipientId);
    }

    @Override
    public List<Recipient> getUserRecipients(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Recipient[].class, Recipient.class, "recipient_get_all", pagination, userId, sorting);
    }

    @Override
    public List<Recipient> getUserRecipients(String userId) throws Exception {
        return getUserRecipients(userId, null, null);
    }

    @Override
    public RecipientSchema getSchema(String payoutMethodType, String recipientType, CurrencyIso currency, CountryIso country) throws Exception {
        return this.getObject(RecipientSchema.class, "recipient_get_schema", payoutMethodType, recipientType, currency, country);
    }

    @Override
    public void validate(Recipient recipient, String userId) throws Exception {
        validate(null, recipient, userId);
    }

    @Override
    public void validate(String idempotencyKey, Recipient recipient, String userId) throws Exception {
        this.createObject(Recipient.class, idempotencyKey, "recipient_validate", recipient, userId);
    }

    @Override
    public Recipient deactivate(String recipientId) throws Exception {
        Recipient recipient = new Recipient();
        recipient.setStatus("DEACTIVATED");
        recipient.setId(recipientId);
        return this.updateObject(Recipient.class, "recipient_deactivate", recipient);
    }

    @Override
    public PayoutMethods getPayoutMethods(CountryIso country, CurrencyIso currency) throws Exception {
        return this.getObject(PayoutMethods.class, "recipient_get_payout_methods", country, currency);
    }
}
