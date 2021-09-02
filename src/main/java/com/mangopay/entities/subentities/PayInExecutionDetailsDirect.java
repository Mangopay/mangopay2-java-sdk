package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Billing;
import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.SecurityInfo;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.core.interfaces.PayInExecutionDetails;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Class representing the Direct type for execution option in PayIn entity.
 */
public class PayInExecutionDetailsDirect extends Dto implements PayInExecutionDetails {

    /**
     * Card identifier.
     */
    @SerializedName("CardId")
    private String cardId;

    /**
     * Secure mode.
     */
    @SerializedName("SecureMode")
    private SecureMode secureMode;

    /**
     * Secure mode return URL.
     */
    @SerializedName("SecureModeReturnURL")
    private String secureModeReturnUrl;

    /**
     * Secure mode redirect URL.
     */
    @SerializedName("SecureModeRedirectURL")
    private String secureModeRedirectUrl;

    /**
     * Secure mode needed.
     */
    @SerializedName("SecureModeNeeded")
    private String secureModeNeeded;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("SecurityInfo")
    private SecurityInfo securityInfo;

    @SerializedName("Requested3DSVersion")
    private String requested3DSVersion;

    @SerializedName("Applied3DSVersion")
    private String applied3DSVersion;

    /**
     * The language to use for the payment page - needs to be the ISO code of the language
     */
    @SerializedName("Culture")
    private CultureCode culture;

    public PayInExecutionDetailsDirect() {
    }

    public PayInExecutionDetailsDirect(String cardId, String secureModeReturnUrl) {
        this.cardId = cardId;
        this.secureModeReturnUrl = secureModeReturnUrl;
    }

    public PayInExecutionDetailsDirect(String cardId, SecureMode secureMode, String secureModeReturnUrl) {
        this.cardId = cardId;
        this.secureMode = secureMode;
        this.secureModeReturnUrl = secureModeReturnUrl;
    }

    public PayInExecutionDetailsDirect(String cardId, SecureMode secureMode, String secureModeReturnUrl,
                                       String secureModeRedirectUrl, String secureModeNeeded, Billing billing, SecurityInfo securityInfo, CultureCode culture) {
        this.cardId = cardId;
        this.secureMode = secureMode;
        this.secureModeReturnUrl = secureModeReturnUrl;
        this.secureModeRedirectUrl = secureModeRedirectUrl;
        this.secureModeNeeded = secureModeNeeded;
        this.billing = billing;
        this.securityInfo = securityInfo;
        this.culture = culture;
    }

    public static PayInExecutionDetailsDirect build(String cardId, String secureModeReturnURL) {
        return new PayInExecutionDetailsDirect(cardId, secureModeReturnURL);
    }

    public static PayInExecutionDetailsDirect build(String cardId, SecureMode secureMode, String secureModeReturnURL) {
        return new PayInExecutionDetailsDirect(cardId, secureMode, secureModeReturnURL);
    }

    public static PayInExecutionDetailsDirect convert(PayInExecutionDetails executionDetails) throws Exception {
        if (ObjectTool.isNull(executionDetails)) {
            throw new Exception("PayInExecutionDetails null value");
        } else if (executionDetails instanceof PayInExecutionDetailsDirect) {
            return (PayInExecutionDetailsDirect) executionDetails;
        } else {
            throw new Exception("PayInExecutionDetails instance isn't PayInExecutionDetailsDirect instance");
        }
    }

    public String getCardId() {
        return cardId;
    }

    public PayInExecutionDetailsDirect setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public SecureMode getSecureMode() {
        return secureMode;
    }

    public PayInExecutionDetailsDirect setSecureMode(SecureMode secureMode) {
        this.secureMode = secureMode;
        return this;
    }

    public String getSecureModeReturnUrl() {
        return secureModeReturnUrl;
    }

    /**
     * Set Secure mode return URL
     *
     * @param secureModeReturnUrl
     */
    public PayInExecutionDetailsDirect setSecureModeReturnUrl(String secureModeReturnUrl) {
        this.secureModeReturnUrl = secureModeReturnUrl;
        return this;
    }

    /**
     * Get Secure mode redirect URL.
     *
     * @return String
     */
    public String getSecureModeRedirectUrl() {
        return secureModeRedirectUrl;
    }

    public PayInExecutionDetailsDirect setSecureModeRedirectUrl(String secureModeRedirectUrl) {
        this.secureModeRedirectUrl = secureModeRedirectUrl;
        return this;
    }

    /**
     * Is SecureMode Needed
     *
     * @return True if is needed
     */
    public boolean isSecureModeNeeded() {
        if (ObjectTool.nonNull(secureModeNeeded)) {
            return Boolean.parseBoolean(secureModeNeeded);
        } else {
            return false;
        }
    }

    public PayInExecutionDetailsDirect setSecureModeNeeded(String secureModeNeeded) {
        this.secureModeNeeded = secureModeNeeded;
        return this;
    }

    public String getSecureModeNeeded() {
        return secureModeNeeded;
    }

    public Billing getBilling() {
        return billing;
    }

    public PayInExecutionDetailsDirect setBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }

    public PayInExecutionDetailsDirect setSecurityInfo(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
        return this;
    }

    public String getRequested3DSVersion() { return requested3DSVersion; }

    public PayInExecutionDetailsDirect setRequested3DSVersion(String requested3DSVersion) { this.requested3DSVersion = requested3DSVersion; return this; }

    public String getApplied3DSVersion() {  return applied3DSVersion; }

    public PayInExecutionDetailsDirect setApplied3DSVersion(String applied3DSVersion) {
        this.applied3DSVersion = applied3DSVersion;
        return this;
    }

    @Override
    public Map<String, Type> getSubObjects() {


        Map<String, Type> result = super.getSubObjects();

        result.put("SecurityInfo", SecurityInfo.class);
        result.put("Billing", Billing.class);

        return result;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public PayInExecutionDetailsDirect setCulture(CultureCode culture) {
        this.culture = culture;
        return this;
    }
}
