package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.entities.subentities.InstantPayout;

public class PayOutEligibilityResult extends Dto {
    @SerializedName("InstantPayout")
    private InstantPayout instantPayout;

    public InstantPayout getInstantPayout() {
        return instantPayout;
    }

    public void setInstantPayout(InstantPayout instantPayout) {
        this.instantPayout = instantPayout;
    }
}
