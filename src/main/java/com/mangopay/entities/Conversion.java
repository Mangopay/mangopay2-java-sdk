package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.TransactionNature;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;

import java.util.ArrayList;

public class Conversion extends EntityBase {

    /**
     * The unique identifier of the active quote which guaranteed the rate for the conversion.
     */
    @SerializedName("QuoteId")
    public String quoteId;

    /**
     * The type of transaction
     */
    @SerializedName("Type")
    public TransactionType type;

    /**
     * The nature of the transaction, providing more
     * information about the context in which the transaction occurred:
     */
    @SerializedName("Nature")
    public TransactionNature nature;

    /**
     * The status of the transaction.
     */
    @SerializedName("Status")
    public TransactionStatus status;

    /**
     * The unique identifier of the user at the source of the transaction.
     */
    @SerializedName("AuthorId")
    public String authorId;

    /**
     * The unique identifier of the debited wallet.
     */
    @SerializedName("DebitedWalletId")
    public String debitedWalletId;

    /**
     * The unique identifier of the credited wallet
     */
    @SerializedName("CreditedWalletId")
    public String creditedWalletId;

    /**
     * The sell funds
     */
    @SerializedName("DebitedFunds")
    public Money debitedFunds;

    /**
     * The buy funds
     */
    @SerializedName("CreditedFunds")
    public Money creditedFunds;

    /**
     * Information about the fees taken by the platform for
     * this transaction (and hence transferred to the Fees Wallet).
     */
    @SerializedName("Fees")
    public Money fees;

    /**
     * The code indicates the result of the operation.
     * This information is mostly used to handle errors or for filtering purposes.
     */
    @SerializedName("ResultCode")
    public String resultCode;

    /**
     * The explanation of the result code.
     */
    @SerializedName("ResultMessage")
    public String resultMessage;

    /**
     * The date and time at which the status changed to SUCCEEDED,
     * indicating that the transaction occurred.
     * The statuses CREATED and FAILED return an ExecutionDate of null
     */
    @SerializedName("ExecutionDate")
    public Long executionDate;

    /**
     * Real time indicative market rate of a specific currency pair
     */
    @SerializedName("ConversionRateResponse")
    public ConversionRate conversionRate;

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

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

    public ConversionRate getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(ConversionRate conversionRate) {
        this.conversionRate = conversionRate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
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

    public Money getFees() {
        return fees;
    }

    public void setFees(Money fees) {
        this.fees = fees;
    }

    @Override
    public ArrayList<String> getReadOnlyProperties() {
        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("ConversionRate");
        result.add("Status");
        result.add("Type");
        result.add("Nature");
        result.add("ResultCode");
        result.add("ResultMessage");
        result.add("ExecutionDate");

        return result;
    }
}
