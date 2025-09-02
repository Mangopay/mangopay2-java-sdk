package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.enumerations.PayoutMode;
import com.mangopay.core.interfaces.PayOutPaymentDetails;

/**
 * Class representing the BankWire type for mean of payment in PayOut entity.
 */
public class PayOutPaymentDetailsBankWire extends Dto implements PayOutPaymentDetails {
    /**
     * Bank account identifier.
     */
    @SerializedName("BankAccountId")
    private String bankAccountId;

    /**
     * Bank wire reference.
     */
    @SerializedName("BankWireRef")
    private String bankWireRef;

    /**
     * Payment reference provided for the payout.
     */
    @SerializedName("PaymentRef")
    private PayOutPaymentRef paymentRef;

    /**
     * The requested payout mode.
     */
    @SerializedName("PayoutModeRequested")
    private PayoutMode payoutModeRequested;

    private String payoutModeApplied;

    @SerializedName("Status")
    private String status;

    @SerializedName("FallbackReason")
    private FallbackReason fallbackReason;

    @SerializedName("RecipientVerificationOfPayee")
    private VerificationOfPayee recipientVerificationOfPayee;

    public PayOutPaymentDetailsBankWire() {
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId, String bankWireRef) {
        this.bankAccountId = bankAccountId;
        this.bankWireRef = bankWireRef;
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId, String bankWireRef, PayoutMode payoutModeRequested) {
        this.bankAccountId = bankAccountId;
        this.bankWireRef = bankWireRef;
        this.payoutModeRequested = payoutModeRequested;
    }

    public static PayOutPaymentDetailsBankWire build(String bankAccountId) {
        return new PayOutPaymentDetailsBankWire(bankAccountId);
    }

    public static PayOutPaymentDetailsBankWire build(String bankAccountId, String bankWireRef) {
        return new PayOutPaymentDetailsBankWire(bankAccountId, bankWireRef);
    }

    public static PayOutPaymentDetailsBankWire build(String bankAccountId, String bankWireRef, PayoutMode payoutModeRequested) {
        return new PayOutPaymentDetailsBankWire(bankAccountId, bankWireRef, payoutModeRequested);
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getBankWireRef() {
        return bankWireRef;
    }

    public void setBankWireRef(String bankWireRef) {
        this.bankWireRef = bankWireRef;
    }

    public PayOutPaymentRef getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(PayOutPaymentRef paymentRef) {
        this.paymentRef = paymentRef;
    }

    public PayoutMode getPayoutModeRequested() {
        return payoutModeRequested;
    }

    public void setPayoutModeRequested(PayoutMode payoutModeRequested) {
        this.payoutModeRequested = payoutModeRequested;
    }

    public String getPayoutModeApplied() { return payoutModeApplied; }

    public void setPayoutModeApplied(String payoutModeApplied) {
        this.payoutModeApplied = payoutModeApplied;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public FallbackReason getFallbackReason() { return fallbackReason; }

    public void setFallbackReason(FallbackReason fallbackReason) {
        this.fallbackReason = fallbackReason;
    }

    public VerificationOfPayee getRecipientVerificationOfPayee() {
        return recipientVerificationOfPayee;
    }

    public PayOutPaymentDetailsBankWire setRecipientVerificationOfPayee(VerificationOfPayee recipientVerificationOfPayee) {
        this.recipientVerificationOfPayee = recipientVerificationOfPayee;
        return this;
    }

    public static PayOutPaymentDetailsBankWire convert(PayOutPaymentDetails payOutPaymentDetails) throws Exception {
        if (ObjectTool.isNull(payOutPaymentDetails)) {
            throw new Exception("PayOutPaymentDetails null value");
        } else if (payOutPaymentDetails instanceof PayOutPaymentDetailsBankWire) {
            return (PayOutPaymentDetailsBankWire) payOutPaymentDetails;
        } else {
            throw new Exception("PayOutPaymentDetails instance isn't PayOutPaymentDetailsBankWire instance");
        }
    }
}
