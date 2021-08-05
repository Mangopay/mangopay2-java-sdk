package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;

import java.lang.reflect.Type;
import java.util.Map;

public class CurrentState extends Dto {

    @SerializedName("PayinsLinked ")
    private int payinsLinked;

    @SerializedName("CumulatedDebitedAmount")
    private Money cumulatedDebitedAmount;

    @SerializedName("CumulatedFeesAmount")
    private Money cumulatedFeesAmount;

    @SerializedName("LastPayinId")
    private String lastPayinId;

    public int getPayinsLinked() {
        return payinsLinked;
    }

    public Money getCumulatedDebitedAmount() {
        return cumulatedDebitedAmount;
    }

    public Money getCumulatedFeesAmount() {
        return cumulatedFeesAmount;
    }

    public String getLastPayinId() {
        return lastPayinId;
    }

    @Override
    public Map<String, Type> getSubObjects() {
        Map<String, Type> result = super.getSubObjects();

        result.put("Money", Money.class);

        return result;
    }
}
