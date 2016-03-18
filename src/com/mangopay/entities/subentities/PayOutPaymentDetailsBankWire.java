package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
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
}
