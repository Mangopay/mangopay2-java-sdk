package com.mangopay.core;

/**
 * Class representing the BankWire type for mean of payment in PayOut entity.
 */
public class PayOutPaymentDetailsBankWire extends Dto implements IPayOutPaymentDetails {
    
    /**
     * Bank account identifier.
     */
    public String BankAccountId;
    
    /**
     * Communication.
     */
    public String Communication;
}
