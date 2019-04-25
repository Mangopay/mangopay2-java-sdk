package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.CardPreAuthorizationApi;
import com.mangopay.entities.CardPreAuthorization;

/**
 * API for card pre-authorizations.
 */
public class CardPreAuthorizationApiImpl extends ApiBase implements CardPreAuthorizationApi {

    /**
     * Instantiates new CardPreAuthorizationApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    private GsonBuilder gsonBuilder;

    public CardPreAuthorizationApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);
        this.gsonBuilder = gsonBuilder;
    }

    @Override
    public CardPreAuthorization create(CardPreAuthorization cardPreAuthorization) throws Exception {
        return this.create(null, cardPreAuthorization);
    }

    @Override
    public CardPreAuthorization create(String idempotencyKey, CardPreAuthorization cardPreAuthorization) throws Exception {
        return this.createObject(CardPreAuthorization.class, idempotencyKey, "preauthorization_create", cardPreAuthorization);
    }

    @Override
    public CardPreAuthorization get(String cardPreAuthorizationId) throws Exception {
        return this.getObject(CardPreAuthorization.class, "preauthorization_get", cardPreAuthorizationId);
    }

    @Override
    public CardPreAuthorization update(CardPreAuthorization cardPreAuthorization) throws Exception {
        return this.updateObject(CardPreAuthorization.class, "preauthorization_save", cardPreAuthorization);
    }
}
