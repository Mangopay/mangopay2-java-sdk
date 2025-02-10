package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.RefundReason;
import com.mangopay.core.enumerations.InitialTransactionType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Refund entity.
 */
public class Refund extends Transaction {

    /**
     * Initial transaction identifier.
     */
    @SerializedName("InitialTransactionId")
    private String initialTransactionId;

    /**
     * Initial transaction type.
     */
    @SerializedName("InitialTransactionType")
    private InitialTransactionType initialTransactionType;

    /**
     * Debited wallet identifier.
     */
    @SerializedName("DebitedWalletId")
    private String debitedWalletId;

    /**
     * Credited wallet identifier.
     */
    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    /**
     * Contains info about the reason for refund.
     */
    @SerializedName("RefundReason")
    private RefundReason refundReason;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    public String getInitialTransactionId() {
        return initialTransactionId;
    }

    public void setInitialTransactionId(String initialTransactionId) {
        this.initialTransactionId = initialTransactionId;
    }

    public InitialTransactionType getInitialTransactionType() {
        return initialTransactionType;
    }

    public void setInitialTransactionType(InitialTransactionType initialTransactionType) {
        this.initialTransactionType = initialTransactionType;
    }

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }

    public com.mangopay.core.RefundReason getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(com.mangopay.core.RefundReason refundReason) {
        this.refundReason = refundReason;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public Refund setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        Map<String, Type> result = super.getSubObjects();

        result.put("RefundReason", RefundReason.class);

        return result;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("InitialTransactionType");
        result.add("RefundReason");

        return result;
    }
}
