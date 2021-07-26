package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.Map;

public class RecurringPaymentExtended extends RecurringPayment {

    @SerializedName("CurrentState")
    private CurrentState currentState;

    public CurrentState getCurrentState() {
        return currentState;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> result = super.getSubObjects();

        result.put("CurrentState", CurrentState.class);

        return result;
    }
}
