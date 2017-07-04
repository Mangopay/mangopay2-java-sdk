package com.mangopay.core.APIs;

import com.mangopay.entities.CardPreAuthorization;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface CardPreAuthorizationApi {

    /**
     * Creates new pre-authorization object.
     *
     * @param cardPreAuthorization PreAuthorization object to be created.
     * @return Card pre-authorization instance returned from API.
     * @throws Exception
     */
    CardPreAuthorization create(CardPreAuthorization cardPreAuthorization) throws Exception;

    /**
     * Creates new pre-authorization object.
     *
     * @param idempotencyKey       idempotency key for this request.
     * @param cardPreAuthorization PreAuthorization object to be created.
     * @return Card pre-authorization instance returned from API.
     * @throws Exception
     */
    CardPreAuthorization create(String idempotencyKey, CardPreAuthorization cardPreAuthorization) throws Exception;

    /**
     * Gets pre-authorization object.
     *
     * @param cardPreAuthorizationId PreAuthorization identifier.
     * @return Card pre-authorization instance returned from API.
     * @throws Exception
     */
    CardPreAuthorization get(String cardPreAuthorizationId) throws Exception;

    /**
     * Updates pre-authorization object.
     *
     * @param cardPreAuthorization PreAuthorization object to be updated.
     * @return Card pre-authorization instance returned from API.
     * @throws Exception
     */
    CardPreAuthorization update(CardPreAuthorization cardPreAuthorization) throws Exception;
}
