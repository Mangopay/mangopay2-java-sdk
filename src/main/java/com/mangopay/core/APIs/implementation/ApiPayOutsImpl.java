package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.declaration.ApiPayOuts;
import com.mangopay.entities.PayOut;

/**
 * API for PayOuts.
 */
public class ApiPayOutsImpl extends ApiBase implements ApiPayOuts {

    /**
     * Instantiates new ApiPayOutsImpl object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiPayOutsImpl(MangoPayApi root) { super(root); }
    
    @Override
    public PayOut create(PayOut payOut) throws Exception {
        return this.create(null, payOut);
    }
    
    @Override
    public PayOut create(String idempotencyKey, PayOut payOut) throws Exception {
        String paymentKey = this.getPaymentKey(payOut);
        return this.createObject(PayOut.class, idempotencyKey, String.format("payouts_%s_create", paymentKey), payOut);
    }
    
    @Override
    public PayOut get(String payOutId) throws Exception {
        return this.getObject(PayOut.class, "payouts_get", payOutId);
    }
    
    private String getPaymentKey(PayOut payOut) throws Exception {
        
        if (payOut.getMeanOfPaymentDetails() == null)
            throw new Exception("Mean of payment is not defined or it is not object type");
        
        String className = payOut.getMeanOfPaymentDetails().getClass().getSimpleName().replace("PayOutPaymentDetails", "");
        return className.toLowerCase();
        
    }
    
}
