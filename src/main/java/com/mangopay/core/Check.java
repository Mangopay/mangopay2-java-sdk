package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Check extends Dto {

    /**
     * The unique identifier of the verification check.
     */
    @SerializedName("CheckId")
    private String checkId;

    /**
     * Type of verification check performed:
     * <p>BUSINESS_VERIFICATION - Verification of the business entity of a Legal User.</p>
     * <p>IDENTITY_DOCUMENT_VERIFICATION - Verification of the identity document of a Natural User or the legal representative of a Legal User.</p>
     * <p>PERSONS_SIGNIFICANT_CONTROL - Verification of a person of significant control of a Legal User.</p>
     */
    @SerializedName("Type")
    private String type;

    /**
     * Returned values: VALIDATED, REFUSED, REVIEW
     */
    @SerializedName("CheckStatus")
    private String checkStatus;

    /**
     * The date and time at which the check was created.
     */
    @SerializedName("CreationDate")
    private long creationDate;

    /**
     * The date and time at which the check was last updated.
     */
    @SerializedName("LastUpdate")
    private long lastUpdate;

    /**
     * The data points collected and verified during the check.
     */
    @SerializedName("Data")
    private List<CheckData> data;

    @SerializedName("Reasons")
    private List<CheckData> reasons;

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<CheckData> getData() {
        return data;
    }

    public void setData(List<CheckData> data) {
        this.data = data;
    }

    public List<CheckData> getReasons() {
        return reasons;
    }

    public void setReasons(List<CheckData> reasons) {
        this.reasons = reasons;
    }
}
