package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.LegalPersonType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import static com.mangopay.core.enumerations.PersonType.LEGAL;

/**
 * Compatibility version of {@link UserLegal}.
 * Created by thepa on 05-Jul-17.
 */
public class LegacyUserLegal extends User {

    /**
     * Name of this user.
     */
    @SerializedName("Name")
    private String name;

    /**
     * Type of legal user.
     */
    @SerializedName("LegalPersonType")
    private LegalPersonType legalPersonType;

    /**
     * Headquarters address.
     */
    @SerializedName("HeadquartersAddress")
    private String headquartersAddress;

    /**
     * Legal representative first name.
     */
    @SerializedName("LegalRepresentativeFirstName")
    private String legalRepresentativeFirstName;

    /**
     * Legal representative last name.
     */
    @SerializedName("LegalRepresentativeLastName")
    private String legalRepresentativeLastName;

    /**
     * Legal representative address.
     */
    @SerializedName("LegalRepresentativeAddress")
    private String legalRepresentativeAddress;

    /**
     * Legal representative email.
     */
    @SerializedName("LegalRepresentativeEmail")
    private String legalRepresentativeEmail;

    /**
     * Legal representative birthday.
     */
    @SerializedName("LegalRepresentativeBirthday")
    private long legalRepresentativeBirthday;

    /**
     * Legal representative nationality.
     */
    @SerializedName("LegalRepresentativeNationality")
    private CountryIso legalRepresentativeNationality;

    /**
     * Legal representative country of residence.
     */
    @SerializedName("LegalRepresentativeCountryOfResidence")
    private CountryIso legalRepresentativeCountryOfResidence;

    /**
     * Statute.
     */
    @SerializedName("Statute")
    private String statute;

    /**
     * Proof of registration.
     */
    @SerializedName("ProofOfRegistration")
    private String proofOfRegistration;

    /**
     * Shareholder declaration.
     */
    @SerializedName("ShareholderDeclaration")
    public String shareholderDeclaration;

    /**
     * Instantiates new LegacyUserLegal object.
     */
    public LegacyUserLegal() {
        this.personType = LEGAL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LegalPersonType getLegalPersonType() {
        return legalPersonType;
    }

    public void setLegalPersonType(LegalPersonType legalPersonType) {
        this.legalPersonType = legalPersonType;
    }

    public String getHeadquartersAddress() {
        return headquartersAddress;
    }

    public void setHeadquartersAddress(String headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    public String getLegalRepresentativeFirstName() {
        return legalRepresentativeFirstName;
    }

    public void setLegalRepresentativeFirstName(String legalRepresentativeFirstName) {
        this.legalRepresentativeFirstName = legalRepresentativeFirstName;
    }

    public String getLegalRepresentativeLastName() {
        return legalRepresentativeLastName;
    }

    public void setLegalRepresentativeLastName(String legalRepresentativeLastName) {
        this.legalRepresentativeLastName = legalRepresentativeLastName;
    }

    public String getLegalRepresentativeAddress() {
        return legalRepresentativeAddress;
    }

    public void setLegalRepresentativeAddress(String legalRepresentativeAddress) {
        this.legalRepresentativeAddress = legalRepresentativeAddress;
    }

    public String getLegalRepresentativeEmail() {
        return legalRepresentativeEmail;
    }

    public void setLegalRepresentativeEmail(String legalRepresentativeEmail) {
        this.legalRepresentativeEmail = legalRepresentativeEmail;
    }

    public long getLegalRepresentativeBirthday() {
        return legalRepresentativeBirthday;
    }

    public void setLegalRepresentativeBirthday(long legalRepresentativeBirthday) {
        this.legalRepresentativeBirthday = legalRepresentativeBirthday;
    }

    public CountryIso getLegalRepresentativeNationality() {
        return legalRepresentativeNationality;
    }

    public void setLegalRepresentativeNationality(CountryIso legalRepresentativeNationality) {
        this.legalRepresentativeNationality = legalRepresentativeNationality;
    }

    public CountryIso getLegalRepresentativeCountryOfResidence() {
        return legalRepresentativeCountryOfResidence;
    }

    public void setLegalRepresentativeCountryOfResidence(CountryIso legalRepresentativeCountryOfResidence) {
        this.legalRepresentativeCountryOfResidence = legalRepresentativeCountryOfResidence;
    }

    public String getStatute() {
        return statute;
    }

    public void setStatute(String statute) {
        this.statute = statute;
    }

    public String getProofOfRegistration() {
        return proofOfRegistration;
    }

    public void setProofOfRegistration(String proofOfRegistration) {
        this.proofOfRegistration = proofOfRegistration;
    }

    public String getShareholderDeclaration() {
        return shareholderDeclaration;
    }

    public void setShareholderDeclaration(String shareholderDeclaration) {
        this.shareholderDeclaration = shareholderDeclaration;
    }

    /**
     * Gets the collection of read-only fields names.
     *
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
