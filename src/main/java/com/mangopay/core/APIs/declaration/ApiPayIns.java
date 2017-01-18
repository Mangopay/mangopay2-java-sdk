package com.mangopay.core.APIs.declaration;

import com.mangopay.entities.PayIn;
import com.mangopay.entities.Refund;
import com.mangopay.entities.TemporaryImmediatePayIn;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiPayIns {
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
    TemporaryImmediatePayIn createTemporaryImmediatePayIn(TemporaryImmediatePayIn immediatePayIn) throws Exception;

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
    TemporaryImmediatePayIn createTemporaryImmediatePayIn(String idempotencyKey, TemporaryImmediatePayIn immediatePayIn) throws Exception;

}
