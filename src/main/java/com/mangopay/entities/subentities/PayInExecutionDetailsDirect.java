package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
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
}
