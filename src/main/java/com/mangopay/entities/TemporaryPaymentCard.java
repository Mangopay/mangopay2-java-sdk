package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getUserId()} and {@link #setUserId(String)} instead.
     */
    @Deprecated
    public String UserId;

    /**
     * Culture.
     *
     * @deprecated Use {@link #getCulture()} and {@link #setCulture(String)} instead.
     */
    @Deprecated
    public String Culture;

    /**
     * Return URL.
     *
     * @deprecated Use {@link #getReturnURL()} and {@link #setReturnURL(String)} instead.
     */
    @Deprecated
    public String ReturnURL;

    /**
     * Template URL.
     *
     * @deprecated Use {@link #getTemplateURL()} and {@link #setTemplateURL(String)} instead.
     */
    @Deprecated
    public String TemplateURL;

    /**
     * Redirect URL.
     *
     * @deprecated Use {@link #getRedirectURL()} and {@link #setRedirectURL(String)} instead.
     */
    @Deprecated
    public String RedirectURL;

    /**
     * Alias.
     *
     * @deprecated Use {@link #getAlias()} and {@link #setAlias(String)} instead.
     */
    @Deprecated
    public String Alias;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getCulture() {
        return Culture;
    }

    public void setCulture(String culture) {
        this.Culture = culture;
    }

    public String getReturnURL() {
        return ReturnURL;
    }

    public void setReturnURL(String returnURL) {
        this.ReturnURL = returnURL;
    }

    public String getTemplateURL() {
        return TemplateURL;
    }

    public void setTemplateURL(String templateURL) {
        this.TemplateURL = templateURL;
    }

    public String getRedirectURL() {
        return RedirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.RedirectURL = redirectURL;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        this.Alias = alias;
    }
}
