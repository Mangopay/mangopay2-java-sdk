package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getPaymentCardId()} and {@link #setPaymentCardId(String)} instead.
     */
    @Deprecated
    public String PaymentCardId;

    /**
     * Credited wallet identifier.
     *
     * @deprecated Use {@link #getCreditedWalletId()} and {@link #setCreditedWalletId(String)} instead.
     */
    @Deprecated
    public String CreditedWalletId;

    public String getPaymentCardId() {
        return PaymentCardId;
    }

    public void setPaymentCardId(String paymentCardId) {
        this.PaymentCardId = paymentCardId;
    }

    public String getCreditedWalletId() {
        return CreditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.CreditedWalletId = creditedWalletId;
    }
}
