package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class BusinessRecipientPropertySchema extends Dto {
    @SerializedName("BusinessName")
    private RecipientPropertySchema businessName;

    @SerializedName("Address")
    private RecipientAddressPropertySchema address;

    public RecipientPropertySchema getBusinessName() {
        return businessName;
    }

    public BusinessRecipientPropertySchema setBusinessName(RecipientPropertySchema businessName) {
        this.businessName = businessName;
        return this;
    }

    public RecipientAddressPropertySchema getAddress() {
        return address;
    }

    public BusinessRecipientPropertySchema setAddress(RecipientAddressPropertySchema address) {
        this.address = address;
        return this;
    }
}
