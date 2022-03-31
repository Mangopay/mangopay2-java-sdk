package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;

public class InstantPayout {

    @SerializedName("IsReachable")
    private boolean isReachable;

    @SerializedName("UnreachableReason")
    private FallbackReason unreachableReason;

    public boolean isReachable() {
        return isReachable;
    }

    public void setReachable(boolean reachable) {
        isReachable = reachable;
    }

    public FallbackReason getUnreachableReason() {
        return unreachableReason;
    }

    public void setUnreachableReason(FallbackReason unreachableReason) {
        this.unreachableReason = unreachableReason;
    }
}
