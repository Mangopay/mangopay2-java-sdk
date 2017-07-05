package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.enumerations.CountryIso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import static com.mangopay.core.enumerations.PersonType.NATURAL;

/**
 * UserNatural entity.
 */
public class UserNatural extends User {

    /**
     * First name.
     */
    @SerializedName("FirstName")
    private String firstName;

    /**
     * Last name.
     */
    @SerializedName("LastName")
    private String lastName;

    /**
     * Address.
     */
    @SerializedName("Address")
    private Address address;

    /**
     * Date of birth (UNIX timestamp).
     */
    @SerializedName("Birthday")
    private long birthday;

    /**
     * Place of birth.
     */
    @SerializedName("Birthplace")
    private String birthplace;

    /**
     * User's country.
     */
    @SerializedName("Nationality")
    private CountryIso nationality;

    /**
     * Country of residence.
     */
    @SerializedName("CountryOfResidence")
    private CountryIso countryOfResidence;

    /**
     * User's occupation.
     */
    @SerializedName("Occupation")
    private String occupation;

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
    @SerializedName("IncomeRange")
    private Integer incomeRange;

    /**
     * Proof of identity.
     */
    @SerializedName("ProofOfIdentity")
    protected String proofOfIdentity;

    /**
     * Proof of address.
     */
    @SerializedName("ProofOfAddress")
    protected String proofOfAddress;

    /**
     * Instantiates new UserNatural object.
     */
    public UserNatural() {
        this.personType = NATURAL;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public com.mangopay.core.Address getAddress() {
        return address;
    }

    public void setAddress(com.mangopay.core.Address address) {
        this.address = address;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public CountryIso getNationality() {
        return nationality;
    }

    public void setNationality(CountryIso nationality) {
        this.nationality = nationality;
    }

    public CountryIso getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(CountryIso countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getIncomeRange() {
        return incomeRange;
    }

    public void setIncomeRange(Integer incomeRange) {
        this.incomeRange = incomeRange;
    }

    public String getProofOfIdentity() {
        return proofOfIdentity;
    }

    public void setProofOfIdentity(String proofOfIdentity) {
        this.proofOfIdentity = proofOfIdentity;
    }

    public String getProofOfAddress() {
        return proofOfAddress;
    }

    public void setProofOfAddress(String proofOfAddress) {
        this.proofOfAddress = proofOfAddress;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
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
     *
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
