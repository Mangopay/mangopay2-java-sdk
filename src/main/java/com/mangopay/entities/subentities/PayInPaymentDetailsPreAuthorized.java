package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the PreAuthorized type for execution option in PayIn entity.
 */
public class PayInPaymentDetailsPreAuthorized extends Dto implements PayInPaymentDetails {

    /**
     * Pre-authorization identifier.
     *
     * @deprecated Use {@link #getPreauthorizationId()} and {@link #setPreauthorizationId(String)} instead.
     */
    @Deprecated
    public String PreauthorizationId;

    public String getPreauthorizationId() {
        return PreauthorizationId;
    }

    public void setPreauthorizationId(String preauthorizationId) {
        this.PreauthorizationId = preauthorizationId;
    }
}
