package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * KYC document entity.
 */
public class KycDocument extends EntityBase {

    /**
     * Possible values: { IDENTITY_PROOF, REGISTRATION_PROOF }
     */
    public String Type;
    
    /**
     * Possible values: { CREATED, VALIDATION_ASKED, VALIDATED, REFUSED }
     */
    public String Status;
    
    public String RefusedReasonType;
    
    public String RefusedReasonMessage;
    
}
