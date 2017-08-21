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
}
