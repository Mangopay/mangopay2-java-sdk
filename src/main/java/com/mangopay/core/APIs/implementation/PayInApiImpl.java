package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.PayInApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.Refund;

import java.util.List;

/**
 * API for payIns.
 */
public class PayInApiImpl extends ApiBase implements PayInApi {

    /**
     * Instantiates new PayInApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public PayInApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public PayIn create(PayIn payIn) throws Exception {
        return this.create(null, payIn);
    }

    @Override
    public PayIn create(String idempotencyKey, PayIn payIn) throws Exception {
        String paymentKey = this.getPaymentKey(payIn);
        String executionKey = this.getExecutionKey(payIn);
        return this.createObject(PayIn.class, idempotencyKey, String.format("payins_%s-%s_create", paymentKey, executionKey), payIn);
    }

    @Override
    public PayIn get(String payInId) throws Exception {
        return this.getObject(PayIn.class, "payins_get", payInId);
    }

    @Override
    public Refund createRefund(String payInId, Refund refund) throws Exception {
        return this.createRefund(null, payInId, refund);
    }

    @Override
    public Refund createRefund(String idempotencyKey, String payInId, Refund refund) throws Exception {
        return this.createObject(Refund.class, idempotencyKey, "payins_createrefunds", refund, payInId);
    }

    @Override
    public Refund getRefund(String payInId) throws Exception {
        return this.getObject(Refund.class, "payins_getrefunds", payInId);
    }

    @Override
    public List<Refund> getRefunds(String payInId) throws Exception {
        return this.getRefunds(payInId, null, null);
    }

    @Override
    public List<Refund> getRefunds(String payInId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Refund[].class, Refund.class, "payin_get_refunds", pagination, payInId, sorting);
    }

    private String getPaymentKey(PayIn payIn) throws Exception {

        if (payIn.getPaymentDetails() == null)
            throw new Exception("Payment is not defined or it is not object type");

        String className = payIn.getPaymentDetails().getClass().getSimpleName().replace("PayInPaymentDetails", "");
        return className.toLowerCase();
    }

    private String getExecutionKey(PayIn payIn) throws Exception {

        if (payIn.getExecutionDetails() == null)
            throw new Exception("Execution is not defined or it is not object type");

        String className = payIn.getExecutionDetails().getClass().getSimpleName().replace("PayInExecutionDetails", "");
        return className.toLowerCase();
    }

}
