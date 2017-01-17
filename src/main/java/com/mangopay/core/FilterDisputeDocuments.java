package com.mangopay.core;

import com.mangopay.core.enumerations.DisputeDocumentStatus;
import com.mangopay.core.enumerations.DisputeDocumentType;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for dispute documents list.
 */
public class FilterDisputeDocuments extends Dto {

    /**
     * Dispute document status.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(DisputeDocumentStatus)} instead.
     */
    @Deprecated
    public DisputeDocumentStatus Status;

    /**
     * Dispute document type.
     *
     * @deprecated Use {@link #getType()} and {@link #setType(DisputeDocumentType)} instead.
     */
    @Deprecated
    public DisputeDocumentType Type;

    /**
     * Start date in Unix format: return only dispute documents that have CreationDate BEFORE this date.
     *
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
     * End date in Unix format: return only dispute documents that have CreationDate AFTER this date.
     *
     * @deprecated Use {@link #getAfterDate()} and {@link #setAfterDate(Long)} instead.
     */
    @Deprecated
    public Long AfterDate;

    public DisputeDocumentStatus getStatus() {
        return Status;
    }

    public void setStatus(DisputeDocumentStatus status) {
        this.Status = status;
    }

    public DisputeDocumentType getType() {
        return Type;
    }

    public void setType(DisputeDocumentType type) {
        this.Type = type;
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

        if (Status != null) result.put("Status", Status.toString());
        if (Type != null) result.put("Type", Type.toString());
        if (BeforeDate != null) result.put("BeforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("AfterDate", Long.toString(AfterDate));

        return result;
    }
}
