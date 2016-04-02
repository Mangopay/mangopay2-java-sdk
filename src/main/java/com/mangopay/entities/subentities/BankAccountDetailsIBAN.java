package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IBankAccountDetails;

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
