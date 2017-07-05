package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Transfer entity.
 */
public class Transfer extends Transaction {

    /**
     * Debited wallet identifier.
     */
    @SerializedName("DebitedWalletId")
    private String debitedWalletId;

    /**
     * Credited wallet identifier.
     */
    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public void setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
    }
}
