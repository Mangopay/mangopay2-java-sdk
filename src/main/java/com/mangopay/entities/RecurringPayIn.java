package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

public class RecurringPayIn extends PayIn {

    @SerializedName("RecurringPayinRegistrationId")
    private String recurringPayinRegistrationId;

    public String getRecurringPayinRegistrationId() {
        return recurringPayinRegistrationId;
    }
}
