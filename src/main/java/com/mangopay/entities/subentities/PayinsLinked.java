package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class PayinsLinked extends Dto {
    @SerializedName("PayinCaptureId")
    private String payinCaptureId;

    @SerializedName("PayinComplementId")
    private String PayinComplementId;

    public String getPayinCaptureId() {
        return payinCaptureId;
    }

    public PayinsLinked setPayinCaptureId(String payinCaptureId) {
        this.payinCaptureId = payinCaptureId;
        return this;
    }

    public String getPayinComplementId() {
        return PayinComplementId;
    }

    public PayinsLinked setPayinComplementId(String payinComplementId) {
        PayinComplementId = payinComplementId;
        return this;
    }
}
