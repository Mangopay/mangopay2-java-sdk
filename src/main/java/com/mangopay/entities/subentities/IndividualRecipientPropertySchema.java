package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class IndividualRecipientPropertySchema extends Dto {
    @SerializedName("FirstName")
    private RecipientPropertySchema firstName;

    @SerializedName("LastName")
    private RecipientPropertySchema lastName;

    @SerializedName("Address")
    private RecipientAddressPropertySchema address;

    public RecipientPropertySchema getFirstName() {
        return firstName;
    }

    public IndividualRecipientPropertySchema setFirstName(RecipientPropertySchema firstName) {
        this.firstName = firstName;
        return this;
    }

    public RecipientPropertySchema getLastName() {
        return lastName;
    }

    public IndividualRecipientPropertySchema setLastName(RecipientPropertySchema lastName) {
        this.lastName = lastName;
        return this;
    }

    public RecipientAddressPropertySchema getAddress() {
        return address;
    }

    public IndividualRecipientPropertySchema setAddress(RecipientAddressPropertySchema address) {
        this.address = address;
        return this;
    }
}
