package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.ObjectTool;
import com.mangopay.core.interfaces.IPayOutPaymentDetails;

/**
 * Class representing the BankWire type for mean of payment in PayOut entity.
 */
public class PayOutPaymentDetailsBankWire extends Dto implements IPayOutPaymentDetails {
    
    /**
     * Bank account identifier.
     */
    public String BankAccountId;
    
    /**
     * Bank wire reference.
     */
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
    
    public static PayOutPaymentDetailsBankWire build(String bankAccountId, String bankWireRef) {
        return new PayOutPaymentDetailsBankWire(bankAccountId, bankWireRef);
    }
    
    public static PayOutPaymentDetailsBankWire convert(IPayOutPaymentDetails payOutPaymentDetails) throws Exception {
        if (ObjectTool.isNull(payOutPaymentDetails)) {
            throw new Exception("IPayOutPaymentDetails null value");
        } else if (payOutPaymentDetails  instanceof PayOutPaymentDetailsBankWire) {
            return (PayOutPaymentDetailsBankWire) payOutPaymentDetails;
        } else {
            throw new Exception("IPayOutPaymentDetails instance isn't PayOutPaymentDetailsBankWire instance");
        }
    }
    
    
}
