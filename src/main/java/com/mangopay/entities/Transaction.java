package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.TransactionNature;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Transaction entity. Base class for: PayIn, PayOut, Transfer.
 */
public class Transaction extends EntityBase {

    /**
     * Author identifier.
     *
     * @deprecated Use {@link #getAuthorId()} and {@link #setAuthorId(String)} instead.
     */
    @Deprecated
    public String AuthorId;

    /**
     * Credited user identifier.
     *
     * @deprecated Use {@link #getCreditedUserId()} and {@link #setCreditedUserId(String)} instead.
     */
    @Deprecated
    public String CreditedUserId;

    /**
     * Debited funds.
     *
     * @deprecated Use {@link #getDebitedFunds()} and {@link #setDebitedFunds(Money)} instead.
     */
    @Deprecated
    public Money DebitedFunds;

    /**
     * Credited funds.
     *
     * @deprecated Use {@link #getCreditedFunds()} and {@link #setCreditedFunds(Money)} instead.
     */
    @Deprecated
    public Money CreditedFunds;

    /**
     * Fees.
     *
     * @deprecated Use {@link #getFees()} and {@link #setFees(Money)} instead.
     */
    @Deprecated
    public Money Fees;

    /**
     * Transaction status.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(TransactionStatus)} instead.
     */
    @Deprecated
    public TransactionStatus Status;

    /**
     * Result code.
     *
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(String)} instead.
     */
    @Deprecated
    public String ResultCode;

    /**
     * The PreAuthorization result Message explaining the result code.
     *
     * @deprecated Use {@link #getResultMessage()} and {@link #setResultMessage(String)} instead.
     */
    @Deprecated
    public String ResultMessage;

    /**
     * ExecutionDate (UNIX timestamp).
     *
     * @deprecated Use {@link #getExecutionDate()} and {@link #setExecutionDate(Long)} instead.
     */
    @Deprecated
    public Long ExecutionDate;

    /**
     * Transaction type.
     *
     * @deprecated Use {@link #getType()} and {@link #setType(TransactionType)} instead.
     */
    @Deprecated
    public TransactionType Type;

    /**
     * Transaction nature.
     *
     * @deprecated Use {@link #getNature()} and {@link #setNature(TransactionNature)} instead.
     */
    @Deprecated
    public TransactionNature Nature;

    public String getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(String authorId) {
        this.AuthorId = authorId;
    }

    public String getCreditedUserId() {
        return CreditedUserId;
    }

    public void setCreditedUserId(String creditedUserId) {
        this.CreditedUserId = creditedUserId;
    }

    public Money getDebitedFunds() {
        return DebitedFunds;
    }

    public void setDebitedFunds(Money debitedFunds) {
        this.DebitedFunds = debitedFunds;
    }

    public Money getCreditedFunds() {
        return CreditedFunds;
    }

    public void setCreditedFunds(Money creditedFunds) {
        this.CreditedFunds = creditedFunds;
    }

    public Money getFees() {
        return Fees;
    }

    public void setFees(Money fees) {
        this.Fees = fees;
    }

    /**
     * Get Transaction Status
     *
     * @return {@link TransactionStatus }
     */
    public TransactionStatus getStatus() {
        if (Status == null) {
            return TransactionStatus.NotSpecified;
        } else {
            return Status;
        }
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

    public TransactionType getType() {
        return Type;
    }

    public void setType(TransactionType type) {
        this.Type = type;
    }

    public TransactionNature getNature() {
        return Nature;
    }

    public void setNature(TransactionNature nature) {
        this.Nature = nature;
    }

    /**
     * Is Transaction Created Status
     *
     * @return True if transaction is created
     */
    public boolean isCreated() {
        return getStatus() == TransactionStatus.CREATED;
    }

    /**
     * Is Transaction Failed Status
     *
     * @return True if transaction is failed
     */
    public boolean isFailed() {
        return getStatus() == TransactionStatus.FAILED;
    }

    /**
     * Is Transaction Succeeded Status
     *
     * @return True if transaction is succeeded
     */
    public boolean isSucceeded() {
        return getStatus() == TransactionStatus.SUCCEEDED;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        HashMap<String, Type> result = new HashMap<>();

        result.put("DebitedFunds", Money.class);
        result.put("CreditedFunds", Money.class);
        result.put("Fees", Money.class);

        return result;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("Status");
        result.add("ResultCode");
        result.add("ExecutionDate");

        return result;
    }


}
