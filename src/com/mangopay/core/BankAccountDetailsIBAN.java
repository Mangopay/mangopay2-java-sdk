package com.mangopay.core;

/**
 * Class represents IBAN type of bank account.
 */
public class BankAccountDetailsIBAN extends Dto implements IBankAccountDetails {
    
    /**
     * IBAN number.
     */
    public String IBAN;
    
    /**
     * BIC.
     */
    public String BIC;
    
}
