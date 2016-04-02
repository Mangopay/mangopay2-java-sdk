package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.*;

/**
 * Dispute document entity.
 */
public class DisputeDocument extends EntityBase {
    
    /**
     * Type of dispute document.
     */
    public DisputeDocumentType Type;

    /**
     * Status of dispute document.
     */
    public DisputeDocumentStatus Status;

    /**
     * The Dispute that this document belongs to.
     */
    public String DisputeId;

    /**
     * Refused reason type.
     */
    public String RefusedReasonType;

    /**
     * Refused reason message.
     */
    public String RefusedReasonMessage;
    
}
