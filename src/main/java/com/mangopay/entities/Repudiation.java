package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.TransactionStatus;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Repudiation entity.
 */
public class Repudiation extends EntityBase {

    /**
     * The Id of the origin payin author.
     *
     * @deprecated Use {@link #getAuthorId()} and {@link #setAuthorId(String)} instead.
     */
    @Deprecated
    public String AuthorId;

    /**
     * The funds repudiated from the wallet.
     *
     * @deprecated Use {@link #getDebitedFunds()} and {@link #setDebitedFunds(Money)} instead.
     */
    @Deprecated
    public Money DebitedFunds;

    /**
     * The fees taken on the repudiation – will always be 0 at this stage.
     *
     * @deprecated Use {@link #getFees()} and {@link #setFees(Money)} instead.
     */
    @Deprecated
    public Money Fees;

    /**
     * The amount of credited funds – since there are currently no fees,
     * this will be equal to the DebitedFunds.
     *
     * @deprecated Use {@link #getCreditedFunds()} and {@link #setCreditedFunds(Money)} instead.
     */
    @Deprecated
    public Money CreditedFunds;

    /**
     * The wallet from where the repudiation was taken.
     *
     * @deprecated Use {@link #getDebitedWalletId()} and {@link #setDebitedWalletId(String)} instead.
     */
    @Deprecated
    public String DebitedWalletId;

    /**
     * The status of the transfer.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(TransactionStatus)} instead.
     */
    @Deprecated
    public TransactionStatus Status;

    /**
     * The transaction result code.
     *
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(String)} instead.
     */
    @Deprecated
    public String ResultCode;

    /**
     * The transaction result message.
     *
     * @deprecated Use {@link #getResultMessage()} and {@link #setResultMessage(String)} instead.
     */
    @Deprecated
    public String ResultMessage;

    /**
     * The execution date of the repudiation.
     *
     * @deprecated Use {@link #getExecutionDate()} and {@link #setExecutionDate(Long)} instead.
     */
    @Deprecated
    public Long ExecutionDate;

    /**
     * The Id of the dispute to which this repudiation corresponds.
     * Note that this value may be null (if it was created before the Dispute
     * objects started to be used – October 2015).
     *
     * @deprecated Use {@link #getDisputeId()} and {@link #setDisputeId(String)} instead.
     */
    @Deprecated
    public String DisputeId;

    /**
     * The Id of the transaction that was repudiated.
     *
     * @deprecated Use {@link #getInitialTransactionId()} and {@link #setInitialTransactionId(String)} instead.
     */
    @Deprecated
    public String InitialTransactionId;

    /**
     * The initial transaction type.
     *
     * @deprecated Use {@link #getInitialTransactionType()} and {@link #setInitialTransactionType(String)} instead.
     */
    @Deprecated
    public String InitialTransactionType;

    public String getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(String authorId) {
        this.AuthorId = authorId;
    }

    public Money getDebitedFunds() {
        return DebitedFunds;
    }

    public void setDebitedFunds(Money debitedFunds) {
        this.DebitedFunds = debitedFunds;
    }

    public Money getFees() {
        return Fees;
    }

    public void setFees(Money fees) {
        this.Fees = fees;
    }

    public Money getCreditedFunds() {
        return CreditedFunds;
    }

    public void setCreditedFunds(Money creditedFunds) {
        this.CreditedFunds = creditedFunds;
    }

    public String getDebitedWalletId() {
        return DebitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.DebitedWalletId = debitedWalletId;
    }

    public TransactionStatus getStatus() {
        return Status;
    }

    public void setStatus(TransactionStatus status) {
        this.Status = status;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        this.ResultCode = resultCode;
    }

    public String getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.ResultMessage = resultMessage;
    }

    public Long getExecutionDate() {
        return ExecutionDate;
    }

    public void setExecutionDate(Long executionDate) {
        this.ExecutionDate = executionDate;
    }

    public String getDisputeId() {
        return DisputeId;
    }

    public void setDisputeId(String disputeId) {
        this.DisputeId = disputeId;
    }

    public String getInitialTransactionId() {
        return InitialTransactionId;
    }

    public void setInitialTransactionId(String initialTransactionId) {
        this.InitialTransactionId = initialTransactionId;
    }

    public String getInitialTransactionType() {
        return InitialTransactionType;
    }

    public void setInitialTransactionType(String initialTransactionType) {
        this.InitialTransactionType = initialTransactionType;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        return new HashMap<String, Type>() {{
            put("DebitedFunds", Money.class);
            put("Fees", Money.class);
            put("CreditedFunds", Money.class);
        }};
    }
}
