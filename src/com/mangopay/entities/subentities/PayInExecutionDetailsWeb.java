package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IPayInExecutionDetails;
import com.mangopay.core.enumerations.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Class representing Web type for execution option in PayIn entity.
 */
public class PayInExecutionDetailsWeb extends Dto implements IPayInExecutionDetails {

    /**
     * URL format expected.
     */
    public String TemplateURL;
    
    /**
     * Culture.
     */
    public CountryIso Culture;
    
    /**
     * Secure mode.
     */
    public SecureMode SecureMode;
    
    /**
     * Redirect URL.
     */
    public String RedirectURL;
    
    /**
     * Return URL.
     */
    public String ReturnURL;
    
    /**
     * The URL where you host the iFramed template.
     * For CB, Visa, MasterCard you need to specify PAYLINE: before your URL 
     * with the iFramed template 
     * ex: PAYLINE: https://www.maysite.com/payline_template/
     * Used for:
     *  - direct debit web type pay-in.
     */
    public PayInTemplateURLOptions TemplateURLOptions;
    
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
    
    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        Map<String, Type> result = super.getSubObjects();
        
        result.put("TemplateURLOptions", PayInTemplateURLOptions.class);
        
        return result;
    }
}
