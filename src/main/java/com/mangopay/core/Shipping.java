package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.Dto;

import java.lang.reflect.Type;
import java.util.Map;

public class Shipping extends Dto {

    /**
     * First Name
     */
    @SerializedName("FirstName")
    private String firstName;

    /**
     * Last Name
     */
    @SerializedName("LastName")
    private String lastName;

    /**
     * Address.
     */
    @SerializedName("Address")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("Address", Address.class);

        return result;
    }
}
