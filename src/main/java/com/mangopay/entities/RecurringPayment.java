package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

public class RecurringPayment extends CreateRecurringPayment {
    @SerializedName("Id")
    private String id;

    @SerializedName("Status")
    private String status;

    @SerializedName("TotalAmount")
    private Integer totalAmount;

    @SerializedName("CycleNumber")
    private Integer cycleNumber;

    @SerializedName("FreeCycles")
    private Integer freeCycles;

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getCycleNumber() {
        return cycleNumber;
    }

    public int getFreeCycles() {
        return freeCycles;
    }
}
