package com.mangopay.core;

/**
 * Class represents Web type for execution option in PayIn entity
 */
public class PayInExecutionDetailsDirect extends Dto implements IPayInExecutionDetails {
    
    /**
     * SecureMode { DEFAULT, FORCE }
     */
    public String SecureMode;
    
    /**
     * CardId
     */
    public String CardId;
    
    /**
     * SecureModeReturnURL
     */
    public String SecureModeReturnURL;
    
}
