package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.RecipientApi;
import com.mangopay.entities.Recipient;

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
}
