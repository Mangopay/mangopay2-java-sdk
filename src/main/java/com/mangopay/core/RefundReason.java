package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.RefundReasonType;

/**
 * Class represents refund's reason.
 */
public class RefundReason extends Dto {

    /**
     * Message.
     */
    @SerializedName("RefundReasonMessage")
    private String refundReasonMessage;

    /**
     * type of refund reason.
     */
    @SerializedName("RefundReasonType")
    private RefundReasonType refundReasonType;

    public String getRefundReasonMessage() {
        return refundReasonMessage;
    }

    public void setRefundReasonMessage(String refundReasonMessage) {
        this.refundReasonMessage = refundReasonMessage;
    }

    public RefundReasonType getRefundReasonType() {
        return refundReasonType;
    }

    public void setRefundReasonType(RefundReasonType refundReasonType) {
        this.refundReasonType = refundReasonType;
    }
}
