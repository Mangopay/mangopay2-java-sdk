package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.BankingAliasType;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.interfaces.BankingAliasDetails;
import com.mangopay.entities.subentities.BankingAliasDetailsIBAN;

import java.util.HashMap;
import java.util.Map;

/**
 * Banking alias entity.
 */
public class BankingAlias extends EntityBase {

    /**
     * The user ID who was credited.
     */
    @SerializedName("CreditedUserId")
    private String creditedUserId;

    /**
     * The ID of the wallet.
     */
    @SerializedName("WalletId")
    private String walletId;

    /**
     * The name of the owner of the bank account.
     */
    @SerializedName("OwnerName")
    private String ownerName;

    /**
     * The type of banking alias.
     */
    @SerializedName("Type")
    private BankingAliasType type;

    /**
     * The country format for the banking alias.
     */
    @SerializedName("Country")
    private CountryIso country;

    /**
     * Whether the banking alias is active or not.
     */
    @SerializedName("Active")
    private boolean active;

    /**
     * type-specific details of the banking alias.
     */
    @SerializedName("Details")
    private BankingAliasDetails details;

    public String getCreditedUserId() {
        return creditedUserId;
    }

    public void setCreditedUserId(String creditedUserId) {
        this.creditedUserId = creditedUserId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BankingAliasType getType() {
        return type;
    }

    public void setType(BankingAliasType type) {
        this.type = type;
    }

    public CountryIso getCountry() {
        return country;
    }

    public void setCountry(CountryIso country) {
        this.country = country;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BankingAliasDetails getDetails() {
        return details;
    }

    public void setDetails(BankingAliasDetails details) {
        this.details = details;
    }

    /**
     * Gets the structure that maps which property depends on other property.
     *
     * @return
     */
    @Override
    public Map<String, Map<String, Map<String, Class<?>>>> getDependentObjects() {
        return new HashMap<String, Map<String, Map<String, Class<?>>>>() {{
            put("type", new HashMap<String, Map<String, Class<?>>>() {{
                        put("IBAN", new HashMap<String, Class<?>>() {{
                                    put("details", BankingAliasDetailsIBAN.class);
                                }}
                        );
                        // ...and more in future...
                    }}
            );
        }};
    }
}
