package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;

public class CreateClientWalletsInstantConversion extends Dto {
    /**
     * The type of the client wallet to be debited.
     * Allowed values: FEES, CREDIT
     */
    @SerializedName("DebitedWalletType")
    public String debitedWalletType;

    /**
     * Information about the debited funds.
     */
    @SerializedName("DebitedFunds")
    public Money debitedFunds;

    /**
     * The type of the client wallet to be credited.
     * Allowed values: FEES, CREDIT
     */
    @SerializedName("CreditedWalletType")
    public String creditedWalletType;

    /**
     * Information about the credited funds.
     */
    @SerializedName("CreditedFunds")
    public Money creditedFunds;

    /**
     * Custom data.
     */
    @SerializedName("Tag")
    private String tag;

    public String getDebitedWalletType() {
        return debitedWalletType;
    }

    public CreateClientWalletsInstantConversion setDebitedWalletType(String debitedWalletType) {
        this.debitedWalletType = debitedWalletType;
        return this;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public CreateClientWalletsInstantConversion setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
        return this;
    }

    public String getCreditedWalletType() {
        return creditedWalletType;
    }

    public CreateClientWalletsInstantConversion setCreditedWalletType(String creditedWalletType) {
        this.creditedWalletType = creditedWalletType;
        return this;
    }

    public Money getCreditedFunds() {
        return creditedFunds;
    }

    public CreateClientWalletsInstantConversion setCreditedFunds(Money creditedFunds) {
        this.creditedFunds = creditedFunds;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public CreateClientWalletsInstantConversion setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
