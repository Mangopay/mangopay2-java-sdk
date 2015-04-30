package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.*;
import java.util.ArrayList;

/**
 * User entity abstract class. 
 * Parent for <code>UserNatural</code> or <code>UserLegal<code> child types.
 */
public abstract class User extends EntityBase {

    /**
     * Type of user.
     */
    public PersonType PersonType;
    
    /**
     * KYC level.
     */
    public KycLevel KYCLevel;

    /**
     * Email address.
     */
    public String Email;

    public User(PersonType personType) {
        PersonType = personType;
    }

    /**
     * Descendant classes override it.
     */
    protected User() {}
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("PersonType");
        result.add("KYCLevel");
        
        return result;
    }
}
