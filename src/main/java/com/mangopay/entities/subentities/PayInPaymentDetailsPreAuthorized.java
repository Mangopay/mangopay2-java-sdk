package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the PreAuthorized type for execution option in PayIn entity.
 */
public class PayInPaymentDetailsPreAuthorized extends Dto implements PayInPaymentDetails {

    /**
     * Pre-authorization identifier.
     */
    @SerializedName("PreauthorizationId")
    private String preauthorizationId;

    public String getPreauthorizationId() {
        return preauthorizationId;
    }

    public void setPreauthorizationId(String preauthorizationId) {
        this.preauthorizationId = preauthorizationId;
    }
}
