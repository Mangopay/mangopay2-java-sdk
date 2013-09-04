package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import java.util.ArrayList;

/**
 * User entity abstract class. 
 * Parent for <code>UserNatural</code> or <code>UserLegal<code> child types.
 */
public abstract class User extends EntityBase {

    /**
     * Allowed types of user.
     */
    public static class Types {
        public static final String Natural = "NATURAL";
        public static final String Legal = "LEGAL";
    }

    /**
     * Type of user. One of Types constants.
     */
    public String PersonType;

    /**
     * Email address.
     */
    public String Email;

    public User(String personType) {
        PersonType = personType;
    }

    /**
     * Descendant classes override it.
     */
    protected User() {}
    
    /**
     * Gets the collection of read-only fields names
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("PersonType");
        
        return result;
    }
}
