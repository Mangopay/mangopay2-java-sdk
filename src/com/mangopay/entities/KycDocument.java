package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.*;

/**
 * KYC document entity.
 */
public class KycDocument extends EntityBase {

    /**
     * Type of KYC document.
     */
    public KycDocumentType Type;
    
    /**
     * Status of KYC document.
     */
    public KycStatus Status;
    
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
