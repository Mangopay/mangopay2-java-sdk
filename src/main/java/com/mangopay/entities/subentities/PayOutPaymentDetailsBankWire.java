package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
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
     * The requested payout mode. Possible values: INSTANT_PAYMENT or STANDARD
     */
    @SerializedName("PayoutModeRequested")
    private String payoutModeRequested;

    public PayOutPaymentDetailsBankWire() {
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId, String bankWireRef) {
        this.bankAccountId = bankAccountId;
        this.bankWireRef = bankWireRef;
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId, String bankWireRef, String payoutModeRequested) {
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

    public static PayOutPaymentDetailsBankWire build(String bankAccountId, String bankWireRef, String payoutModeRequested) {
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

    public String getPayoutModeRequested() {
        return payoutModeRequested;
    }

    public void setPayoutModeRequested(String payoutModeRequested) {
        this.payoutModeRequested = payoutModeRequested;
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
