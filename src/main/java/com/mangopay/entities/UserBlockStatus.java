package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.entities.subentities.ScopeBlocked;

public class UserBlockStatus extends EntityBase {
    @SerializedName("ScopeBlocked")
    private ScopeBlocked scopeBlocked;

    @SerializedName("ActionCode")
    private String actionCode;

    public ScopeBlocked getScopeBlocked() {
        return scopeBlocked;
    }

    public UserBlockStatus setScopeBlocked(ScopeBlocked scopeBlocked) {
        this.scopeBlocked = scopeBlocked;
        return this;
    }

    public String getActionCode() {
        return actionCode;
    }

    public UserBlockStatus setActionCode(String actionCode) {
        this.actionCode = actionCode;
        return this;
    }

}
