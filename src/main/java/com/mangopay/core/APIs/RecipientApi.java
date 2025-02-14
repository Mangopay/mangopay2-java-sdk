package com.mangopay.core.APIs;

import com.mangopay.entities.Recipient;
import com.mangopay.entities.subentities.UserRecipients;

public interface RecipientApi {
    /**
     * Create a User recipient
     *
     * @param recipient the recipient
     * @param userId    the user identifier
     * @return Recipient instance
     */
    Recipient create(Recipient recipient, String userId) throws Exception;

    /**
     * Create a User recipient
     * @param idempotencyKey       idempotency key for this request.
     * @param recipient the recipient
     * @param userId the user identifier
     * @return Recipient instance
     */
    Recipient create(String idempotencyKey, Recipient recipient, String userId) throws Exception;

    /**
     * Get a Recipient
     * @param recipientId recipient identifier
     * @return Recipient instance
     */
    Recipient get(String recipientId) throws Exception;

    /**
     * Get all recipients associated with a specific user
     *
     * @param userId the user identifier
     * @return UserRecipients instance
     */
    UserRecipients getUserRecipients(String userId) throws Exception;
}
