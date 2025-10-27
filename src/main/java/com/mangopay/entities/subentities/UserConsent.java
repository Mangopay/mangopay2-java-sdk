package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class UserConsent extends Dto {

    @SerializedName("PendingUserAction")
    PendingUserAction pendingUserAction;

    public PendingUserAction getPendingUserAction() {
        return pendingUserAction;
    }
}
