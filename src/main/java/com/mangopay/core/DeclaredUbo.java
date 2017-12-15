package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.UboRefusedReasonType;
import com.mangopay.core.enumerations.DeclaredUboStatus;

/**
 * Represents validation status of a user declared as UBO.
 */
public class DeclaredUbo extends Dto {

    /**
     * ID of the declared user.
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * Validation status of this declared UBO.
     */
    @SerializedName("Status")
    private DeclaredUboStatus status;

    /**
     * Reason why the declared UBO is not valid.
     */
    @SerializedName("RefusedReasonType")
    private UboRefusedReasonType refusedReasonType;

    /**
     * Message explaining why the UBO is not valid.
     */
    @SerializedName("RefusedReasonMessage")
    private String refusedReasonMessage;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public DeclaredUboStatus getStatus() {
        return status;
    }

    public void setStatus(DeclaredUboStatus status) {
        this.status = status;
    }

    public UboRefusedReasonType getRefusedReasonType() {
        return refusedReasonType;
    }

    public void setRefusedReasonType(UboRefusedReasonType refusedReasonType) {
        this.refusedReasonType = refusedReasonType;
    }

    public String getRefusedReasonMessage() {
        return refusedReasonMessage;
    }

    public void setRefusedReasonMessage(String refusedReasonMessage) {
        this.refusedReasonMessage = refusedReasonMessage;
    }
}
