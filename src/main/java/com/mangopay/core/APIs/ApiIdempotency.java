package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.IdempotencyResponse;

/**
 * API for Idempotency.
 */
public class ApiIdempotency extends ApiBase {
    /**
     * Instantiates new ApiIdempotency object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiIdempotency(MangoPayApi root) { super(root); }
    
    /**
     * Gets idempotency response.
     * @param idempotencyKey    Idempotency key.
     * @return                  Idempotency response instance returned from API.
     * @throws Exception
     */
    public IdempotencyResponse get(String idempotencyKey) throws Exception {
        return this.getObject(IdempotencyResponse.class, "idempotency_response_get", idempotencyKey);
    }
}
