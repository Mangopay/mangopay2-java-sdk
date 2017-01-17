package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getUserId()} and {@link #setUserId(String)} instead.
     */
    @Deprecated
    public String UserId;

    /**
     * Type of bank account.
     *
     * @deprecated Use {@link #getType()} and {@link #setType(BankAccountType)} instead.
     */
    @Deprecated
    public BankAccountType Type;

    /**
     * Owner name.
     *
     * @deprecated Use {@link #getOwnerName()} and {@link #setOwnerName(String)} instead.
     */
    @Deprecated
    public String OwnerName;

    /**
     * Owner address.
     *
     * @deprecated Use {@link #getOwnerAddress()} and {@link #setOwnerAddress(Address)} instead.
     */
    @Deprecated
    public Address OwnerAddress;

    /**
     * Denotes whether bank account is active or not.
     *
     * @deprecated Use {@link #isActive()} and {@link #setActive(Boolean)} instead.
     */
    @Deprecated
    public Boolean Active;

    /**
     * One of BankAccountDetails implementations, depending on Type.
     *
     * @deprecated Use {@link #getDetails()} and {@link #setDetails(BankAccountDetails)} instead.
     */
    @Deprecated
    public BankAccountDetails Details;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public BankAccountType getType() {
        return Type;
    }

    public void setType(BankAccountType type) {
        this.Type = type;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        this.OwnerName = ownerName;
    }

    public Address getOwnerAddress() {
        return OwnerAddress;
    }

    public void setOwnerAddress(Address ownerAddress) {
        this.OwnerAddress = ownerAddress;
    }

    public Boolean isActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        this.Active = active;
    }

    public BankAccountDetails getDetails() {
        return Details;
    }

    public void setDetails(BankAccountDetails details) {
        this.Details = details;
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
