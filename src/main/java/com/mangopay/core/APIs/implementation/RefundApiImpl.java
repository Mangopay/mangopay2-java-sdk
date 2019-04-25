package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.RefundApi;
import com.mangopay.entities.Refund;

/**
 * API for refunds.
 */
public class RefundApiImpl extends ApiBase implements RefundApi {

    /**
     * Instantiates new RefundApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public RefundApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);
    }

    @Override
    public Refund get(String refundId) throws Exception {
        return this.getObject(Refund.class, "refunds_get", refundId);
    }

}
