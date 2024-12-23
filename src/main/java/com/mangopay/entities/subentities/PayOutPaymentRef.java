package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;

public class PayOutPaymentRef {

    // Only valid PaymentRef reasonType is PAYIN_REFUND
    @SerializedName("ReasonType")
    private String reasonType;

    @SerializedName("ReferenceId")
    private String referenceId;

    public String getReasonType() {
        return reasonType;
    }

    public void setReasonType(String reasonType) {
        this.reasonType = reasonType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}