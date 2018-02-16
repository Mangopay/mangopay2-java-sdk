package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Models shipping details
 */
public class ShippingAddress extends Dto {

    /**
     * Name of the shipping recipient
     */
    @SerializedName("RecipientName")
    private String recipientName;

    /**
     * The shipping address
     */
    @SerializedName("Address")
    private Address address;

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> subObjects = super.getSubObjects();

        subObjects.put("Address", Address.class);

        return subObjects;
    }
}
