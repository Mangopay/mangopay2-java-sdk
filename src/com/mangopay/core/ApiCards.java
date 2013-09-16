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
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiCards(MangoPayApi root) { super(root); }
    
    /**
     * Gets card.
     * @param cardId Card identifier.
     * @return Card object returned from API.
     */
    public Card get(String cardId) throws Exception {
        return this.getObject(Card.class, "card_get", cardId);
    }
    
}
