package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.PayOutApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.Refund;

import java.util.List;

/**
 * API for payOuts.
 */
public class PayOutApiImpl extends ApiBase implements PayOutApi {

    /**
     * Instantiates new PayOutApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public PayOutApiImpl(MangoPayApi root) {
        super(root);
    }

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

    @Override
    public List<Refund> getRefunds(String payOutId) throws Exception {
        return this.getRefunds(payOutId, null, null);
    }

    @Override
    public List<Refund> getRefunds(String payOutId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Refund[].class, Refund.class, "payouts_get_refunds", pagination, payOutId, sorting);
    }

    private String getPaymentKey(PayOut payOut) throws Exception {

        if (payOut.getMeanOfPaymentDetails() == null)
            throw new Exception("Mean of payment is not defined or it is not object type");

        String className = payOut.getMeanOfPaymentDetails().getClass().getSimpleName().replace("PayOutPaymentDetails", "");
        return className.toLowerCase();

    }

}
