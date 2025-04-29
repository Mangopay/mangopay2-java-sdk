package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.TransactionNature;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for transaction list.
 */
public class FilterTransactions extends Dto {

    @SerializedName("Status")
    private TransactionStatus status;

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

    /**
     * Start date in Unix format: return only transactions that have CreationDate BEFORE this date.
     */
    @SerializedName("BeforeDate")
    private Long beforeDate;

    /**
     * End date in Unix format: return only transactions that have CreationDate AFTER this date.
     */
    @SerializedName("AfterDate")
    private Long afterDate;

    /**
     * Possible values: USER_NOT_PRESENT, USER_PRESENT
     */
    @SerializedName("ScaContext")
    private String scaContext;

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

    public Long getBeforeDate() {
        return beforeDate;
    }

    public void setBeforeDate(Long beforeDate) {
        this.beforeDate = beforeDate;
    }

    public Long getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(Long afterDate) {
        this.afterDate = afterDate;
    }

    public String getScaContext() {
        return scaContext;
    }

    public void setScaContext(String scaContext) {
        this.scaContext = scaContext;
    }

    /**
     * Gets map of fields and values.
     *
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();

        if (status != null && status != TransactionStatus.NotSpecified) result.put("Status", status.toString());
        if (type != null && type != TransactionType.NotSpecified) result.put("Type", type.toString());
        if (nature != null && nature != TransactionNature.NotSpecified) result.put("Nature", nature.toString());
        if (beforeDate != null) result.put("BeforeDate", Long.toString(beforeDate));
        if (afterDate != null) result.put("AfterDate", Long.toString(afterDate));
        if (scaContext != null) result.put("ScaContext", scaContext);

        return result;
    }
}
