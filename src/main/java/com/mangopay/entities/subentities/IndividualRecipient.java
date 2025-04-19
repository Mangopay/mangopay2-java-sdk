package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.Dto;

public class IndividualRecipient extends Dto {
    /**
     * The first name of the individual recipient.
     */
    @SerializedName("FirstName")
    private String firstName;

    /**
     * The last name of the individual recipient.
     */
    @SerializedName("LastName")
    private String lastName;

    /**
     * The address of the individual recipient.
     */
    @SerializedName("Address")
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public IndividualRecipient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public IndividualRecipient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public IndividualRecipient setAddress(Address address) {
        this.address = address;
        return this;
    }
}
