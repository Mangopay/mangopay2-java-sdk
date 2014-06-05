package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Refund;

/**
 * API for refunds.
 */
public class ApiRefunds extends ApiBase {
    
    /**
     * Instantiates new ApiRefunds object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiRefunds(MangoPayApi root) { super(root); }
    
    /**
     * Gets refund entity.
     * @param refundId Refund identifier.
     * @return Refund entity instance returned from API.
     * @throws Exception
     */
    public Refund get(String refundId) throws Exception {
        return this.getObject(Refund.class, "refunds_get", refundId);
    }
    
}
