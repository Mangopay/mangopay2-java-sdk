package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

/**
 * WARNING!
 * This is temporary entity and will be removed in future.
 * Contact support before using these features or if have any queries.
 * <p>
 * TemporaryPaymentCard entity.
 */
public class TemporaryPaymentCard extends EntityBase {

    /**
     * User identifier.
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * Culture.
     */
    @SerializedName("Culture")
    private String culture;

    /**
     * Return URL.
     */
    @SerializedName("ReturnURL")
    private String returnUrl;

    /**
     * Template URL.
     */
    @SerializedName("TemplateURL")
    private String templateUrl;

    /**
     * Redirect URL.
     */
    @SerializedName("RedirectURL")
    private String redirectUrl;

    /**
     * Alias.
     */
    @SerializedName("Alias")
    private String alias;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getTemplateUrl() {
        return templateUrl;
    }

    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
