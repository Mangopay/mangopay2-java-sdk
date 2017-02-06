package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.KycLevel;
import com.mangopay.core.enumerations.PersonType;

import java.util.ArrayList;

/**
 * User entity abstract class.
 * Parent for <code>UserNatural</code> or <code>UserLegal</code> child types.
 */
public abstract class User extends EntityBase {

    /**
     * Type of user.
     *
     * @deprecated Use {@link #getPersonType()} and {@link #setPersonType(PersonType)} instead.
     */
    @Deprecated
    public PersonType PersonType;

    /**
     * KYC level.
     *
     * @deprecated Use {@link #getKYCLevel()} and {@link #setKYCLevel(KycLevel)} instead.
     */
    @Deprecated
    public KycLevel KYCLevel;

    /**
     * Email address.
     *
     * @deprecated Use {@link #getEmail()} and {@link #setEmail(String)} instead.
     */
    @Deprecated
    public String Email;

    public User(PersonType personType) {
        PersonType = personType;
    }

    /**
     * Descendant classes override it.
     */
    protected User() {
    }

    public com.mangopay.core.enumerations.PersonType getPersonType() {
        return PersonType;
    }

    public void setPersonType(com.mangopay.core.enumerations.PersonType personType) {
        this.PersonType = personType;
    }

    public KycLevel getKYCLevel() {
        return KYCLevel;
    }

    public void setKYCLevel(KycLevel KYCLevel) {
        this.KYCLevel = KYCLevel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
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

        return result;
    }
}
