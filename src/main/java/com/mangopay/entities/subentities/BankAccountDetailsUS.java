package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.IBankAccountDetails;
import com.mangopay.core.enumerations.DepositAccountType;

/**
 * Class represents US type of bank account.
 */
public class BankAccountDetailsUS extends Dto implements IBankAccountDetails {
    
    /**
     * Account number.
     */
    public String AccountNumber;
    
    /**
     * ABA.
     */
    public String ABA;
    
    /**
     * Deposit account type.
     */
    public DepositAccountType DepositAccountType;

    /**
     * Instantiates new BankAccountDetailsUS object.
     */
    public BankAccountDetailsUS() {
        this.DepositAccountType = DepositAccountType.CHECKING;
    }
}
