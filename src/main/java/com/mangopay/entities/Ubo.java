package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.CountryIso;

import java.lang.reflect.Type;
import java.util.Map;

public class Ubo extends EntityBase {

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
     * Nationality.
     */
    @SerializedName("Nationality")
    private CountryIso nationality;

    /**
     * Birthday.
     */
    @SerializedName("Birthday")
    private long birthday;

    /**
     * Birthplace.
     */
    @SerializedName("Birthplace")
    private Birthplace birthplace;

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public CountryIso getNationality() { return nationality; }

    public void setNationality(CountryIso nationality) { this.nationality = nationality; }

    public long getBirthday() { return birthday; }

    public void setBirthday(long birthday) { this.birthday = birthday; }

    public Birthplace getBirthplace() { return birthplace; }

    public void setBirthplace(Birthplace birthplace) { this.birthplace = birthplace; }

    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("Address", Address.class);
        result.put("Birthplace", Birthplace.class);

        return result;
    }

}
