package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.Money;
import com.mangopay.core.interfaces.PayInPaymentDetails;
import com.mangopay.entities.BankAccount;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing the BankWire type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsBankWire extends Dto implements PayInPaymentDetails {

    /**
     * Declared debited funds.
     *
     * @deprecated Use {@link #getDeclaredDebitedFunds()} and {@link #setDeclaredDebitedFunds(Money)} instead.
     */
    @Deprecated
    public Money DeclaredDebitedFunds;

    /**
     * Declared fees.
     *
     * @deprecated Use {@link #getDeclaredFees()} and {@link #setDeclaredFees(Money)} instead.
     */
    @Deprecated
    public Money DeclaredFees;

    /**
     * Bank account details.
     *
     * @deprecated Use {@link #getBankAccount()} and {@link #setBankAccount(BankAccount)} instead.
     */
    @Deprecated
    public BankAccount BankAccount;

    /**
     * Wire reference.
     *
     * @deprecated Use {@link #getWireReference()} and {@link #setWireReference(String)} instead.
     */
    @Deprecated
    public String WireReference;

    public Money getDeclaredDebitedFunds() {
        return DeclaredDebitedFunds;
    }

    public void setDeclaredDebitedFunds(Money declaredDebitedFunds) {
        this.DeclaredDebitedFunds = declaredDebitedFunds;
    }

    public Money getDeclaredFees() {
        return DeclaredFees;
    }

    public void setDeclaredFees(Money declaredFees) {
        this.DeclaredFees = declaredFees;
    }

    public BankAccount getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.BankAccount = bankAccount;
    }

    public String getWireReference() {
        return WireReference;
    }

    public void setWireReference(String wireReference) {
        this.WireReference = wireReference;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        HashMap<String, Type> result = new HashMap<>();

        result.put("DeclaredDebitedFunds", Money.class);
        result.put("DeclaredFees", Money.class);
        result.put("BankAccount", BankAccount.class);

        return result;
    }
}
