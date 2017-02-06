package com.mangopay.core.APIs;

import com.mangopay.entities.IdempotencyResponse;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiIdempotency {
    /**
     * Gets idempotency response.
     *
     * @param idempotencyKey Idempotency key.
     * @return Idempotency response instance returned from API.
     * @throws Exception
     */
    IdempotencyResponse get(String idempotencyKey) throws Exception;
}
