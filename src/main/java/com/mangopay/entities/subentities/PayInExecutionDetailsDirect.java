package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.interfaces.IPayInExecutionDetails;
import com.mangopay.core.enumerations.SecureMode;

/**
 * Class representing the Direct type for execution option in PayIn entity.
 */
public class PayInExecutionDetailsDirect extends Dto implements IPayInExecutionDetails {

    /**
     * Card identifier.
     */
    public String CardId;

    /**
     * Secure mode.
     */
    public SecureMode SecureMode;

    /**
     * Secure mode return URL.
     */
    public String SecureModeReturnURL;

    /**
     * Secure mode redirect URL.
     */
    public String SecureModeRedirectURL;

    /**
     * Secure mode needed.
     */
    public String SecureModeNeeded;

    public PayInExecutionDetailsDirect() {
    }

    public PayInExecutionDetailsDirect(String cardId, String secureModeReturnURL) {
        this.CardId = cardId;
        this.SecureModeReturnURL = secureModeReturnURL;
    }

    public static PayInExecutionDetailsDirect build(String cardId, String secureModeReturnURL) {
        return new PayInExecutionDetailsDirect(cardId, secureModeReturnURL);
    }

    public PayInExecutionDetailsDirect(String cardId, SecureMode secureMode, String secureModeReturnURL) {
        this.CardId = cardId;
        this.SecureMode = secureMode;
        this.SecureModeReturnURL = secureModeReturnURL;
    }

    public static PayInExecutionDetailsDirect build(String cardId, SecureMode secureMode, String secureModeReturnURL) {
        return new PayInExecutionDetailsDirect(cardId, secureMode, secureModeReturnURL);
    }
    
    public static PayInExecutionDetailsDirect convert(IPayInExecutionDetails executionDetails) throws Exception {
        if (ObjectTool.isNull(executionDetails)) {
            throw new Exception("IPayInExecutionDetails null value");
        } else if (executionDetails  instanceof PayInExecutionDetailsDirect) {
            return (PayInExecutionDetailsDirect) executionDetails;
        } else {
            throw new Exception("IPayInExecutionDetails instance isn't PayInExecutionDetailsDirect instance");
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

    /**
     * Set Secure mode return URL
     * @param SecureModeReturnURL 
     */
    public void setSecureModeReturnURL(String SecureModeReturnURL) {
        this.SecureModeReturnURL = SecureModeReturnURL;
    }

    /**
     * Get Secure mode redirect URL.
     * @return String 
     */
    public String getSecureModeRedirectURL() {
        return SecureModeRedirectURL;
    }

}
