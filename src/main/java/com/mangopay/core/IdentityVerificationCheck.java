package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IdentityVerificationCheck extends Dto {

    /**
     * Unique identifier for the entire verification session.
     */
    @SerializedName("SessionId")
    private String sessionId;

    /**
     * The status of the identity verification session:
     * <p>PENDING – The session is available on the HostedUrl, to which the user must be redirected to complete it.</p>
     * <p>VALIDATED – The session was successful.</p>
     * <p>REFUSED – The session was refused.</p>
     * <p>REVIEW – The session is under manual review by Mangopay.</p>
     * <p>OUTDATED – The session is no longer valid (likely due to expired documents used during the session).</p>
     * <p>TIMEOUT – The session timed out due to inactivity.</p>
     * <p>ERROR – The session was not completed because an error occurred.</p>
     */
    @SerializedName("Status")
    private String status;

    /**
     * The date and time at which the session was created.
     */
    @SerializedName("CreationDate")
    private long creationDate;

    /**
     * The date and time at which the session was last updated.
     */
    @SerializedName("LastUpdate")
    private long lastUpdate;

    /**
     * The details of the individual verification checks performed during the session.
     */
    @SerializedName("Checks")
    private List<Check> checks;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }
}
