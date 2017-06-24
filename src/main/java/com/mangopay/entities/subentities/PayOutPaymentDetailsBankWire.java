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

    public PayOutPaymentDetailsBankWire() {
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public static PayOutPaymentDetailsBankWire build(String bankAccountId) {
        return new PayOutPaymentDetailsBankWire(bankAccountId);
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId, String bankWireRef) {
        this.bankAccountId = bankAccountId;
        this.bankWireRef = bankWireRef;
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

    public static PayOutPaymentDetailsBankWire build(String bankAccountId, String bankWireRef) {
        return new PayOutPaymentDetailsBankWire(bankAccountId, bankWireRef);
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
