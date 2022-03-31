package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.PayoutMode;

public class PayOutEligibility extends Dto {

    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    @SerializedName("Fees")
    private Money fees;

    @SerializedName("BankAccountId")
    private String bankAccountId;

    @SerializedName("DebitedWalletId")
    private String debitedWalletId;

    @SerializedName("BankWireRef")
    private String bankWireRef;

    @SerializedName("PayoutModeRequested")
    private PayoutMode payoutModeRequested;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public void setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
    }

    public Money getFees() {
        return fees;
    }

    public void setFees(Money fees) {
        this.fees = fees;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }

    public String getBankWireRef() {
        return bankWireRef;
    }

    public void setBankWireRef(String bankWireRef) {
        this.bankWireRef = bankWireRef;
    }

    public PayoutMode getPayoutModeRequested() {
        return payoutModeRequested;
    }

    public void setPayoutModeRequested(PayoutMode payoutModeRequested) {
        this.payoutModeRequested = payoutModeRequested;
    }
}
