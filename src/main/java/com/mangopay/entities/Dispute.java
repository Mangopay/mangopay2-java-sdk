package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getInitialTransactionId()} and {@link #setInitialTransactionId(String)} instead.
     */
    @Deprecated
    public String InitialTransactionId;

    /**
     * Most transaction type of the original trasaction.
     *
     * @deprecated Use {@link #getInitialTransactionType()} and {@link #setInitialTransactionType(InitialTransactionType)} instead.
     */
    @Deprecated
    public InitialTransactionType InitialTransactionType;

    /**
     * Type of dispute.
     *
     * @deprecated Use {@link #getDisputeType()} and {@link #setDisputeType(DisputeType)} instead.
     */
    @Deprecated
    public DisputeType DisputeType;

    /**
     * The date by which you must submit docs if they wish to contest the dispute.
     *
     * @deprecated Use {@link #getContestDeadlineDate()} and {@link #setContestDeadlineDate(Long)} instead.
     */
    @Deprecated
    public Long ContestDeadlineDate;

    /**
     * Dispute's reason.
     *
     * @deprecated Use {@link #getDisputeReason()} and {@link #setDisputeReason(DisputeReason)} instead.
     */
    @Deprecated
    public DisputeReason DisputeReason;

    /**
     * Disputed funds.
     *
     * @deprecated Use {@link #getDisputedFunds()} and {@link #setDisputedFunds(Money)} instead.
     */
    @Deprecated
    public Money DisputedFunds;

    /**
     * Contested funds.
     *
     * @deprecated Use {@link #getContestedFunds()} and {@link #setContestedFunds(Money)} instead.
     */
    @Deprecated
    public Money ContestedFunds;

    /**
     * Contested funds.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(DisputeStatus)} instead.
     */
    @Deprecated
    public DisputeStatus Status;

    /**
     * Free text used when reopening the dispute.
     *
     * @deprecated Use {@link #getStatusMessage()} and {@link #setStatusMessage(String)} instead.
     */
    @Deprecated
    public String StatusMessage;

    /**
     * Result code.
     *
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(String)} instead.
     */
    @Deprecated
    public String ResultCode;

    /**
     * Free text that might be completed when the dispute is closed.
     *
     * @deprecated Use {@link #getResultMessage()} and {@link #setResultMessage(String)} instead.
     */
    @Deprecated
    public String ResultMessage;

    public String getInitialTransactionId() {
        return InitialTransactionId;
    }

    public void setInitialTransactionId(String initialTransactionId) {
        this.InitialTransactionId = initialTransactionId;
    }

    public com.mangopay.core.enumerations.InitialTransactionType getInitialTransactionType() {
        return InitialTransactionType;
    }

    public void setInitialTransactionType(InitialTransactionType initialTransactionType) {
        this.InitialTransactionType = initialTransactionType;
    }

    public DisputeType getDisputeType() {
        return DisputeType;
    }

    public void setDisputeType(DisputeType disputeType) {
        this.DisputeType = disputeType;
    }

    public Long getContestDeadlineDate() {
        return ContestDeadlineDate;
    }

    public void setContestDeadlineDate(Long contestDeadlineDate) {
        this.ContestDeadlineDate = contestDeadlineDate;
    }

    public DisputeReason getDisputeReason() {
        return DisputeReason;
    }

    public void setDisputeReason(DisputeReason disputeReason) {
        this.DisputeReason = disputeReason;
    }

    public Money getDisputedFunds() {
        return DisputedFunds;
    }

    public void setDisputedFunds(Money disputedFunds) {
        this.DisputedFunds = disputedFunds;
    }

    public Money getContestedFunds() {
        return ContestedFunds;
    }

    public void setContestedFunds(Money contestedFunds) {
        this.ContestedFunds = contestedFunds;
    }

    public DisputeStatus getStatus() {
        return Status;
    }

    public void setStatus(DisputeStatus status) {
        this.Status = status;
    }

    public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.StatusMessage = statusMessage;
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
