package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.DisputeReason;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.DisputeStatus;
import com.mangopay.core.enumerations.DisputeType;
import com.mangopay.core.enumerations.InitialTransactionType;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Dispute entity.
 */
public class Dispute extends EntityBase {

    /**
     * Identifier of the transaction that was disputed.
     */
    @SerializedName("InitialTransactionId")
    private String initialTransactionId;

    /**
     * Most transaction type of the original trasaction.
     */
    @SerializedName("InitialTransactionType")
    private InitialTransactionType initialTransactionType;

    /**
     * Type of dispute.
     */
    @SerializedName("DisputeType")
    private DisputeType disputeType;

    /**
     * The date by which you must submit docs if they wish to contest the dispute.
     */
    @SerializedName("ContestDeadlineDate")
    private Long contestDeadlineDate;

    /**
     * Dispute's reason.
     */
    @SerializedName("DisputeReason")
    private DisputeReason disputeReason;

    /**
     * Disputed funds.
     */
    @SerializedName("DisputedFunds")
    private Money disputedFunds;

    /**
     * Contested funds.
     */
    @SerializedName("ContestedFunds")
    private Money contestedFunds;

    /**
     * Contested funds.
     */
    @SerializedName("Status")
    private DisputeStatus status;

    /**
     * Free text used when reopening the dispute.
     */
    @SerializedName("StatusMessage")
    private String statusMessage;

    /**
     * Result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * Free text that might be completed when the dispute is closed.
     */
    @SerializedName("ResultMessage")
    private String resultMessage;
    
    /**
     * The ID of the corresponding repudiation transaction
     */
    @SerializedName("RepudiationId")
    private String repudiationId;

    /**
     * The date and time the dispute was closed
     */
    @SerializedName("ClosedDate")
    private Long closedDate;

    public String getInitialTransactionId() {
        return initialTransactionId;
    }

    public void setInitialTransactionId(String initialTransactionId) {
        this.initialTransactionId = initialTransactionId;
    }

    public com.mangopay.core.enumerations.InitialTransactionType getInitialTransactionType() {
        return initialTransactionType;
    }

    public void setInitialTransactionType(InitialTransactionType initialTransactionType) {
        this.initialTransactionType = initialTransactionType;
    }

    public DisputeType getDisputeType() {
        return disputeType;
    }

    public void setDisputeType(DisputeType disputeType) {
        this.disputeType = disputeType;
    }

    public Long getContestDeadlineDate() {
        return contestDeadlineDate;
    }

    public void setContestDeadlineDate(Long contestDeadlineDate) {
        this.contestDeadlineDate = contestDeadlineDate;
    }

    public DisputeReason getDisputeReason() {
        return disputeReason;
    }

    public void setDisputeReason(DisputeReason disputeReason) {
        this.disputeReason = disputeReason;
    }

    public Money getDisputedFunds() {
        return disputedFunds;
    }

    public void setDisputedFunds(Money disputedFunds) {
        this.disputedFunds = disputedFunds;
    }

    public Money getContestedFunds() {
        return contestedFunds;
    }

    public void setContestedFunds(Money contestedFunds) {
        this.contestedFunds = contestedFunds;
    }

    public DisputeStatus getStatus() {
        return status;
    }

    public void setStatus(DisputeStatus status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
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
    
    public String getRepudiationId() {
        return repudiationId;
    }

    public void setRepudiationId(String repudiationId) {
        this.repudiationId = repudiationId;
    }

    public Long getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Long closedDate) {
        this.closedDate = closedDate;
    }

    /**
     * Gets map which property is an object and what type of object.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        return new HashMap<String, Type>() {{
            put("DisputedFunds", Money.class);
            put("ContestedFunds", Money.class);
            put("DisputeReason", DisputeReason.class);
        }};
    }
}
