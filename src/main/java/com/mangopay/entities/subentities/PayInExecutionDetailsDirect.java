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

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public SecureMode getSecureMode() {
        return secureMode;
    }

    public void setSecureMode(SecureMode secureMode) {
        this.secureMode = secureMode;
    }

    public String getSecureModeReturnUrl() {
        return secureModeReturnUrl;
    }

    /**
     * Set Secure mode return URL
     *
     * @param secureModeReturnUrl
     */
    public void setSecureModeReturnUrl(String secureModeReturnUrl) {
        this.secureModeReturnUrl = secureModeReturnUrl;
    }

    /**
     * Get Secure mode redirect URL.
     *
     * @return String
     */
    public String getSecureModeRedirectUrl() {
        return secureModeRedirectUrl;
    }

    public void setSecureModeRedirectUrl(String secureModeRedirectUrl) {
        this.secureModeRedirectUrl = secureModeRedirectUrl;
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

    public void setSecureModeNeeded(String secureModeNeeded) {
        this.secureModeNeeded = secureModeNeeded;
    }

    public String getSecureModeNeeded() {
        return secureModeNeeded;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }

    public void setSecurityInfo(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
    }

    @Override
    public Map<String, Type> getSubObjects() {


        Map<String, Type> result = super.getSubObjects();

        result.put("SecurityInfo", SecurityInfo.class);

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
