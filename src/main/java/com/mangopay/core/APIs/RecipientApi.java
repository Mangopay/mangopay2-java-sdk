package com.mangopay.core.APIs;

import com.mangopay.entities.Recipient;

public interface RecipientApi {
    Recipient create(Recipient recipient, String userId) throws Exception;

    Recipient create(String idempotencyKey, Recipient recipient, String userId) throws Exception;
}
