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
    
}
