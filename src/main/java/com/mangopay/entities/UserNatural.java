package com.mangopay.entities;

import com.mangopay.core.Address;
import com.mangopay.core.enumerations.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * UserNatural entity.
 */
public final class UserNatural extends User {
    
    /**
     * First name.
     */
    public String FirstName;
    
     /**
     * Last name.
     */
    public String LastName;
    
     /**
     * Address.
     */
    public Address Address;
    
     /**
     * Date of birth (UNIX timestamp).
     */
    public long Birthday;
    
     /**
     * Place of birth.
     */
    public String Birthplace;
    
     /**
     * User's country.
     */
    public CountryIso Nationality;
    
     /**
     * Country of residence.
     */
    public CountryIso CountryOfResidence;
    
    /**
     * User's occupation.
     */
    public String Occupation;
    
    /**
     * Income ranges:
     * 1 (-18K€),
     * 2 (18-30K€),
     * 3 (30-50K€),
     * 4 (50-80K€),
     * 5 (80-120K€),
     * 6 (+120K€)
     */
    public static class IncomeRanges {
        public static final Integer Below18 = 1;
        public static final Integer From18To30 = 2;
        public static final Integer From30To50 = 3;
        public static final Integer From50To80 = 4;
        public static final Integer From80To120 = 5;
        public static final Integer Above120 = 6;
    }

    /**
     * Income range. One of UserNatural.IncomeRanges constants.
     */
    public Integer IncomeRange;
    
    /**
     * Proof of identity.
     */
    protected String ProofOfIdentity;

    /**
     * Proof of address.
     */
    protected String ProofOfAddress;

    /**
     * Instantiates new UserNatural object.
     */
    public UserNatural() {
        PersonType = PersonType.NATURAL;
    }
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        Map<String, Type> result = super.getSubObjects();
        
        result.put("Address", Address.class);
        
        return result;
    }
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("ProofOfIdentity");
        result.add("ProofOfAddress");
        
        return result;
    }
}
