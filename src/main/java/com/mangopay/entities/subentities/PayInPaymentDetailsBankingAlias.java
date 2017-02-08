package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;
import com.mangopay.entities.DebitedBankAccount;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Payment details for banking alias pay-in.
 */
public class PayInPaymentDetailsBankingAlias extends Dto implements PayInPaymentDetails {

    /**
     * ID of the banking alias.
     */
    public String BankingAliasId;

    /**
     * Wire reference.
     */
    public String WireReference;

    /**
     * Debited bank account details.
     */
    public DebitedBankAccount DebitedBankAccount;

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
