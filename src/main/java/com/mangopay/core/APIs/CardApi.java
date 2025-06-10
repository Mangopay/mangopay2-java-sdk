package com.mangopay.core.APIs;

import com.mangopay.core.FilterTransactions;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Card;
import com.mangopay.entities.CardPreAuthorization;
import com.mangopay.entities.CardValidation;
import com.mangopay.entities.Transaction;

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
     * Get first page of card's transactions
     * @param cardId Card identifier
     * @return Collection of transactions
     * @throws Exception
     */
    List<Transaction> getTransactions(String cardId) throws Exception;

    /**
     * Get page of card's transactions
     * @param cardId
     * @param pagination
     * @param sorting
     * @return
     * @throws Exception
     */
    List<Transaction> getTransactions(String cardId, Pagination pagination, Sorting sorting) throws Exception;
    
    /**
     * Get a list of card's preAuthorizations
     * @param cardId Card identifier
     * @return List of card preAuthorizations
     * @throws Exception
     */
    List<CardPreAuthorization> getCardPreAuthorizations(String cardId) throws Exception;

    /**
     * Validate a card
     * @param cardId, cardValidation to be created
     * @return CardValidation
     * @throws Exception
     */
    CardValidation validate(String cardId, CardValidation cardValidation) throws Exception;

    /**
     * Get card validation
     * @param cardId, cardValidationId
     * @return CardValidation
     * @throws Exception
     */
    CardValidation getCardValidation(String cardId, String cardValidationId) throws Exception;

    /**
     * This call returns all the transactions made with cards with the same Fingerprint value.
     *
     * @param fingerprint The unique representation of the card number. This string can be used to track the card behavior while keeping the card information confidential.
     * @param filter      Filter
     * @param pagination  Pagination
     * @param sorting     Sorting
     * @return List of Transactions
     */
    List<Transaction> getTransactionsByCardFingerprint(String fingerprint, FilterTransactions filter,
                                                       Pagination pagination, Sorting sorting) throws Exception;
}
