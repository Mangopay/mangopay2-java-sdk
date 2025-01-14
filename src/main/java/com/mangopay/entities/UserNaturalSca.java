package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.NaturalUserCapacity;
import com.mangopay.entities.subentities.PendingUserAction;

import static com.mangopay.core.enumerations.PersonType.NATURAL;

/**
 * UserNatural entity.
 */
public final class UserNaturalSca extends User {

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
     * Income range. One of UserNatural.IncomeRanges constants.
     */
    @SerializedName("IncomeRange")
    private Integer incomeRange;

    /**
     * Proof of identity.
     */
    @SerializedName("ProofOfIdentity")
    private String proofOfIdentity;

    /**
     * Proof of address.
     */
    @SerializedName("ProofOfAddress")
    private String proofOfAddress;

    /**
     * Capacity of the user within MangoPay.
     */
    @SerializedName("Capacity")
    private NaturalUserCapacity capacity;

    /**
     * Information about the action required from the user if UserStatus is PENDING_USER_ACTION (otherwise returned null).
     */
    @SerializedName("PendingUserAction")
    private PendingUserAction pendingUserAction;

    /**
     * Instantiates new UserNaturalSca object.
     */
    public UserNaturalSca() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public NaturalUserCapacity getCapacity() {
        return capacity;
    }

    public void setCapacity(NaturalUserCapacity capacity) {
        this.capacity = capacity;
    }

    public PendingUserAction getPendingUserAction() {
        return pendingUserAction;
    }

    public void setPendingUserAction(PendingUserAction pendingUserAction) {
        this.pendingUserAction = pendingUserAction;
    }
}
