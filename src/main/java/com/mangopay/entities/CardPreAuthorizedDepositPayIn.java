package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.*;

public class CardPreAuthorizedDepositPayIn extends EntityBase {
    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("CreditedUserId")
    private String creditedUserId;

    @SerializedName("DepositId")
    private String depositId;

    @SerializedName("ResultCode")
    private String resultCode;

    @SerializedName("ResultMessage")
    private String resultMessage;

    @SerializedName("Status")
    private TransactionStatus status;

    @SerializedName("ExecutionDate")
    private Long executionDate;

    @SerializedName("Type")
    private TransactionType type;

    @SerializedName("Nature")
    private TransactionNature nature;

    @SerializedName("PaymentType")
    private PayInPaymentType paymentType;

    @SerializedName("ExecutionType")
    private PayInExecutionType executionType;

    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    @SerializedName("CreditedFunds")
    private Money creditedFunds;

    @SerializedName("Fees")
    private Money fees;

    public String getAuthorId() {
        return authorId;
    }

    public CardPreAuthorizedDepositPayIn setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getCreditedUserId() {
        return creditedUserId;
    }

    public CardPreAuthorizedDepositPayIn setCreditedUserId(String creditedUserId) {
        this.creditedUserId = creditedUserId;
        return this;
    }

    public String getDepositId() {
        return depositId;
    }

    public CardPreAuthorizedDepositPayIn setDepositId(String depositId) {
        this.depositId = depositId;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public CardPreAuthorizedDepositPayIn setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public CardPreAuthorizedDepositPayIn setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
        return this;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public CardPreAuthorizedDepositPayIn setStatus(TransactionStatus status) {
        this.status = status;
        return this;
    }

    public Long getExecutionDate() {
        return executionDate;
    }

    public CardPreAuthorizedDepositPayIn setExecutionDate(Long executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    public TransactionType getType() {
        return type;
    }

    public CardPreAuthorizedDepositPayIn setType(TransactionType type) {
        this.type = type;
        return this;
    }

    public TransactionNature getNature() {
        return nature;
    }

    public CardPreAuthorizedDepositPayIn setNature(TransactionNature nature) {
        this.nature = nature;
        return this;
    }

    public PayInPaymentType getPaymentType() {
        return paymentType;
    }

    public CardPreAuthorizedDepositPayIn setPaymentType(PayInPaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PayInExecutionType getExecutionType() {
        return executionType;
    }

    public CardPreAuthorizedDepositPayIn setExecutionType(PayInExecutionType executionType) {
        this.executionType = executionType;
        return this;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public CardPreAuthorizedDepositPayIn setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
        return this;
    }

    public Money getCreditedFunds() {
        return creditedFunds;
    }

    public CardPreAuthorizedDepositPayIn setCreditedFunds(Money creditedFunds) {
        this.creditedFunds = creditedFunds;
        return this;
    }

    public Money getFees() {
        return fees;
    }

    public CardPreAuthorizedDepositPayIn setFees(Money fees) {
        this.fees = fees;
        return this;
    }
}
