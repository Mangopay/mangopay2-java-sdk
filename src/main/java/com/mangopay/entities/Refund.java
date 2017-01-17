package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getInitialTransactionId()} and {@link #setInitialTransactionId(String)} instead.
     */
    @Deprecated
    public String InitialTransactionId;

    /**
     * Initial transaction type.
     *
     * @deprecated Use {@link #getInitialTransactionType()} and {@link #setInitialTransactionType(InitialTransactionType)} instead.
     */
    @Deprecated
    public InitialTransactionType InitialTransactionType;

    /**
     * Debited wallet identifier.
     *
     * @deprecated Use {@link #getDebitedWalletId()} and {@link #setDebitedWalletId(String)} instead.
     */
    @Deprecated
    public String DebitedWalletId;

    /**
     * Credited wallet identifier.
     *
     * @deprecated Use {@link #getCreditedWalletId()} and {@link #setCreditedWalletId(String)} instead.
     */
    @Deprecated
    public String CreditedWalletId;

    /**
     * Contains info about the reason for refund.
     *
     * @deprecated Use {@link #getRefundReason()} and {@link #setRefundReason(RefundReason)} instead.
     */
    @Deprecated
    public RefundReason RefundReason;

    public String getInitialTransactionId() {
        return InitialTransactionId;
    }

    public void setInitialTransactionId(String initialTransactionId) {
        this.InitialTransactionId = initialTransactionId;
    }

    public InitialTransactionType getInitialTransactionType() {
        return InitialTransactionType;
    }

    public void setInitialTransactionType(InitialTransactionType initialTransactionType) {
        this.InitialTransactionType = initialTransactionType;
    }

    public String getDebitedWalletId() {
        return DebitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.DebitedWalletId = debitedWalletId;
    }

    public String getCreditedWalletId() {
        return CreditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.CreditedWalletId = creditedWalletId;
    }

    public com.mangopay.core.RefundReason getRefundReason() {
        return RefundReason;
    }

    public void setRefundReason(com.mangopay.core.RefundReason refundReason) {
        this.RefundReason = refundReason;
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
