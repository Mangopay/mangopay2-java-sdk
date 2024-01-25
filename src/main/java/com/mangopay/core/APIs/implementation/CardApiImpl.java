package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.CardApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.Validity;
import com.mangopay.entities.Card;
import com.mangopay.entities.CardPreAuthorization;
import com.mangopay.entities.CardValidation;
import com.mangopay.entities.Transaction;

import java.util.List;

/**
 * API for cards.
 */
public class CardApiImpl extends ApiBase implements CardApi {

    /**
     * Instantiates new CardApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public CardApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Card get(String cardId) throws Exception {
        return this.getObject(Card.class, "card_get", cardId);
    }

    @Override
    public List<Card> getByFingerprint(String fingerprint) throws Exception {
        return this.getList(Card[].class, Card.class, "cards_get_by_fingerprint", null, fingerprint);
    }

    @Override
    public Card update(Card card) throws Exception {
        return this.updateObject(Card.class, "card_save", card);
    }

    @Override
    public Card disable(Card card) throws Exception {
        card.setValidity(Validity.INVALID);
        card.setActive(false);
        return update(card);
    }

    @Override
    public List<Transaction> getTransactions(String cardId) throws Exception {
        return this.getTransactions(cardId, null, null);
    }

    @Override
    public List<Transaction> getTransactions(String cardId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Transaction[].class, Transaction.class, "cards_get_transactions", pagination, cardId, sorting);
    }

    @Override
    public List<CardPreAuthorization> getCardPreAuthorizations(String cardId) throws Exception {
        return this.getList(CardPreAuthorization[].class, CardPreAuthorization.class, "card_get_preauthorization", null, cardId);
    }

    @Override
    public CardValidation validate(String cardId, CardValidation cardValidation) throws Exception {
        return this.createObject(CardValidation.class, null, "card_validate", cardValidation, cardId);
    }

    public CardValidation get_card_validation(String cardId, String cardValidationId) throws Exception {
        return this.getObject(CardValidation.class, "get_card_validation", cardId, cardValidationId);
    }


}
