package com.mangopay.core;

/**
 * Class represents US type of bank account.
 */
public class BankAccountDetailsUS extends Dto implements IBankAccountDetails {
    
    /**
     * Account number.
     */
    public String AccountNumber;
    
    /**
     * ABA
     */
    public String ABA;
    
}
