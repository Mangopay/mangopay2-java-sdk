package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.*;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface PayInApi {
    /**
     * Creates new PayIn object.
     * @param payIn     The PayIn object to be created.
     * @return          Created PayIn object returned by API.
     * @throws Exception
     */
    PayIn create(PayIn payIn) throws Exception;

    /**
     * Creates new PayIn object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param payIn             The PayIn object to be created.
     * @return                  Created PayIn object returned by API.
     * @throws Exception
     */
    PayIn create(String idempotencyKey, PayIn payIn) throws Exception;

    /**
     * Gets PayIn entity by its identifier.
     * @param payInId   PayIn identifier.
     * @return          PayIn object returned by API.
     * @throws Exception
     */
    PayIn get(String payInId) throws Exception;

    /**
     *
     * @param idempotencyKey
     * @param createRecurringPayment
     * @return
     * @throws Exception
     */
    RecurringPayment createRecurringPayment(String idempotencyKey, CreateRecurringPayment createRecurringPayment) throws Exception;

    /**
     *
     * @param idempotencyKey
     * @param cit
     * @return
     * @throws Exception
     */
    RecurringPayIn createRecurringPayInCIT(String idempotencyKey, RecurringPayInCIT cit) throws Exception;

    /**
     *
     * @param idempotencyKey
     * @param cit
     * @return
     * @throws Exception
     */
    RecurringPayIn createRecurringPayInMIT(String idempotencyKey, RecurringPayInMIT cit) throws Exception;


    /**
     * Creates refund for PayIn object.
     * @param payInId   PayIn identifier.
     * @param refund    Refund object to be created.
     * @return          Refund entity instance returned by REST API.
     * @throws Exception
     */
    Refund createRefund(String payInId, Refund refund) throws Exception;

    /**
     * Creates refund for PayIn object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param payInId           PayIn identifier.
     * @param refund            Refund object to be created.
     * @return                  Refund entity instance returned by REST API.
     * @throws Exception
     */
    Refund createRefund(String idempotencyKey, String payInId, Refund refund) throws Exception;

    /**
     * Gets refund for PayIn object.
     * @param payInId PayIn identifier.
     * @return Refund entity instance returned by REST API.
     * @throws Exception
     */
    Refund getRefund(String payInId) throws Exception;

    /**
     * Get first page of payIn refunds
     * @param payInId PayIn identifier
     * @return Collection of payIn refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String payInId) throws Exception;

    /**
     * Get page of payIn refunds
     * @param payInId PayIn identifier
     * @param pagination Pagination object
     * @param sorting Sorting object
     * @return Collection of payIn refunds
     * @throws Exception
     */
    List<Refund> getRefunds(String payInId, Pagination pagination, Sorting sorting) throws Exception;
}
