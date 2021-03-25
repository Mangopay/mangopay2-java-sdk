package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.core.interfaces.PayInExecutionDetails;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Class representing Web type for execution option in PayIn entity.
 */
public class PayInExecutionDetailsWeb extends Dto implements PayInExecutionDetails {

    /**
     * URL format expected.
     */
    @SerializedName("TemplateURL")
    private String templateUrl;

    /**
     * Culture.
     */
    @SerializedName("Culture")
    private CultureCode culture;

    /**
     * Secure mode.
     */
    @SerializedName("SecureMode")
    private SecureMode secureMode;

    /**
     * Redirect URL.
     */
    @SerializedName("RedirectURL")
    private String redirectUrl;

    /**
     * Return URL.
     */
    @SerializedName("ReturnURL")
    private String returnUrl;

    /**
     * The URL where you host the iFramed template.
     * For CB, Visa, MasterCard you need to specify PAYLINE: before your URL
     * with the iFramed template
     * ex: PAYLINE: https://www.maysite.com/payline_template/
     * Used for:
     * - direct debit web type pay-in.
     *
     * @deprecated Use {@link #getTemplateURLOptions()} and {@link #setTemplateURLOptions(PayInTemplateURLOptions)} instead.
     */
    @Deprecated
    public PayInTemplateURLOptions TemplateURLOptions;

    public PayInExecutionDetailsWeb(String templateUrl, CultureCode culture, SecureMode secureMode, String redirectUrl, String returnUrl) {
        this.templateUrl = templateUrl;
        this.culture = culture;
        this.secureMode = secureMode;
        this.redirectUrl = redirectUrl;
        this.returnUrl = returnUrl;
    }

    public PayInExecutionDetailsWeb() {
    }

    public String getTemplateUrl() {
        return templateUrl;
    }

    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public void setCulture(CultureCode culture) {
        this.culture = culture;
    }

    public SecureMode getSecureMode() {
        return secureMode;
    }

    public void setSecureMode(SecureMode secureMode) {
        this.secureMode = secureMode;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public PayInTemplateURLOptions getTemplateURLOptions() {
        return TemplateURLOptions;
    }

    public void setTemplateURLOptions(PayInTemplateURLOptions templateURLOptions) { this.TemplateURLOptions = templateURLOptions; }

    /**
     * Gets the collection of read-only fields names
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("RedirectURL");

        return result;
    }

    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("TemplateURLOptions", PayInTemplateURLOptions.class);

        return result;
    }
}
