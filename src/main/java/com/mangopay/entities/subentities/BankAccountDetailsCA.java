package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IBankAccountDetails;

/**
 * Class represents CA type of bank account.
 */
public class BankAccountDetailsCA extends Dto implements IBankAccountDetails {
    
    /**
     * Bank name.
     */
    public String BankName;
    
    /**
     * Institution number.
     */
    public String InstitutionNumber;
    
    /**
     * Branch code.
     */
    public String BranchCode;
    
    /**
     * Account number.
     */
    public String AccountNumber;
    
}
