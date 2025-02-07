package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

/**
 * Card entity.
 */
public class IdentityVerification extends EntityBase {

    /**
     * The URL to redirect the user to for the hosted identity verification session.
     */
    @SerializedName("HostedUrl")
    private String hostedUrl;

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
     * The URL to which the user is returned after the hosted identity verification session, regardless of the outcome.
     */
    @SerializedName("ReturnUrl")
    private String returnUrl;

    public String getHostedUrl() {
        return hostedUrl;
    }

    public IdentityVerification setHostedUrl(String hostedUrl) {
        this.hostedUrl = hostedUrl;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public IdentityVerification setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public IdentityVerification setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }
}
