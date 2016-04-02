package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IBankAccountDetails;

/**
 * Class represents GB type of bank account.
 */
public class BankAccountDetailsGB extends Dto implements IBankAccountDetails {
    
    /**
     * Account number.
     */
    public String AccountNumber;
    
    /**
     * Sort code.
     */
    public String SortCode;
    
}
