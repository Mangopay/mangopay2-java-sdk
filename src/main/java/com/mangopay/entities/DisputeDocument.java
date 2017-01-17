package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.DisputeDocumentStatus;
import com.mangopay.core.enumerations.DisputeDocumentType;

/**
 * Dispute document entity.
 */
public class DisputeDocument extends EntityBase {

    /**
     * Type of dispute document.
     *
     * @deprecated Use {@link #getType()} and {@link #setType(DisputeDocumentType)} instead.
     */
    @Deprecated
    public DisputeDocumentType Type;

    /**
     * Status of dispute document.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(DisputeDocumentStatus)} instead.
     */
    @Deprecated
    public DisputeDocumentStatus Status;

    /**
     * The Dispute that this document belongs to.
     *
     * @deprecated Use {@link #getDisputeId()} and {@link #setDisputeId(String)} instead.
     */
    @Deprecated
    public String DisputeId;

    /**
     * Refused reason type.
     *
     * @deprecated Use {@link #getRefusedReasonType()} and {@link #setRefusedReasonType(String)} instead.
     */
    @Deprecated
    public String RefusedReasonType;

    /**
     * Refused reason message.
     *
     * @deprecated Use {@link #getRefusedReasonMessage()} and {@link #setRefusedReasonMessage(String)} instead.
     */
    @Deprecated
    public String RefusedReasonMessage;

    public DisputeDocumentType getType() {
        return Type;
    }

    public void setType(DisputeDocumentType type) {
        this.Type = type;
    }

    public DisputeDocumentStatus getStatus() {
        return Status;
    }

    public void setStatus(DisputeDocumentStatus status) {
        this.Status = status;
    }

    public String getDisputeId() {
        return DisputeId;
    }

    public void setDisputeId(String disputeId) {
        this.DisputeId = disputeId;
    }

    public String getRefusedReasonType() {
        return RefusedReasonType;
    }

    public void setRefusedReasonType(String refusedReasonType) {
        this.RefusedReasonType = refusedReasonType;
    }

    public String getRefusedReasonMessage() {
        return RefusedReasonMessage;
    }

    public void setRefusedReasonMessage(String refusedReasonMessage) {
        this.RefusedReasonMessage = refusedReasonMessage;
    }
}
