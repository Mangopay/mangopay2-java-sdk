package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.BankAccountType;
import com.mangopay.core.interfaces.BankAccountDetails;
import com.mangopay.entities.subentities.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Bank Account entity.
 */
public class BankAccount extends EntityBase {

    /**
     * User identifier.
     */
    @SerializedName("UserId")
    private String userId;

    /**
     * Type of bank account.
     */
    @SerializedName("Type")
    private BankAccountType type;

    /**
     * Owner name.
     */
    @SerializedName("OwnerName")
    private String ownerName;

    /**
     * Owner address.
     */
    @SerializedName("OwnerAddress")
    private Address ownerAddress;

    /**
     * Denotes whether bank account is active or not.
     */
    @SerializedName("Active")
    private Boolean active;

    /**
     * One of BankAccountDetails implementations, depending on Type.
     */
    @SerializedName("Details")
    private BankAccountDetails details;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BankAccountType getType() {
        return type;
    }

    public void setType(BankAccountType type) {
        this.type = type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Address getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public BankAccountDetails getDetails() {
        return details;
    }

    public void setDetails(BankAccountDetails details) {
        this.details = details;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("OwnerAddress", Address.class);

        return result;
    }

    /**
     * Gets the structure that maps which property depends on other property.
     *
     * @return
     */
    @Override
    public Map<String, Map<String, Map<String, Class<?>>>> getDependentObjects() {

        return new HashMap<String, Map<String, Map<String, Class<?>>>>() {{
            put("Type", new HashMap<String, Map<String, Class<?>>>() {{
                        put("IBAN", new HashMap<String, Class<?>>() {{
                                    put("Details", BankAccountDetailsIBAN.class);
                                }}
                        );
                        put("GB", new HashMap<String, Class<?>>() {{
                                    put("Details", BankAccountDetailsGB.class);
                                }}
                        );
                        put("US", new HashMap<String, Class<?>>() {{
                                    put("Details", BankAccountDetailsUS.class);
                                }}
                        );
                        put("CA", new HashMap<String, Class<?>>() {{
                                    put("Details", BankAccountDetailsCA.class);
                                }}
                        );
                        put("OTHER", new HashMap<String, Class<?>>() {{
                                    put("Details", BankAccountDetailsOTHER.class);
                                }}
                        );
                        // ...and more in future...
                    }}
            );
        }};
    }

    /**
     * Gets the collection of read-only fields names
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("UserId");
        result.add("Type");
        result.add("Active");

        return result;
    }
}
