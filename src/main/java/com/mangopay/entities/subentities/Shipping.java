package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.Dto;

public class Shipping extends Dto {

    /**
     * Address.
     */
    @SerializedName("Address")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Shipping setAddress(Address address) {
        this.address = address;
        return this;
    }
}
