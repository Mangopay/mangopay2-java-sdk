package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

/**
 * WARNING!
 * This is temporary entity and will be removed in future.
 * Contact support before using these features or if have any queries.
 * <p>
 * TemporaryImmediatePayIn entity.
 */
public class TemporaryImmediatePayIn extends Transaction {

    /**
     * Payment card identifier.
     */
    @SerializedName("PaymentCardId")
    private String paymentCardId;

    /**
     * Credited wallet identifier.
     */
    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    public String getPaymentCardId() {
        return paymentCardId;
    }

    public void setPaymentCardId(String paymentCardId) {
        this.paymentCardId = paymentCardId;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }
}
