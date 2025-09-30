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
    public String CreditedUserId;

    /**
     * The ID of the wallet.
     */
    public String WalletId;

    /**
     * The name of the owner of the bank account.
     */
    public String OwnerName;

    /**
     * The type of banking alias.
     */
    public BankingAliasType Type;

    /**
     * The country format for the banking alias.
     */
    public CountryIso Country;

    /**
     * Whether the banking alias is active or not.
     */
    public boolean Active;

    @SerializedName("VirtualAccountPurpose")
    private String virtualAccountPurpose;

    /**
     * Type-specific details of the banking alias.
     */
    public BankingAliasDetails Details;

    @SerializedName("VirtualAccountPurpose")
    private String virtualAccountPurpose;

    public String getCreditedUserId() {
        return CreditedUserId;
    }

    public void setCreditedUserId(String creditedUserId) {
        this.CreditedUserId = creditedUserId;
    }

    public String getWalletId() {
        return WalletId;
    }

    public void setWalletId(String walletId) {
        this.WalletId = walletId;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        this.OwnerName = ownerName;
    }

    public BankingAliasType getType() {
        return Type;
    }

    public void setType(BankingAliasType type) {
        this.Type = type;
    }

    public CountryIso getCountry() {
        return Country;
    }

    public void setCountry(CountryIso country) {
        this.Country = country;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        this.Active = active;
    }

    public BankingAliasDetails getDetails() {
        return Details;
    }

    public void setDetails(BankingAliasDetails details) {
        this.Details = details;
    }

    public String getVirtualAccountPurpose() {
        return virtualAccountPurpose;
    }

    public BankingAlias setVirtualAccountPurpose(String virtualAccountPurpose) {
        this.virtualAccountPurpose = virtualAccountPurpose;
        return this;
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
                                    put("Details", BankingAliasDetailsIBAN.class);
                                }}
                        );
                        // ...and more in future...
                    }}
            );
        }};
    }
}
