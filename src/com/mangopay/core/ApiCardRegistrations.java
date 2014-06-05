package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.CardRegistration;

/**
 * API for card registrations.
 */
public class ApiCardRegistrations extends ApiBase {
    
    /**
     * Instantiates new ApiCardRegistration object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiCardRegistrations(MangoPayApi root) { super(root); }
    
    /**
     * Creates new card registration.
     * @param cardRegistration Card registration object to create.
     * @return Card registration instance returned from API.
     * @throws Exception
     */
    public CardRegistration create(CardRegistration cardRegistration) throws Exception {
        return this.createObject(CardRegistration.class, "cardregistration_create", cardRegistration);
    }
    
    /**
     * Gets card registration.
     * @param cardRegistrationId Card Registration identifier.
     * @return Card registration instance returned from API.
     * @throws Exception
     */
    public CardRegistration get(String cardRegistrationId) throws Exception {
        return this.getObject(CardRegistration.class, "cardregistration_get", cardRegistrationId);
    }
    
    /**
     * Updates card registration.
     * @param cardRegistration Card registration object to be updated.
     * @return Card registration instance returned from API.
     * @throws Exception
     */
    public CardRegistration update(CardRegistration cardRegistration) throws Exception {
        return this.updateObject(CardRegistration.class, "cardregistration_save", cardRegistration);
    }
    
}
