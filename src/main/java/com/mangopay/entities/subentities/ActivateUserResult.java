package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class ActivateUserResult extends Dto {

    /**
     * Information about the action required from the user if action was triggered by the API call (otherwise returned null).
     */
    @SerializedName("PendingUserAction")
    PendingUserAction pendingUserAction;

    public PendingUserAction getPendingUserAction() {
        return pendingUserAction;
    }
}
