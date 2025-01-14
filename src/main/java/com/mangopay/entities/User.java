package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.KycLevel;
import com.mangopay.core.enumerations.PersonType;
import com.mangopay.core.enumerations.UserCategory;

import java.util.ArrayList;

/**
 * User entity abstract class.
 * Parent for <code>UserNatural</code> or <code>UserLegal</code> child types.
 */
public abstract class User extends EntityBase {

    /**
     * Type of user.
     */
    @SerializedName("PersonType")
    PersonType personType;

    /**
     * KYC level.
     */
    @SerializedName("KYCLevel")
    private KycLevel kycLevel;

    /**
     * Email address.
     */
    @SerializedName("Email")
    private String email;

    @SerializedName("TermsAndConditionsAccepted")
    private Boolean termsAndConditionsAccepted;

    /**
     * TermsAndConditionsAcceptedDate (UNIX timestamp).
     */
    @SerializedName("TermsAndConditionsAcceptedDate")
    private long termsAndConditionsAcceptedDate;

    @SerializedName("UserCategory")
    private UserCategory userCategory;

    /**
     * The status of the user.
     */
    @SerializedName("UserStatus")
    private String userStatus;

    @SerializedName("PhoneNumber")
    private String phoneNumber;

    @SerializedName("PhoneNumberCountry")
    private CountryIso phoneNumberCountry;

    public User(PersonType personType) {
        this.personType = personType;
    }

    /**
     * Descendant classes overrides it.
     */
    protected User() {
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public KycLevel getKycLevel() {
        return kycLevel;
    }

    public void setKycLevel(KycLevel kycLevel) {
        this.kycLevel = kycLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isTermsAndConditionsAccepted() {
        return termsAndConditionsAccepted;
    }

    public void setTermsAndConditionsAccepted(Boolean termsAndConditionsAccepted) {
        this.termsAndConditionsAccepted = termsAndConditionsAccepted;
    }

    public long getTermsAndConditionsAcceptedDate() {
        return termsAndConditionsAcceptedDate;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public Boolean getTermsAndConditionsAccepted() {
        return termsAndConditionsAccepted;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CountryIso getPhoneNumberCountry() {
        return phoneNumberCountry;
    }

    public void setPhoneNumberCountry(CountryIso phoneNumberCountry) {
        this.phoneNumberCountry = phoneNumberCountry;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("PersonType");
        result.add("KYCLevel");
        result.add("TermsAndConditionsAcceptedDate");

        return result;
    }
}
