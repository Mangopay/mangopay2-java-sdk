package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.interfaces.PayOutPaymentDetails;

/**
 * Class representing the BankWire type for mean of payment in PayOut entity.
 */
public class PayOutPaymentDetailsBankWire extends Dto implements PayOutPaymentDetails {

    /**
     * Bank account identifier.
     *
     * @deprecated Use {@link #getBankAccountId()} and {@link #setBankAccountId(String)} instead.
     */
    @Deprecated
    public String BankAccountId;

    /**
     * Bank wire reference.
     *
     * @deprecated Use {@link #getBankWireRef()} and {@link #setBankWireRef(String)} instead.
     */
    @Deprecated
    public String BankWireRef;

    public PayOutPaymentDetailsBankWire() {
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId) {
        this.BankAccountId = bankAccountId;
    }

    public static PayOutPaymentDetailsBankWire build(String bankAccountId) {
        return new PayOutPaymentDetailsBankWire(bankAccountId);
    }

    public PayOutPaymentDetailsBankWire(String bankAccountId, String bankWireRef) {
        this.BankAccountId = bankAccountId;
        this.BankWireRef = bankWireRef;
    }

    public String getBankAccountId() {
        return BankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.BankAccountId = bankAccountId;
    }

    public String getBankWireRef() {
        return BankWireRef;
    }

    public void setBankWireRef(String bankWireRef) {
        this.BankWireRef = bankWireRef;
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
