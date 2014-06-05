/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Card;

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
        return this.updateObject(Card.class, "card_put", card);
    }
    
    /**
     * Disables card (sets { INVALID } as the value of Validity field).
     * @param card  Card entity instance to be updated.
     * @return      Card object returned from API.
     * @throws Exception
     */
    public Card disable(Card card) throws Exception {
        card.Validity = "INVALID";
        return update(card);
    }
}
