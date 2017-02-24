package com.mangopay.core.APIs;

import com.mangopay.entities.Card;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiCards {
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
}
