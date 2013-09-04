package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.PayIn;

/**
 * API for PayIns.
 */
public class ApiPayIns extends ApiBase {

    /**
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiPayIns(MangoPayApi root) { super(root); }
    
    /**
     * Creates new PayIn object.
     * @param payIn     The PayIn object to be created.
     * @return          Created PayIn object returned by API.
     * @throws Exception
     */
    public PayIn create(PayIn payIn) throws Exception {
        String paymentKey = this.getPaymentKey(payIn);
        String executionKey = this.getExecutionKey(payIn);
        return this.createObject(PayIn.class, String.format("payins_%s-%s_create", paymentKey, executionKey), payIn);
    }
    
    /**
     * Gets PayIn entity by its identifier.
     * @param payInId   PayIn identifier.
     * @return          PayIn object returned by API
     * @throws Exception
     */
    public PayIn get(String payInId) throws Exception {
        return this.getObject(PayIn.class, "payins_get", payInId);
    }
    
    private String getPaymentKey(PayIn payIn) throws Exception {
        
        if (payIn.PaymentDetails == null)
            throw new Exception ("Payment is not defined or it is not object type");
        
        String className = payIn.PaymentDetails.getClass().getName().replaceAll("com.mangopay.core.PayInPaymentDetails", "");
        return className.toLowerCase();
    }
    
    private String getExecutionKey(PayIn payIn) throws Exception {
        
        if (payIn.ExecutionDetails == null)
            throw new Exception ("Execution is not defined or it is not object type");
        
        String className = payIn.ExecutionDetails.getClass().getName().replaceAll("com.mangopay.core.PayInExecutionDetails", "");
        return className.toLowerCase();
    }
    
}
