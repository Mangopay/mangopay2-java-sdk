package com.mangopay.core;

import com.mangopay.core.enumerations.RefundReasonType;

/**
 * Class represents refund's reason.
 */
public class RefundReason extends Dto {

    /**
     * Message.
     *
     * @deprecated Use {@link #getRefundReasonMessage()} and {@link #setRefundReasonMessage(String)} instead.
     */
    @Deprecated
    public String RefundReasonMessage;

    /**
     * Type of refund reason.
     *
     * @deprecated Use {@link #getRefundReasonType()} and {@link #setRefundReasonType(RefundReasonType)} instead.
     */
    @Deprecated
    public RefundReasonType RefundReasonType;

    public String getRefundReasonMessage() {
        return RefundReasonMessage;
    }

    public void setRefundReasonMessage(String refundReasonMessage) {
        this.RefundReasonMessage = refundReasonMessage;
    }

    public com.mangopay.core.enumerations.RefundReasonType getRefundReasonType() {
        return RefundReasonType;
    }

    public void setRefundReasonType(com.mangopay.core.enumerations.RefundReasonType refundReasonType) {
        this.RefundReasonType = refundReasonType;
    }
}
