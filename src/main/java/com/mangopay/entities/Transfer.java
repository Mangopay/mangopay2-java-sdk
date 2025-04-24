package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.entities.subentities.PendingUserAction;

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

    @SerializedName("ScaContext")
    private String scaContext;

    @SerializedName("PendingUserAction")
    private PendingUserAction pendingUserAction;

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

    public PendingUserAction getPendingUserAction() {
        return pendingUserAction;
    }

    public Transfer setPendingUserAction(PendingUserAction pendingUserAction) {
        this.pendingUserAction = pendingUserAction;
        return this;
    }

    public String getScaContext() {
        return scaContext;
    }

    public Transfer setScaContext(String scaContext) {
        this.scaContext = scaContext;
        return this;
    }
}
