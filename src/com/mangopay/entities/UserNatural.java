package com.mangopay.entities;

import com.mangopay.core.NoUpdate;
import java.util.ArrayList;

/**
 * UserNatural entity.
 */
public final class UserNatural extends User {
    
    /**
     * First name for user.
     */
    public String FirstName;
    
     /**
     * Last name for user.
     */
    public String LastName;
    
     /**
     * Address for user.
     */
    public String Address;
    
     /**
     * Date of birth.
     */
    public long Birthday;
    
     /**
     * Place of birth.
     */
    public String Birthplace;
    
     /**
     * User's country
     * ISO 3166-1 alpha-2
     */
    public String Nationality;
    
     /**
     * Country of residence
     * ISO 3166-1 alpha-2
     */
    public String CountryOfResidence;
    
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
     * Income range. One of IncomeRanges constants.
     */
    public Integer IncomeRange;
    
    /**
     * Url of the document.
     */
    protected String ProofOfIdentity;

    /**
     * Url of the document.
     */
    protected String ProofOfAddress;

    public UserNatural() {
        PersonType = Types.Natural;
    }
    
    /**
     * Gets the collection of read-only fields names
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
