package com.mangopay.entities;

import com.mangopay.core.Address;
import com.mangopay.core.enumerations.CountryIso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import static com.mangopay.core.enumerations.PersonType.NATURAL;

/**
 * UserNatural entity.
 */
public final class UserNatural extends User {

    /**
     * First name.
     *
     * @deprecated Use {@link #getFirstName()} and {@link #setFirstName(String)} instead.
     */
    @Deprecated
    public String FirstName;

    /**
     * Last name.
     *
     * @deprecated Use {@link #getLastName()} and {@link #setLastName(String)} instead.
     */
    @Deprecated
    public String LastName;

    /**
     * Address.
     *
     * @deprecated Use {@link #getAddress()} and {@link #setAddress(com.mangopay.core.Address)} instead.
     */
    @Deprecated
    public Address Address;

    /**
     * Date of birth (UNIX timestamp).
     *
     * @deprecated Use {@link #getBirthday()} and {@link #setBirthday(long)} instead.
     */
    @Deprecated
    public long Birthday;

    /**
     * Place of birth.
     *
     * @deprecated Use {@link #getBirthplace()} and {@link #getBirthplace()} instead.
     */
    @Deprecated
    public String Birthplace;

    /**
     * User's country.
     *
     * @deprecated Use {@link #getNationality()} and {@link #setNationality(CountryIso)} instead.
     */
    @Deprecated
    public CountryIso Nationality;

    /**
     * Country of residence.
     *
     * @deprecated Use {@link #getCountryOfResidence()} and {@link #setCountryOfResidence(CountryIso)} instead.
     */
    @Deprecated
    public CountryIso CountryOfResidence;

    /**
     * User's occupation.
     *
     * @deprecated Use {@link #getOccupation()} and {@link #setOccupation(String)} instead.
     */
    @Deprecated
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
     *
     * @deprecated Use {@link #getIncomeRange()} and {@link #setIncomeRange(Integer)} instead.
     */
    @Deprecated
    public Integer IncomeRange;

    /**
     * Proof of identity.
     *
     * @deprecated Use {@link #getProofOfIdentity()} and {@link #setProofOfIdentity(String)} instead.
     */
    @Deprecated
    protected String ProofOfIdentity;

    /**
     * Proof of address.
     *
     * @deprecated Use {@link #getProofOfAddress()} and {@link #setProofOfAddress(String)} instead.
     */
    @Deprecated
    protected String ProofOfAddress;

    /**
     * Instantiates new UserNatural object.
     */
    public UserNatural() {
        this.PersonType = NATURAL;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public com.mangopay.core.Address getAddress() {
        return Address;
    }

    public void setAddress(com.mangopay.core.Address address) {
        this.Address = address;
    }

    public long getBirthday() {
        return Birthday;
    }

    public void setBirthday(long birthday) {
        this.Birthday = birthday;
    }

    public String getBirthplace() {
        return Birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.Birthplace = birthplace;
    }

    public CountryIso getNationality() {
        return Nationality;
    }

    public void setNationality(CountryIso nationality) {
        this.Nationality = nationality;
    }

    public CountryIso getCountryOfResidence() {
        return CountryOfResidence;
    }

    public void setCountryOfResidence(CountryIso countryOfResidence) {
        this.CountryOfResidence = countryOfResidence;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        this.Occupation = occupation;
    }

    public Integer getIncomeRange() {
        return IncomeRange;
    }

    public void setIncomeRange(Integer incomeRange) {
        this.IncomeRange = incomeRange;
    }

    public String getProofOfIdentity() {
        return ProofOfIdentity;
    }

    public void setProofOfIdentity(String proofOfIdentity) {
        this.ProofOfIdentity = proofOfIdentity;
    }

    public String getProofOfAddress() {
        return ProofOfAddress;
    }

    public void setProofOfAddress(String proofOfAddress) {
        this.ProofOfAddress = proofOfAddress;
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
