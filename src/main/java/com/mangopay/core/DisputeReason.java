package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.DisputeReasonType;

/**
 * Class represents dispute's reason.
 */
public class DisputeReason extends Dto {

    /**
     * Dispute's reason type.
     */
    @SerializedName("DisputeReasonType")
    private DisputeReasonType disputeReasonType;

    /**
     * Dispute's reason message.
     */
    @SerializedName("DisputeReasonMessage")
    private String disputeReasonMessage;

    public DisputeReasonType getDisputeReasonType() {
        return disputeReasonType;
    }

    public void setDisputeReasonType(DisputeReasonType disputeReasonType) {
        this.disputeReasonType = disputeReasonType;
    }

    public String getDisputeReasonMessage() {
        return disputeReasonMessage;
    }

    public void setDisputeReasonMessage(String disputeReasonMessage) {
        this.disputeReasonMessage = disputeReasonMessage;
    }
}
