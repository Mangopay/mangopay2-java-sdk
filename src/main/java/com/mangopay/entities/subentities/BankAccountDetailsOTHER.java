package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IBankAccountDetails;
import com.mangopay.core.enumerations.CountryIso;

/**
 * Class represents OTHER type of bank account.
 */
public class BankAccountDetailsOTHER extends Dto implements IBankAccountDetails {
    
    /**
     * Type.
     */
    //public String Type;
    
    /**
     * The Country associated to the BankAccount.
     */
    public CountryIso Country;
    
    /**
     * Valid BIC format.
     */
    public String BIC;
    
    /**
     * Account number.
     */
    public String AccountNumber;
    
}
