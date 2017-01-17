package com.mangopay.core;

import com.mangopay.core.enumerations.DisputeReasonType;

/**
 * Class represents dispute's reason.
 */
public class DisputeReason extends Dto {

    /**
     * Dispute's reason type.
     *
     * @deprecated Use {@link #getDisputeReasonType()} and {@link #setDisputeReasonType(DisputeReasonType)} instead.
     */
    @Deprecated
    public DisputeReasonType DisputeReasonType;

    /**
     * Dispute's reason message.
     *
     * @deprecated Use {@link #getDisputeReasonMessage()} and {@link #setDisputeReasonMessage(String)} instead.
     */
    @Deprecated
    public String DisputeReasonMessage;

    public com.mangopay.core.enumerations.DisputeReasonType getDisputeReasonType() {
        return DisputeReasonType;
    }

    public void setDisputeReasonType(com.mangopay.core.enumerations.DisputeReasonType disputeReasonType) {
        this.DisputeReasonType = disputeReasonType;
    }

    public String getDisputeReasonMessage() {
        return DisputeReasonMessage;
    }

    public void setDisputeReasonMessage(String disputeReasonMessage) {
        this.DisputeReasonMessage = disputeReasonMessage;
    }
}
