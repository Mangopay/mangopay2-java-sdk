package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * KYC document entity.
 */
public class KycDocument extends EntityBase {

    /**
     * Possible values: { IDENTITY_PROOF, REGISTRATION_PROOF, 
     * ARTICLES_OF_ASSOCIATION, SHAREHOLDER_DECLARATION, ADDRESS_PROOF }.
     */
    public String Type;
    
    /**
     * Possible values: { CREATED, VALIDATION_ASKED, VALIDATED, REFUSED }.
     */
    public String Status;
    
    /**
     * Refused reason type.
     */
    public String RefusedReasonType;
    
    /**
     * Refused reason message.
     */
    public String RefusedReasonMessage;
    
    /**
     * User identifier.
     */
    public String UserId;
    
}
