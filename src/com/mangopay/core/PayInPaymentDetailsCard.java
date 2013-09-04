package com.mangopay.core;

import java.util.ArrayList;

/**
 * Class represents Card type for mean of payment in PayIn entity
 */
public class PayInPaymentDetailsCard extends Dto implements IPayInPaymentDetails {

    /**
     * CardType { CB_VISA_MASTERCARD, AMEX }
     */
    public String CardType;
    
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
