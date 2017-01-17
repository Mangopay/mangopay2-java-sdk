package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.enumerations.SecureMode;
import com.mangopay.core.interfaces.PayInExecutionDetails;

/**
 * Class representing the Direct type for execution option in PayIn entity.
 */
public class PayInExecutionDetailsDirect extends Dto implements PayInExecutionDetails {

    /**
     * Card identifier.
     *
     * @deprecated Use {@link #getCardId()} and {@link #setCardId(String)} instead.
     */
    @Deprecated
    public String CardId;

    /**
     * Secure mode.
     *
     * @deprecated Use {@link #getSecureMode()} and {@link #setSecureMode(SecureMode)} instead.
     */
    @Deprecated
    public SecureMode SecureMode;

    /**
     * Secure mode return URL.
     *
     * @deprecated Use {@link #getSecureModeReturnURL()} and {@link #setSecureModeReturnURL(String)} instead.
     */
    @Deprecated
    public String SecureModeReturnURL;

    /**
     * Secure mode redirect URL.
     *
     * @deprecated Use {@link #getSecureModeRedirectURL()} and {@link #setSecureModeRedirectURL(String)} instead.
     */
    @Deprecated
    public String SecureModeRedirectURL;

    /**
     * Secure mode needed.
     *
     * @deprecated Use {@link #getSecureModeNeeded()} and {@link #setSecureModeNeeded(String)} instead.
     */
    @Deprecated
    public String SecureModeNeeded;

    public PayInExecutionDetailsDirect() {
    }

    public PayInExecutionDetailsDirect(String cardId, String secureModeReturnURL) {
        this.CardId = cardId;
        this.SecureModeReturnURL = secureModeReturnURL;
    }

    public PayInExecutionDetailsDirect(String cardId, SecureMode secureMode, String secureModeReturnURL) {
        this.CardId = cardId;
        this.SecureMode = secureMode;
        this.SecureModeReturnURL = secureModeReturnURL;
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

    /**
     * Is SecureMode Needed
     *
     * @return True if is needed
     */
    public boolean isSecureModeNeeded() {
        if (ObjectTool.nonNull(SecureModeNeeded)) {
            return Boolean.parseBoolean(SecureModeNeeded);
        } else {
            return false;
        }
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        this.CardId = cardId;
    }

    public SecureMode getSecureMode() {
        return SecureMode;
    }

    public void setSecureMode(SecureMode secureMode) {
        this.SecureMode = secureMode;
    }

    public String getSecureModeReturnURL() {
        return SecureModeReturnURL;
    }

    /**
     * Set Secure mode return URL
     *
     * @param secureModeReturnURL
     */
    public void setSecureModeReturnURL(String secureModeReturnURL) {
        this.SecureModeReturnURL = secureModeReturnURL;
    }

    /**
     * Get Secure mode redirect URL.
     *
     * @return String
     */
    public String getSecureModeRedirectURL() {
        return SecureModeRedirectURL;
    }

    public void setSecureModeRedirectURL(String secureModeRedirectURL) {
        this.SecureModeRedirectURL = secureModeRedirectURL;
    }

    public String getSecureModeNeeded() {
        return SecureModeNeeded;
    }

    public void setSecureModeNeeded(String secureModeNeeded) {
        this.SecureModeNeeded = secureModeNeeded;
    }

}
