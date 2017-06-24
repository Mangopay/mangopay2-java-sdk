package com.mangopay.core.APIs;

import com.mangopay.entities.Card;
import com.mangopay.entities.TemporaryPaymentCard;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface CardApi {
    /**
     * Gets card.
     * @param cardId Card identifier.
     * @return Card instance returned from API.
     * @throws Exception
     */
    Card get(String cardId) throws Exception;

    /**
     * Saves card.
     * @param card  Card entity instance to be updated.
     * @return      Card object returned from API.
     * @throws Exception
     */
    Card update(Card card) throws Exception;

    /**
     * Disables card (sets { INVALID } as the value of Validity field).
     * @param card  Card entity instance to be updated.
     * @return      Card object returned from API.
     * @throws Exception
     */
    Card disable(Card card) throws Exception;

    /**
     * WARNING!
     * This is temporary entity and will be removed in future.
     * Contact support before using these features or if have any queries.
     *
     * Creates new temporary payment card.
     * @param paymentCard   Payment card object to create.
     * @return              Payment card object returned from API.
     * @throws Exception
     */
    TemporaryPaymentCard createTemporaryPaymentCard(TemporaryPaymentCard paymentCard) throws Exception;

    /**
     * WARNING!
     * This is temporary entity and will be removed in future.
     * Contact support before using these features or if have any queries.
     *
     * Creates new temporary payment card.
     * @param idempotencyKey    idempotency key for this request.
     * @param paymentCard       Payment card object to create.
     * @return                  Payment card object returned from API.
     * @throws Exception
     */
    TemporaryPaymentCard createTemporaryPaymentCard(String idempotencyKey, TemporaryPaymentCard paymentCard) throws Exception;

    /**
     * WARNING!
     * This is temporary entity and will be removed in future.
     * Contact support before using these features or if have any queries.
     *
     * Gets temporary payment card.
     * @param paymentCardId Payment card identifier.
     * @return              Payment card object returned from API.
     * @throws Exception
     */
    TemporaryPaymentCard getTemporaryPaymentCard(String paymentCardId) throws Exception;
}
