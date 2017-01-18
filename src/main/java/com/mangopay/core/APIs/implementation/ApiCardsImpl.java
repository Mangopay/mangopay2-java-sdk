package com.mangopay.core.APIs.implementation;

import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.declaration.ApiCards;
import com.mangopay.core.enumerations.Validity;
import com.mangopay.MangoPayApi;
import com.mangopay.entities.*;

/**
 * API for cards.
 */
public class ApiCardsImpl extends ApiBase implements ApiCards {
    
    /**
     * Instantiates new ApiCardsImpl object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiCardsImpl(MangoPayApi root) { super(root); }
    
    @Override
    public Card get(String cardId) throws Exception {
        return this.getObject(Card.class, "card_get", cardId);
    }
    
    @Override
    public Card update(Card card) throws Exception {
        return this.updateObject(Card.class, "card_save", card);
    }
    
    @Override
    public Card disable(Card card) throws Exception {
        card.setValidity(Validity.INVALID);
        return update(card);
    }
    
    @Override
    public TemporaryPaymentCard createTemporaryPaymentCard(TemporaryPaymentCard paymentCard) throws Exception {
        return createTemporaryPaymentCard(null, paymentCard);
    }
    
    @Override
    public TemporaryPaymentCard createTemporaryPaymentCard(String idempotencyKey, TemporaryPaymentCard paymentCard) throws Exception {
        return this.createObject(TemporaryPaymentCard.class, idempotencyKey, "temp_paymentcards_create", paymentCard);
    }
    
    @Override
    public TemporaryPaymentCard getTemporaryPaymentCard(String paymentCardId) throws Exception {
        return this.getObject(TemporaryPaymentCard.class, "temp_paymentcards_get", paymentCardId);
    }
}
