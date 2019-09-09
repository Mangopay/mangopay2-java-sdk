package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInExecutionDetails;
import com.mangopay.entities.DebitedBankAccount;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Payment details for banking alias pay-in.
 */
public class PayInExecutionDetailsBankingAlias extends Dto implements PayInExecutionDetails {

    /**
     * ID of the banking alias.
     */
    @SerializedName("BankingAliasId")
    private String BankingAliasId;

    /**
     * Wire reference.
     */
    @SerializedName("WireReference")
    private String WireReference;

    /**
     * Debited bank account details.
     */
    @SerializedName("DebitedBankAccount")
    private DebitedBankAccount DebitedBankAccount;

    public PayInExecutionDetailsBankingAlias(String bankingAliasId, String wireReference, com.mangopay.entities.DebitedBankAccount debitedBankAccount) {
        BankingAliasId = bankingAliasId;
        WireReference = wireReference;
        DebitedBankAccount = debitedBankAccount;
    }

    public String getBankingAliasId() {
        return BankingAliasId;
    }

    public void setBankingAliasId(String bankingAliasId) {
        this.BankingAliasId = bankingAliasId;
    }

    public String getWireReference() {
        return WireReference;
    }

    public void setWireReference(String wireReference) {
        this.WireReference = wireReference;
    }

    public DebitedBankAccount getDebitedBankAccount() {
        return DebitedBankAccount;
    }

    public void setDebitedBankAccount(DebitedBankAccount debitedBankAccount) {
        this.DebitedBankAccount = debitedBankAccount;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        HashMap<String, Type> result = new HashMap<>();

        result.put("DebitedBankAccount", DebitedBankAccount.class);

        return result;
    }
}
