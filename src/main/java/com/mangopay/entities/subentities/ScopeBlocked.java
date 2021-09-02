package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;

public class ScopeBlocked {
    @SerializedName("Inflows")
    private Boolean inflows;

    @SerializedName("Outflows")
    private Boolean outflows;

    public Boolean getInflows() {
        return inflows;
    }

    public ScopeBlocked setInflows(Boolean inflows) {
        this.inflows = inflows;
        return this;
    }

    public Boolean getOutflows() {
        return outflows;
    }

    public ScopeBlocked setOutflows(Boolean outflows) {
        this.outflows = outflows;
        return this;
    }
}
