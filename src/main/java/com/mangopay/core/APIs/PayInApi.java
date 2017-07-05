package com.mangopay.core.APIs;

import com.mangopay.entities.PayIn;
import com.mangopay.entities.Refund;

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

}
