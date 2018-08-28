package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.ShippingAddress;
import com.mangopay.core.interfaces.PayInPaymentDetails;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Class representing the PayPal type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsPayPal extends Dto implements PayInPaymentDetails {

    /**
     * Address used instead of the user's PayPal account address.
     */
    @SerializedName("ShippingAddress")
    private ShippingAddress shippingAddress;

    @SerializedName("PaypalBuyerAccountEmail")
    private String paypalBuyerAccountEmail;

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("ShippingAddress", ShippingAddress.class);

        return subObjects;
    }

    public String getPaypalBuyerAccountEmail() {
        return paypalBuyerAccountEmail;
    }

    public PayInPaymentDetailsPayPal setPaypalBuyerAccountEmail(String paypalBuyerAccountEmail) {
        this.paypalBuyerAccountEmail = paypalBuyerAccountEmail;
        return this;
    }
}
