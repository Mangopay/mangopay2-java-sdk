package com.mangopay.core;

/**
 * Class representing BankWire type for mean of payment in PayOut entity
 */
public class PayOutPaymentDetailsBankWire extends Dto implements IPayOutPaymentDetails {
    
    /**
     * Bank account Id
     */
    public String BankAccountId;
    
    /**
     * Communication.
     */
    public String Communication;
    
}
