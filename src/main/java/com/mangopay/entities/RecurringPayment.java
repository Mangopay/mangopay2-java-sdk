package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Money;

public class RecurringPayment extends CreateRecurringPayment {
    @SerializedName("Id")
    private String id;

    @SerializedName("Status")
    private String status;

    @SerializedName("TotalAmount")
    private Money totalAmount;

    @SerializedName("CycleNumber")
    private Integer cycleNumber;

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public int getCycleNumber() {
        return cycleNumber;
    }
}
