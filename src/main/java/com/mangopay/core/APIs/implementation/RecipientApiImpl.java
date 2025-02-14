package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.RecipientApi;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.Recipient;
import com.mangopay.entities.subentities.RecipientSchema;
import com.mangopay.entities.subentities.UserRecipients;

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
    public UserRecipients getUserRecipients(String userId) throws Exception {
        return this.getObject(UserRecipients.class, "recipient_get_all", userId);
    }

    @Override
    public RecipientSchema getSchema(String payoutMethodType, String recipientType, CurrencyIso currency) throws Exception {
        return this.getObject(RecipientSchema.class, "recipient_get_schema", payoutMethodType, recipientType, currency);
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
    public void deactivate(String recipientId) throws Exception {
        this.updateObject(Recipient.class, "recipient_deactivate", new Recipient(), recipientId);
    }
}
