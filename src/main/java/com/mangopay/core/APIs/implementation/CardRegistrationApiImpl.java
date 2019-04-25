package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.CardRegistrationApi;
import com.mangopay.entities.CardRegistration;

/**
 * API for card registrations.
 */
public class CardRegistrationApiImpl extends ApiBase implements CardRegistrationApi {

    /**
     * Instantiates new ApiCardRegistration object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public CardRegistrationApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);
    }

    @Override
    public CardRegistration create(CardRegistration cardRegistration) throws Exception {
        return this.create(null, cardRegistration);
    }

    @Override
    public CardRegistration create(String idempotencyKey, CardRegistration cardRegistration) throws Exception {
        return this.createObject(CardRegistration.class, idempotencyKey, "cardregistration_create", cardRegistration);
    }

    @Override
    public CardRegistration get(String cardRegistrationId) throws Exception {
        return this.getObject(CardRegistration.class, "cardregistration_get", cardRegistrationId);
    }

    @Override
    public CardRegistration update(CardRegistration cardRegistration) throws Exception {
        return this.updateObject(CardRegistration.class, "cardregistration_save", cardRegistration);
    }

}
