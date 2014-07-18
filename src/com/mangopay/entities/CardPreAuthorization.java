package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CardPreAuthorization entity.
 */
public class CardPreAuthorization extends EntityBase {
    
    /**
     * The user Id of the author of the pre-authorization.
     */
    public String AuthorId;
    
    /**
     * Represents the amount debited on the bank account 
     * of the Author. DebitedFunds = Fees + CreditedFunds 
     * (amount received on wallet)
     */
    public Money DebitedFunds;
    
    /**
     * Status of the PreAuthorization: { CREATED, SUCCEEDED, FAILED }
     */
    public String Status;
    
    /**
     * The status of the payment after the PreAuthorization:
     * { WAITING, CANCELED, EXPIRED, VALIDATED }
     */
    public String PaymentStatus;
    
    /**
     * The PreAuthorization result code.
     */
    public String ResultCode;
    
    /**
     * The PreAuthorization result Message explaining the result code.
     */
    public String ResultMessage;
        
    /**
     * How the PreAuthorization has been executed. 
     * Only single value for now: CARD
     */
    public String ExecutionType;
    
    /**
     * The SecureMode correspond to '3D secure' for CB Visa and MasterCard 
     * or 'Amex Safe Key' for American Express. 
     * This field lets you activate it manually.
     */
    public String SecureMode;
    
    /**
     * Identifier of the registered card (got through CardRegistration object).
     */
    public String CardId;
    
    /**
     * Boolean. The value is 'true' if the SecureMode was used.
     */
    public String SecureModeNeeded;
    
    /**
     * This is the URL where to redirect users to proceed 
     * to 3D secure validation.
     */
    public String SecureModeRedirectURL;
    
    /**
     * This is the URL where users are automatically redirected 
     * after 3D secure validation (if activated).
     */
    public String SecureModeReturnURL;
    
    /**
     * The date when the payment has been processed (UNIX timestamp).
     */
    public Long ExpirationDate;
    
    /**
     * Identifier of the associated PayIn.
     */
    public String PayInId;
    
    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        HashMap<String, Type> result = new HashMap<>();
        
        result.put("DebitedFunds", Money.class);
        
        return result;
    }
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("Status");
        result.add("ResultCode");
        result.add("ResultMessage");
        
        return result;
    }
}
