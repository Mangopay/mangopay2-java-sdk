package com.mangopay.entities;

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
     * Type for legal user. One of UserLegal.LegalPersonTypes constants.
     */
    public String LegalPersonType;
    
    /**
     * Headquarters address.
     */
    public String HeadquartersAddress;
    
    /**
     * Legal representative first name.
     */
    public String LegalRepresentativeFirstName;
    
    /**
     * Legal representative last name.
     */
    public String LegalRepresentativeLastName;
    
    /**
     * Legal representative address.
     */
    public String LegalRepresentativeAddress;
    
    /**
     * Legal representative email.
     */
    public String LegalRepresentativeEmail;
    
    /**
     * Legal representative birthday.
     */
    public long LegalRepresentativeBirthday;
    
    /**
     * Legal representative nationality.
     */
    public String LegalRepresentativeNationality;
    
    /**
     * Legal representative country of residence.
     */
    public String LegalRepresentativeCountryOfResidence;
    
    /**
     * Statute.
     */
    public String Statute;
    
    /**
     * Proof of registration.
     */
    public String ProofOfRegistration;
    
    /**
     * Shareholder declaration.
     */
    public String ShareholderDeclaration;

    /**
     * Instantiates new UserLegal object.
     */
    public UserLegal() {
        PersonType = Types.Legal;
    }
    
    /**
     * Gets the collection of read-only fields names.
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
