package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.List;

public class PayoutMethods extends Dto {
    @SerializedName("AvailablePayoutMethods")
    private List<String> availablePayoutMethods;

    public List<String> getAvailablePayoutMethods() {
        return availablePayoutMethods;
    }
}
