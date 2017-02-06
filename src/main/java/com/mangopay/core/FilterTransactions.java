package com.mangopay.core;

import com.mangopay.core.enumerations.TransactionNature;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for transaction list.
 */
public class FilterTransactions extends Dto {

    /**
     * Transaction status.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(TransactionStatus)} instead.
     */
    @Deprecated
    public TransactionStatus Status;

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

    /**
     * Start date in Unix format: return only transactions that have CreationDate BEFORE this date.
     *
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
     * End date in Unix format: return only transactions that have CreationDate AFTER this date.
     *
     * @deprecated Use {@link #getAfterDate()} and {@link #setAfterDate(Long)} instead.
     */
    @Deprecated
    public Long AfterDate;

    public TransactionStatus getStatus() {
        return Status;
    }

    public void setStatus(TransactionStatus status) {
        this.Status = status;
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

    public Long getBeforeDate() {
        return BeforeDate;
    }

    public void setBeforeDate(Long beforeDate) {
        this.BeforeDate = beforeDate;
    }

    public Long getAfterDate() {
        return AfterDate;
    }

    public void setAfterDate(Long afterDate) {
        this.AfterDate = afterDate;
    }

    /**
     * Gets map of fields and values.
     *
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();

        if (Status != null && Status != TransactionStatus.NotSpecified) result.put("Status", Status.toString());
        if (Type != null && Type != TransactionType.NotSpecified) result.put("Type", Type.toString());
        if (Nature != null && Nature != TransactionNature.NotSpecified) result.put("Nature", Nature.toString());
        if (BeforeDate != null) result.put("BeforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("AfterDate", Long.toString(AfterDate));

        return result;
    }
}
