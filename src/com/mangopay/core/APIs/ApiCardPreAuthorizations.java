package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.CardPreAuthorization;

/**
 * API for card pre-authorizations.
 */
public class ApiCardPreAuthorizations extends ApiBase {
    
    /**
     * Instantiates new ApiCardPreAuthorizations object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiCardPreAuthorizations(MangoPayApi root) { super(root); }
    
    /**
     * Creates new pre-authorization object.
     * @param cardPreAuthorization PreAuthorization object to be created.
     * @return Card pre-authorization instance returned from API.
     * @throws Exception
     */
    public CardPreAuthorization create(CardPreAuthorization cardPreAuthorization) throws Exception {
        return this.createObject(CardPreAuthorization.class, "preauthorization_create", cardPreAuthorization);
    }
    
    /**
     * Gets pre-authorization object.
     * @param cardPreAuthorizationId PreAuthorization identifier.
     * @return Card pre-authorization instance returned from API.
     * @throws Exception
     */
    public CardPreAuthorization get(String cardPreAuthorizationId) throws Exception {
        return this.getObject(CardPreAuthorization.class, "preauthorization_get", cardPreAuthorizationId);
    }
    /**
     * Updates pre-authorization object.
     * @param cardPreAuthorization PreAuthorization object to be updated.
     * @return Card pre-authorization instance returned from API.
     * @throws Exception
     */
    public CardPreAuthorization update(CardPreAuthorization cardPreAuthorization) throws Exception {
        return this.updateObject(CardPreAuthorization.class, "preauthorization_save", cardPreAuthorization);
    }
}
