package com.mangopay.core;

/**
 * Class representing the Direct type for execution option in PayIn entity.
 */
public class PayInExecutionDetailsDirect extends Dto implements IPayInExecutionDetails {
    
    /**
     * SecureMode { DEFAULT, FORCE }.
     */
    public String SecureMode;
    
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
