package com.mangopay.core;

/**
 * Class represents OTHER type of bank account.
 */
public class BankAccountDetailsOTHER extends Dto implements IBankAccountDetails {
    
    /**
     * Type.
     */
    public String Type;
    
    /**
     * The Country associate to the BankAccount, 
     * ISO 3166-1 alpha-2 format is expected.
     */
    public String Country;
    
    /**
     * Valid BIC format.
     */
    public String BIC;
    
    /**
     * Account number.
     */
    public String AccountNumber;
    
}
