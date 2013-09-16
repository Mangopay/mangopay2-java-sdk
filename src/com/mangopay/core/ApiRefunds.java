package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Refund;

/**
 * API for Refunds.
 */
public class ApiRefunds extends ApiBase {
    
    /**
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiRefunds(MangoPayApi root) { super(root); }
    
    /**
     * Gets refund entity.
     * @param refundId Refund identifier.
     * @return Refund entity instance returned from API.
     */
    public Refund get(String refundId) throws Exception {
        return this.getObject(Refund.class, "refunds_get", refundId);
    }
    
}
