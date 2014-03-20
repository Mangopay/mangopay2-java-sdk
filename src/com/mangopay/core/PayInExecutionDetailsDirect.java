package com.mangopay.core;

/**
 * Class representing the Web type for execution option in PayIn entity.
 */
public class PayInExecutionDetailsDirect extends Dto implements IPayInExecutionDetails {
    
    /**
     * CardId.
     */
    public String CardId;
    
    /**
     * SecureMode { DEFAULT, FORCE }
     */
    public String SecureMode;
    
    /**
     * SecureModeReturnURL.
     */
    public String SecureModeReturnURL;
    
}
