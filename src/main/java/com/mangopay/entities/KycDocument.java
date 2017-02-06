package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.KycDocumentType;
import com.mangopay.core.enumerations.KycStatus;

/**
 * KYC document entity.
 */
public class KycDocument extends EntityBase {

    /**
     * Type of KYC document.
     *
     * @deprecated Use {@link #getType()} and {@link #setType(KycDocumentType)} instead.
     */
    @Deprecated
    public KycDocumentType Type;

    /**
     * Status of KYC document.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(KycStatus)} instead.
     */
    @Deprecated
    public KycStatus Status;

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

    /**
     * User identifier.
     *
     * @deprecated Use {@link #getUserId()} and {@link #setUserId(String)} instead.
     */
    @Deprecated
    public String UserId;

    public KycDocumentType getType() {
        return Type;
    }

    public void setType(KycDocumentType type) {
        this.Type = type;
    }

    public KycStatus getStatus() {
        return Status;
    }

    public void setStatus(KycStatus status) {
        this.Status = status;
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

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }
}
