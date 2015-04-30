package com.mangopay.entities;

import com.mangopay.core.enumerations.*;
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
     * Type of legal user.
     */
    public LegalPersonType LegalPersonType;
    
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
    public CountryIso LegalRepresentativeNationality;
    
    /**
     * Legal representative country of residence.
     */
    public CountryIso LegalRepresentativeCountryOfResidence;
    
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
        PersonType = PersonType.LEGAL;
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
