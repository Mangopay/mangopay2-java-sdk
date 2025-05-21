package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Shipping;
import com.mangopay.core.enumerations.CultureCode;
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

    /**
     * The language to use for the payment page - needs to be the ISO code of the language
     */
    @SerializedName("Culture")
    private CultureCode culture;

    @SerializedName("Shipping")
    private Shipping shipping;

    public String getPreauthorizationId() {
        return preauthorizationId;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public PayInPaymentDetailsPreAuthorized setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public void setPreauthorizationId(String preauthorizationId) {
        this.preauthorizationId = preauthorizationId;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public PayInPaymentDetailsPreAuthorized setCulture(CultureCode culture) {
        this.culture = culture;
        return this;
    }
}