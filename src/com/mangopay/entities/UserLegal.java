package com.mangopay.entities;

import com.mangopay.core.NoUpdate;
import java.util.ArrayList;

/**
 * UserLegal entity.
 */
public class UserLegal extends User {
    
    /**
     * Name of this user.
     */
    public String Name;
    
    /**
     * Allowed types for legal user.
     */
    public static class LegalPersonTypes {
        public static final String Business = "BUSINESS";
        public static final String Organization = "ASSOCIATION";
    }
    
    /**
     * Type for legal user. One of LegalPersonTypes constants.
     */
    public String LegalPersonType;
    
    /**
     */
    public String HeadquartersAddress;
    
    /**
     */
    public String LegalRepresentativeFirstName;
    
    /**
     */
    public String LegalRepresentativeLastName;
    
    /**
     */
    public String LegalRepresentativeAddress;
    
    /**
     */
    public String LegalRepresentativeEmail;
    
    /**
     */
    public long LegalRepresentativeBirthday;
    
    /**
     */
    public String LegalRepresentativeNationality;
    
    /**
     */
    public String LegalRepresentativeCountryOfResidence;
    
    /**
     */
    public String Statute;
    
    /**
     */
    public String ProofOfRegistration;
    
    /**
     */
    public String ShareholderDeclaration;

    /**
     * Creates new instance of UserLegal class.
     */
    public UserLegal() {
        PersonType = Types.Legal;
    }
    
    /**
     * Gets the collection of read-only fields names
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("Statute");
        result.add("ProofOfRegistration");
        result.add("ShareholderDeclaration");
        
        return result;
    }
}
