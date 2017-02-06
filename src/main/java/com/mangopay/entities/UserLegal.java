package com.mangopay.entities;

import com.mangopay.core.Address;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.mangopay.core.enumerations.PersonType.LEGAL;

/**
 * UserLegal entity.
 */
public class UserLegal extends User {
    
    /**
     * Name of this user.
     *
     * @deprecated Use {@link #getName()} and {@link #setName(String)} instead.
     */
    @Deprecated
    public String Name;
    
    /**
     * Type of legal user.
     *
     * @deprecated Use {@link #getLegalPersonType()} and {@link #setLegalPersonType(LegalPersonType)} instead.
     */
    @Deprecated
    public LegalPersonType LegalPersonType;
    
    /**
     * Headquarters address.
     *
     * @deprecated Use {@link #getHeadquartersAddress()} and {@link #setHeadquartersAddress(Address)} instead.
     */
    @Deprecated
    public Address HeadquartersAddress;
    
    /**
     * Legal representative first name.
     *
     * @deprecated Use {@link #getLegalRepresentativeFirstName()} and {@link #setLegalRepresentativeFirstName(String)}   instead.
     */
    @Deprecated
    public String LegalRepresentativeFirstName;
    
    /**
     * Legal representative last name.
     *
     * @deprecated Use {@link #getLegalRepresentativeLastName()} and {@link #setLegalRepresentativeLastName(String)} instead.
     */
    @Deprecated
    public String LegalRepresentativeLastName;
    
    /**
     * Legal representative address.
     *
     * @deprecated Use {@link #getLegalRepresentativeAddress()} and {@link #setLegalRepresentativeAddress(Address)} instead.
     */
    @Deprecated
    public Address LegalRepresentativeAddress;
    
    /**
     * Legal representative email.
     *
     * @deprecated Use {@link #getLegalRepresentativeEmail()} and {@link #setLegalRepresentativeEmail(String)} instead.
     */
    @Deprecated
    public String LegalRepresentativeEmail;
    
    /**
     * Legal representative birthday.
     *
     * @deprecated Use {@link #getLegalRepresentativeBirthday()} and {@link #setLegalRepresentativeBirthday(long)} instead.
     */
    @Deprecated
    public long LegalRepresentativeBirthday;
    
    /**
     * Legal representative nationality.
     *
     * @deprecated Use {@link #getLegalRepresentativeNationality()} and {@link #setLegalRepresentativeNationality(CountryIso)} instead.
     */
    @Deprecated
    public CountryIso LegalRepresentativeNationality;
    
    /**
     * Legal representative country of residence.
     *
     * @deprecated Use {@link #getLegalRepresentativeCountryOfResidence()} and {@link #setLegalRepresentativeCountryOfResidence(CountryIso)} instead.
     */
    @Deprecated
    public CountryIso LegalRepresentativeCountryOfResidence;
    
    /**
     * Statute.
     *
     * @deprecated Use {@link #getStatute()} and {@link #setStatute(String)} instead.
     */
    @Deprecated
    public String Statute;
    
    /**
     * Proof of registration.
     *
     * @deprecated Use {@link #getProofOfRegistration()} and {@link #setProofOfRegistration(String)} instead.
     */
    @Deprecated
    public String ProofOfRegistration;
    
    /**
     * Shareholder declaration.
     *
     * @deprecated Use {@link #getShareholderDeclaration()} and {@link #setShareholderDeclaration(String)} instead.
     */
    @Deprecated
    public String ShareholderDeclaration;

    /**
     * Instantiates new UserLegal object.
     */
    public UserLegal() {
        this.PersonType = LEGAL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public LegalPersonType getLegalPersonType() {
        return LegalPersonType;
    }

    public void setLegalPersonType(LegalPersonType legalPersonType) {
        this.LegalPersonType = legalPersonType;
    }

    public Address getHeadquartersAddress() {
        return HeadquartersAddress;
    }

    public void setHeadquartersAddress(Address headquartersAddress) {
        this.HeadquartersAddress = headquartersAddress;
    }

    public String getLegalRepresentativeFirstName() {
        return LegalRepresentativeFirstName;
    }

    public void setLegalRepresentativeFirstName(String legalRepresentativeFirstName) {
        this.LegalRepresentativeFirstName = legalRepresentativeFirstName;
    }

    public String getLegalRepresentativeLastName() {
        return LegalRepresentativeLastName;
    }

    public void setLegalRepresentativeLastName(String legalRepresentativeLastName) {
        this.LegalRepresentativeLastName = legalRepresentativeLastName;
    }

    public Address getLegalRepresentativeAddress() {
        return LegalRepresentativeAddress;
    }

    public void setLegalRepresentativeAddress(Address legalRepresentativeAddress) {
        this.LegalRepresentativeAddress = legalRepresentativeAddress;
    }

    public String getLegalRepresentativeEmail() {
        return LegalRepresentativeEmail;
    }

    public void setLegalRepresentativeEmail(String legalRepresentativeEmail) {
        this.LegalRepresentativeEmail = legalRepresentativeEmail;
    }

    public long getLegalRepresentativeBirthday() {
        return LegalRepresentativeBirthday;
    }

    public void setLegalRepresentativeBirthday(long legalRepresentativeBirthday) {
        this.LegalRepresentativeBirthday = legalRepresentativeBirthday;
    }

    public CountryIso getLegalRepresentativeNationality() {
        return LegalRepresentativeNationality;
    }

    public void setLegalRepresentativeNationality(CountryIso legalRepresentativeNationality) {
        this.LegalRepresentativeNationality = legalRepresentativeNationality;
    }

    public CountryIso getLegalRepresentativeCountryOfResidence() {
        return LegalRepresentativeCountryOfResidence;
    }

    public void setLegalRepresentativeCountryOfResidence(CountryIso legalRepresentativeCountryOfResidence) {
        this.LegalRepresentativeCountryOfResidence = legalRepresentativeCountryOfResidence;
    }

    public String getStatute() {
        return Statute;
    }

    public void setStatute(String statute) {
        this.Statute = statute;
    }

    public String getProofOfRegistration() {
        return ProofOfRegistration;
    }

    public void setProofOfRegistration(String proofOfRegistration) {
        this.ProofOfRegistration = proofOfRegistration;
    }

    public String getShareholderDeclaration() {
        return ShareholderDeclaration;
    }

    public void setShareholderDeclaration(String shareholderDeclaration) {
        this.ShareholderDeclaration = shareholderDeclaration;
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
