package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.ApiRefunds;
import com.mangopay.entities.Refund;

/**
 * API for refunds.
 */
public class RefundApiImpl extends ApiBase implements ApiRefunds {

    /**
     * Instantiates new RefundApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public RefundApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Refund get(String refundId) throws Exception {
        return this.getObject(Refund.class, "refunds_get", refundId);
    }

}
