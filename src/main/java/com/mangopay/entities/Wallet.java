package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getOwners()} and {@link #setOwners(ArrayList)} instead.
     */
    @Deprecated
    public ArrayList<String> Owners;

    /**
     * Wallet description.
     *
     * @deprecated Use {@link #getDescription()} and {@link #setDescription(String)} instead.
     */
    @Deprecated
    public String Description;

    /**
     * Money in wallet.
     *
     * @deprecated Use {@link #getBalance()} and {@link #setBalance(Money)} instead.
     */
    @Deprecated
    public Money Balance;

    /**
     * Currency.
     *
     * @deprecated Use {@link #getCurrency()} and {@link #setCurrency(CurrencyIso)} instead.
     */
    @Deprecated
    public CurrencyIso Currency;

    /**
     * The funds usage type.
     *
     * @deprecated Use {@link #getFundsType()} and {@link #setFundsType(com.mangopay.core.enumerations.FundsType)} instead.
     */
    @Deprecated
    public FundsType FundsType;

    public ArrayList<String> getOwners() {
        return Owners;
    }

    public void setOwners(ArrayList<String> owners) {
        this.Owners = owners;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public Money getBalance() {
        return Balance;
    }

    public void setBalance(Money balance) {
        this.Balance = balance;
    }

    public CurrencyIso getCurrency() {
        return Currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.Currency = currency;
    }

    public com.mangopay.core.enumerations.FundsType getFundsType() {
        return FundsType;
    }

    public void setFundsType(com.mangopay.core.enumerations.FundsType fundsType) {
        this.FundsType = fundsType;
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
