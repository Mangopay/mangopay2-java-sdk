package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.PayoutReasonType;

public class PayOutPaymentRef {

    @SerializedName("ReasonType")
    private PayoutReasonType reasonType;

    @SerializedName("ReferenceId")
    private String referenceId;

    public PayoutReasonType getReasonType() {
        return reasonType;
    }

    public void setReasonType(PayoutReasonType reasonType) {
        this.reasonType = reasonType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}