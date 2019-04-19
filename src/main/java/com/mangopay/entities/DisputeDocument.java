package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.DisputeDocumentStatus;
import com.mangopay.core.enumerations.DisputeDocumentType;

/**
 * Dispute document entity.
 */
public class DisputeDocument extends EntityBase {

    /**
     * type of dispute document.
     */
    @SerializedName("type")
    private DisputeDocumentType type;

    /**
     * Status of dispute document.
     */
    @SerializedName("Status")
    private DisputeDocumentStatus status;

    /**
     * The Dispute that this document belongs to.
     */
    @SerializedName("DisputeId")
    private String disputeId;

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
     * Date when this document was processed (UNIX timestamp).
     */
    @SerializedName("ProcessedDate")
    private Long processedDate;

    public DisputeDocumentType getType() {
        return type;
    }

    public void setType(DisputeDocumentType type) {
        this.type = type;
    }

    public DisputeDocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DisputeDocumentStatus status) {
        this.status = status;
    }

    public String getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(String disputeId) {
        this.disputeId = disputeId;
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

    public Long getProcessedDate() {
        return processedDate;
    }
}
