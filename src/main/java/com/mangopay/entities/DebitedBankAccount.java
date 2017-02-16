package com.mangopay.entities;

import com.mangopay.core.Dto;

/**
 * Debited bank account object.
 */
public class DebitedBankAccount extends Dto {

    /**
     * Name of the account's owner.
     */
    public String OwnerName;

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        this.OwnerName = ownerName;
    }
}
