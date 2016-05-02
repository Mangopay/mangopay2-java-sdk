package com.mangopay.core.APIs;

import com.mangopay.core.enumerations.Validity;
import com.mangopay.MangoPayApi;
import com.mangopay.entities.*;

/**
 * API for cards.
 */
public class ApiCards extends ApiBase {
    
    /**
     * Instantiates new ApiCards object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiCards(MangoPayApi root) { super(root); }
    
    /**
     * Gets card.
     * @param cardId Card identifier.
     * @return Card instance returned from API.
     * @throws Exception
     */
    public Card get(String cardId) throws Exception {
        return this.getObject(Card.class, "card_get", cardId);
    }
    
    /**
     * Saves card.
     * @param card  Card entity instance to be updated.
     * @return      Card object returned from API.
     * @throws Exception
     */
    public Card update(Card card) throws Exception {
        return this.updateObject(Card.class, "card_save", card);
    }
    
    /**
     * Disables card (sets { INVALID } as the value of Validity field).
     * @param card  Card entity instance to be updated.
     * @return      Card object returned from API.
     * @throws Exception
     */
    public Card disable(Card card) throws Exception {
        card.Validity = Validity.INVALID;
        return update(card);
    }
    
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
    public TemporaryPaymentCard createTemporaryPaymentCard(TemporaryPaymentCard paymentCard) throws Exception {
        return createTemporaryPaymentCard(null, paymentCard);
    }
    
    /**
     * WARNING! 
     * This is temporary entity and will be removed in future.
     * Contact support before using these features or if have any queries.
     * 
     * Creates new temporary payment card.
     * @param idempotencyKey    Idempotency key for this request.
     * @param paymentCard       Payment card object to create.
     * @return                  Payment card object returned from API.
     * @throws Exception
     */
    public TemporaryPaymentCard createTemporaryPaymentCard(String idempotencyKey, TemporaryPaymentCard paymentCard) throws Exception {
        return this.createObject(TemporaryPaymentCard.class, idempotencyKey, "temp_paymentcards_create", paymentCard);
    }
    
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
    public TemporaryPaymentCard getTemporaryPaymentCard(String paymentCardId) throws Exception {
        return this.getObject(TemporaryPaymentCard.class, "temp_paymentcards_get", paymentCardId);
    }
}
