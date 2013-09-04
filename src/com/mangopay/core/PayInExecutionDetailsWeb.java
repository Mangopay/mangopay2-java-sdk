package com.mangopay.core;

/**
 * Class represents Web type for execution option in PayIn entity
 */
public class PayInExecutionDetailsWeb extends Dto implements IPayInExecutionDetails {

    /**
     * URL format expected.
     */
    public String TemplateURL;
    
    /**
     * Culture.
     */
    public String Culture;
    
    /**
     * Mode3DSType { DEFAULT, FORCE }
     */
    public String SecureMode;
    
}
