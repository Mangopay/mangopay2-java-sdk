package com.mangopay.entities;

import com.mangopay.core.Address;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public Address HeadquartersAddress;
    
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
    public Address LegalRepresentativeAddress;
    
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
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        Map<String, Type> result = super.getSubObjects();
        
        result.put("HeadquartersAddress", Address.class);
        result.put("LegalRepresentativeAddress", Address.class);
        
        return result;
        
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
