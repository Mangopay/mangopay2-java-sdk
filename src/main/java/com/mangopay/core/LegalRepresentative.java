package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.CountryIso;

/**
 * Introduced with SCA
 * Holds data for the LegalRepresentative of a UserLegal entity
 */
public class LegalRepresentative extends Dto {

    @SerializedName("FirstName")
    private String firstName;

    @SerializedName("LastName")
    private String lastName;

    @SerializedName("ProofOfIdentity")
    private String proofOfIdentity;

    @SerializedName("Email")
    private String email;

    @SerializedName("Birthday")
    private Long birthday;

    @SerializedName("Nationality")
    private CountryIso nationality;

    @SerializedName("CountryOfResidence")
    private CountryIso countryOfResidence;

    @SerializedName("PhoneNumber")
    private String phoneNumber;

    @SerializedName("PhoneNumberCountry")
    private CountryIso phoneNumberCountry;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
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

    public String getProofOfIdentity() {
        return proofOfIdentity;
    }

    public void setProofOfIdentity(String proofOfIdentity) {
        this.proofOfIdentity = proofOfIdentity;
    }

    public Boolean allFieldsNull() {
        return firstName == null &&
                lastName == null &&
            proofOfIdentity == null &&
                email == null &&
                birthday == null &&
                nationality == null &&
                countryOfResidence == null &&
                phoneNumber == null &&
                phoneNumberCountry == null;
    }
}
