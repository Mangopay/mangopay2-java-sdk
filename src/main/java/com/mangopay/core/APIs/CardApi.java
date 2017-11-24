package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.entities.Card;
import com.mangopay.entities.CardPreAuthorization;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface CardApi {

    /**
     * Gets card.
     *
     * @param cardId Card identifier.
     * @return Card instance returned from API.
     * @throws Exception
     */
    Card get(String cardId) throws Exception;

    /**
     * Gets a list of cards having the same fingerprint.
     * The fingerprint is a hash uniquely generated per 16-digit card number.
     *
     * @param fingerprint The fingerprint hash
     * @return List of Cards corresponding to provided fingerprint
     * @throws Exception
     */
    List<Card> getByFingerprint(String fingerprint) throws Exception;

    /**
     * Saves card.
     *
     * @param card Card entity instance to be updated.
     * @return Card object returned from API.
     * @throws Exception
     */
    Card update(Card card) throws Exception;

    /**
     * Disables card (sets { INVALID } as the value of Validity field).
     *
     * @param card Card entity instance to be updated.
     * @return Card object returned from API.
     * @throws Exception
     */
    Card disable(Card card) throws Exception;

    /**
     * Get a list of card's preAuthorizations
     * @param cardId Card identifier
     * @return List of card preAuthorizations
     * @throws Exception
     */
    List<CardPreAuthorization> getCardPreAuthorizations(String cardId) throws Exception;
}
