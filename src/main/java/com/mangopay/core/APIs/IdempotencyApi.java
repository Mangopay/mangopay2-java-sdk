package com.mangopay.core.APIs;

import com.mangopay.entities.IdempotencyResponse;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface IdempotencyApi {
    /**
     * Gets idempotency response.
     *
     * @param idempotencyKey idempotency key.
     * @return idempotency response instance returned from API.
     * @throws Exception
     */
    IdempotencyResponse get(String idempotencyKey) throws Exception;
}
