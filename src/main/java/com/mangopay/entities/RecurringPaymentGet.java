package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Money;
import com.mangopay.entities.subentities.BrowserInfo;

import java.lang.reflect.Type;
import java.util.Map;

public class RecurringPaymentGet extends RecurringPayment{

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
