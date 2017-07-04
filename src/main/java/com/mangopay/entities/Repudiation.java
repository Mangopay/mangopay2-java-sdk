package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
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
     */
    @SerializedName("AuthorId")
    private String authorId;

    /**
     * The funds repudiated from the wallet.
     */
    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    /**
     * The fees taken on the repudiation – will always be 0 at this stage.
     */
    @SerializedName("Fees")
    private Money fees;

    /**
     * The amount of credited funds – since there are currently no fees,
     * this will be equal to the DebitedFunds.
     */
    @SerializedName("CreditedFunds")
    private Money creditedFunds;

    /**
     * The wallet from where the repudiation was taken.
     */
    @SerializedName("DebitedWalletId")
    private String debitedWalletId;

    /**
     * The status of the transfer.
     */
    @SerializedName("Status")
    private TransactionStatus status;

    /**
     * The transaction result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * The transaction result message.
     */
    @SerializedName("ResultMessage")
    private String resultMessage;

    /**
     * The execution date of the repudiation.
     */
    @SerializedName("ExecutionDate")
    private Long executionDate;

    /**
     * The Id of the dispute to which this repudiation corresponds.
     * Note that this value may be null (if it was created before the Dispute
     * objects started to be used – October 2015).
     */
    @SerializedName("DisputeId")
    private String disputeId;

    /**
     * The Id of the transaction that was repudiated.
     */
    @SerializedName("InitialTransactionId")
    private String initialTransactionId;

    /**
     * The initial transaction type.
     */
    @SerializedName("InitialTransactionType")
    private String initialTransactionType;

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

    public Money getCreditedFunds() {
        return creditedFunds;
    }

    public void setCreditedFunds(Money creditedFunds) {
        this.creditedFunds = creditedFunds;
    }

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }

    public TransactionStatus getStatus() {
        return status;
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

    public String getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(String disputeId) {
        this.disputeId = disputeId;
    }

    public String getInitialTransactionId() {
        return initialTransactionId;
    }

    public void setInitialTransactionId(String initialTransactionId) {
        this.initialTransactionId = initialTransactionId;
    }

    public String getInitialTransactionType() {
        return initialTransactionType;
    }

    public void setInitialTransactionType(String initialTransactionType) {
        this.initialTransactionType = initialTransactionType;
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
