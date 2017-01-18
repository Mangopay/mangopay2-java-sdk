package com.mangopay.core.APIs.declaration;

import com.mangopay.entities.PayOut;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiPayOuts {
    /**
     * Creates new PayOut object.
     * @param payOut    The PayOut object to be created.
     * @return          Created PayOut object returned by API.
     * @throws Exception
     */
    PayOut create(PayOut payOut) throws Exception;

    /**
     * Creates new PayOut object.
     * @param idempotencyKey    Idempotency key for this request.
     * @param payOut            The PayOut object to be created.
     * @return                  Created PayOut object returned by API.
     * @throws Exception
     */
    PayOut create(String idempotencyKey, PayOut payOut) throws Exception;

    /**
     * Gets PayOut entity by its identifier.
     * @param payOutId  PayOut identifier.
     * @return          PayOut instance returned by API.
     * @throws Exception
     */
    PayOut get(String payOutId) throws Exception;

}
