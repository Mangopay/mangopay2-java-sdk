package com.mangopay.core;

import java.util.ArrayList;

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
    
    /**
     * URL format expected.
     */
    public String RedirectURL;
    
    /**
     * URL format expected.
     */
    public String ReturnURL;
    
    /**
     * Gets the collection of read-only fields names
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("RedirectURL");
        
        return result;
    }
}
