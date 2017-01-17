package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.*;

/**
 * API for PayIns.
 */
public class ApiPayIns extends ApiBase {

    /**
     * Instantiates new ApiPayIns object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiPayIns(MangoPayApi root) { super(root); }
    
    /**
     * Creates new PayIn object.
     * @param payIn     The PayIn object to be created.
     * @return          Created PayIn object returned by API.
     * @throws Exception
     */
    public PayIn create(PayIn payIn) throws Exception {
        return this.create(null, payIn);
    }
    
    /**
     * Creates new PayIn object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param payIn             The PayIn object to be created.
     * @return                  Created PayIn object returned by API.
     * @throws Exception
     */
    public PayIn create(String idempotencyKey, PayIn payIn) throws Exception {
        String paymentKey = this.getPaymentKey(payIn);
        String executionKey = this.getExecutionKey(payIn);
        return this.createObject(PayIn.class, idempotencyKey, String.format("payins_%s-%s_create", paymentKey, executionKey), payIn);
    }
    
    /**
     * Gets PayIn entity by its identifier.
     * @param payInId   PayIn identifier.
     * @return          PayIn object returned by API.
     * @throws Exception
     */
    public PayIn get(String payInId) throws Exception {
        return this.getObject(PayIn.class, "payins_get", payInId);
    }
    
    /**
     * Creates refund for PayIn object.
     * @param payInId   PayIn identifier.
     * @param refund    Refund object to be created.
     * @return          Refund entity instance returned by REST API.
     * @throws Exception
     */
    public Refund createRefund(String payInId, Refund refund) throws Exception {
        return this.createRefund(null, payInId, refund);
    }
    
    /**
     * Creates refund for PayIn object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param payInId           PayIn identifier.
     * @param refund            Refund object to be created.
     * @return                  Refund entity instance returned by REST API.
     * @throws Exception
     */
    public Refund createRefund(String idempotencyKey, String payInId, Refund refund) throws Exception {
        return this.createObject(Refund.class, idempotencyKey, "payins_createrefunds", refund, payInId);
    }

    /**
     * Gets refund for PayIn object.
     * @param payInId PayIn identifier.
     * @return Refund entity instance returned by REST API.
     * @throws Exception
     */
    public Refund getRefund(String payInId) throws Exception {
        return this.getObject(Refund.class, "payins_getrefunds", payInId);
    }
    
    /**
     * WARNING! 
     * This is temporary entity and will be removed in future.
     * Contact support before using these features or if have any queries.
     * 
     * Creates new temporary immediate pay-in.
     * @param immediatePayIn    Immediate pay-in object to create.
     * @return                  Immediate pay-in object returned from API.
     * @throws Exception
     */
    public TemporaryImmediatePayIn createTemporaryImmediatePayIn(TemporaryImmediatePayIn immediatePayIn) throws Exception {
        return this.createTemporaryImmediatePayIn(null, immediatePayIn);
    }
    
    /**
     * WARNING! 
     * This is temporary entity and will be removed in future.
     * Contact support before using these features or if have any queries.
     * 
     * Creates new temporary immediate pay-in.
     * @param idempotencyKey    Idempotency key for this request.
     * @param immediatePayIn    Immediate pay-in object to create.
     * @return                  Immediate pay-in object returned from API.
     * @throws Exception
     */
    public TemporaryImmediatePayIn createTemporaryImmediatePayIn(String idempotencyKey, TemporaryImmediatePayIn immediatePayIn) throws Exception {
        return this.createObject(TemporaryImmediatePayIn.class, idempotencyKey, "temp_immediatepayins_create", immediatePayIn);
    }
    
    private String getPaymentKey(PayIn payIn) throws Exception {
        
        if (payIn.getPaymentDetails() == null)
            throw new Exception ("Payment is not defined or it is not object type");
        
        String className = payIn.getPaymentDetails().getClass().getSimpleName().replace("PayInPaymentDetails", "");
        return className.toLowerCase();
    }
    
    private String getExecutionKey(PayIn payIn) throws Exception {
        
        if (payIn.getExecutionDetails() == null)
            throw new Exception ("Execution is not defined or it is not object type");
        
        String className = payIn.getExecutionDetails().getClass().getSimpleName().replace("PayInExecutionDetails", "");
        return className.toLowerCase();
    }
    
}
