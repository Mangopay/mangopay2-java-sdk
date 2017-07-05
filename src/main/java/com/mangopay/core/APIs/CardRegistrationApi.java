package com.mangopay.core.APIs;

import com.mangopay.entities.CardRegistration;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface CardRegistrationApi {
    /**
     * Creates new card registration.
     * @param cardRegistration Card registration object to create.
     * @return Card registration instance returned from API.
     * @throws Exception
     */
    CardRegistration create(CardRegistration cardRegistration) throws Exception;

    /**
     * Creates new card registration.
     * @param idempotencyKey    idempotency key for this request.
     * @param cardRegistration Card registration object to create.
     * @return Card registration instance returned from API.
     * @throws Exception
     */
    CardRegistration create(String idempotencyKey, CardRegistration cardRegistration) throws Exception;

    /**
     * Gets card registration.
     * @param cardRegistrationId Card Registration identifier.
     * @return Card registration instance returned from API.
     * @throws Exception
     */
    CardRegistration get(String cardRegistrationId) throws Exception;

    /**
     * Updates card registration.
     * @param cardRegistration Card registration object to be updated.
     * @return Card registration instance returned from API.
     * @throws Exception
     */
    CardRegistration update(CardRegistration cardRegistration) throws Exception;
}
