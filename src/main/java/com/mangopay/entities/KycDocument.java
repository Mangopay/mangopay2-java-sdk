package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.KycDocumentType;
import com.mangopay.core.enumerations.KycStatus;

/**
 * KYC document entity.
 */
public class KycDocument extends EntityBase {

    /**
     * Type of KYC document.
     */
    @SerializedName("Type")
    private KycDocumentType type;

    /**
     * Status of KYC document.
     */
    @SerializedName("Status")
    private KycStatus status;

    /**
     * Refused reason type.
     */
    @SerializedName("RefusedReasonType")
    private String refusedReasonType;

    /**
     * Refused reason message.
     */
    @SerializedName("RefusedReasonMessage")
    private String refusedReasonMessage;

    /**
     * User identifier.
     */
    @SerializedName("UserId")
    private String userId;

    public KycDocumentType getType() {
        return type;
    }

    public void setType(KycDocumentType type) {
        this.type = type;
    }

    public KycStatus getStatus() {
        return status;
    }

    public void setStatus(KycStatus status) {
        this.status = status;
    }

    public String getRefusedReasonType() {
        return refusedReasonType;
    }

    public void setRefusedReasonType(String refusedReasonType) {
        this.refusedReasonType = refusedReasonType;
    }

    public String getRefusedReasonMessage() {
        return refusedReasonMessage;
    }

    public void setRefusedReasonMessage(String refusedReasonMessage) {
        this.refusedReasonMessage = refusedReasonMessage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
