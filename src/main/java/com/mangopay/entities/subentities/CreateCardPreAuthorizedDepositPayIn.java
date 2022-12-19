package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;

public class CreateCardPreAuthorizedDepositPayIn extends Dto {
    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("CreditedWalletId")
    private String creditedWalletId;

    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    @SerializedName("Fees")
    private Money fees;

    @SerializedName("DepositId")
    private String depositId;

    @SerializedName("Tag")
    private String tag;

    public CreateCardPreAuthorizedDepositPayIn(String creditedWalletId, Money debitedFunds, Money fees, String depositId) {
        this.creditedWalletId = creditedWalletId;
        this.debitedFunds = debitedFunds;
        this.fees = fees;
        this.depositId = depositId;
    }

    public CreateCardPreAuthorizedDepositPayIn() {
    }

    public String getAuthorId() {
        return authorId;
    }

    public CreateCardPreAuthorizedDepositPayIn setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getCreditedWalletId() {
        return creditedWalletId;
    }

    public CreateCardPreAuthorizedDepositPayIn setCreditedWalletId(String creditedWalletId) {
        this.creditedWalletId = creditedWalletId;
        return this;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public CreateCardPreAuthorizedDepositPayIn setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
        return this;
    }

    public Money getFees() {
        return fees;
    }

    public CreateCardPreAuthorizedDepositPayIn setFees(Money fees) {
        this.fees = fees;
        return this;
    }

    public String getDepositId() {
        return depositId;
    }

    public CreateCardPreAuthorizedDepositPayIn setDepositId(String depositId) {
        this.depositId = depositId;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public CreateCardPreAuthorizedDepositPayIn setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
