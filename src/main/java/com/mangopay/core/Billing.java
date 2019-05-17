package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.Map;

public class Billing extends Dto {

    @SerializedName("Address")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("Address", Address.class);

        return result;
    }
}
