package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
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
     */
    @SerializedName("AuthorId")
    private String authorId;

    /**
     * Credited user identifier.
     */
    @SerializedName("CreditedUserId")
    private String creditedUserId;

    /**
     * Debited funds.
     */
    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    /**
     * Credited funds.
     */
    @SerializedName("CreditedFunds")
    private Money creditedFunds;

    /**
     * Fees.
     */
    @SerializedName("Fees")
    private Money fees;

    /**
     * Transaction status.
     */
    @SerializedName("Status")
    private TransactionStatus status;

    /**
     * Result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * The PreAuthorization result Message explaining the result code.
     */
    @SerializedName("ResultMessage")
    private String resultMessage;

    /**
     * ExecutionDate (UNIX timestamp).
     */
    @SerializedName("ExecutionDate")
    private Long executionDate;

    /**
     * Transaction type.
     */
    @SerializedName("Type")
    private TransactionType type;

    /**
     * Transaction nature.
     */
    @SerializedName("Nature")
    private TransactionNature nature;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getCreditedUserId() {
        return creditedUserId;
    }

    public void setCreditedUserId(String creditedUserId) {
        this.creditedUserId = creditedUserId;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public void setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
    }

    public Money getCreditedFunds() {
        return creditedFunds;
    }

    public void setCreditedFunds(Money creditedFunds) {
        this.creditedFunds = creditedFunds;
    }

    public Money getFees() {
        return fees;
    }

    public void setFees(Money fees) {
        this.fees = fees;
    }

    /**
     * Get Transaction Status
     *
     * @return {@link TransactionStatus }
     */
    public TransactionStatus getStatus() {
        if (status == null) {
            return TransactionStatus.NotSpecified;
        } else {
            return status;
        }
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Long getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Long executionDate) {
        this.executionDate = executionDate;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionNature getNature() {
        return nature;
    }

    public void setNature(TransactionNature nature) {
        this.nature = nature;
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
