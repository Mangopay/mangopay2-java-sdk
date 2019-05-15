package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.FundsType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Wallet entity.
 */
public class Wallet extends EntityBase {

    /**
     * Collection of owners identifiers.
     */
    @SerializedName("Owners")
    private ArrayList<String> owners;

    /**
     * Wallet description.
     */
    @SerializedName("Description")
    private String description;

    /**
     * Money in wallet.
     */
    @SerializedName("Balance")
    private Money balance;

    /**
     * Currency.
     */
    @SerializedName("Currency")
    private CurrencyIso currency;

    /**
     * The funds usage type.
     */
    @SerializedName("FundsType")
    private FundsType fundsType;

    public ArrayList<String> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<String> owners) {
        this.owners = owners;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public CurrencyIso getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.currency = currency;
    }

    public FundsType getFundsType() {
        return fundsType;
    }

    public void setFundsType(FundsType fundsType) {
        this.fundsType = fundsType;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        return new HashMap<String, Type>() {{
            put("Balance", Money.class);
        }};
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("Balance");

        return result;
    }

}
