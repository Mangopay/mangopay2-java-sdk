package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.Dto;

public class BusinessRecipient extends Dto {
    /**
     * The name of the business
     */
    @SerializedName("BusinessName")
    private String businessName;

    /**
     * Contains the business address details
     */
    @SerializedName("Address")
    private Address address;

    public String getBusinessName() {
        return businessName;
    }

    public BusinessRecipient setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public BusinessRecipient setAddress(Address address) {
        this.address = address;
        return this;
    }
}
