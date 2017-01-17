package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.DepositAccountType;
import com.mangopay.core.interfaces.BankAccountDetails;

import static com.mangopay.core.enumerations.DepositAccountType.CHECKING;

/**
 * Class represents US type of bank account.
 */
public class BankAccountDetailsUS extends Dto implements BankAccountDetails {

    /**
     * Account number.
     *
     * @deprecated Use {@link #getAccountNumber()} and {@link #setAccountNumber(String)} instead.
     */
    @Deprecated
    public String AccountNumber;

    /**
     * ABA.
     *
     * @deprecated Use {@link #getABA()} and {@link #setABA(String)} instead.
     */
    @Deprecated
    public String ABA;

    /**
     * Deposit account type.
     *
     * @deprecated Use {@link #getDepositAccountType()} and {@link #setDepositAccountType(DepositAccountType)} instead.
     */
    @Deprecated
    public DepositAccountType DepositAccountType;

    /**
     * Instantiates new BankAccountDetailsUS object.
     */
    public BankAccountDetailsUS() {
        this.DepositAccountType = CHECKING;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.AccountNumber = accountNumber;
    }

    public String getABA() {
        return ABA;
    }

    public void setABA(String ABA) {
        this.ABA = ABA;
    }

    public com.mangopay.core.enumerations.DepositAccountType getDepositAccountType() {
        return DepositAccountType;
    }

    public void setDepositAccountType(com.mangopay.core.enumerations.DepositAccountType depositAccountType) {
        this.DepositAccountType = depositAccountType;
    }
}
