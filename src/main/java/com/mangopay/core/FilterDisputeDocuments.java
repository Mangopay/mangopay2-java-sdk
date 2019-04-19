package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
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
     */
    @SerializedName("Status")
    private DisputeDocumentStatus status;

    /**
     * Dispute document type.
     */
    @SerializedName("type")
    private DisputeDocumentType type;

    /**
     * Start date in Unix format: return only dispute documents that have CreationDate BEFORE this date.
     */
    @SerializedName("BeforeDate")
    private Long beforeDate;

    /**
     * End date in Unix format: return only dispute documents that have CreationDate AFTER this date.
     */
    @SerializedName("AfterDate")
    private Long afterDate;

    public DisputeDocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DisputeDocumentStatus status) {
        this.status = status;
    }

    public DisputeDocumentType getType() {
        return type;
    }

    public void setType(DisputeDocumentType type) {
        this.type = type;
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

    /**
     * Gets map of fields and values.
     *
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();

        if (status != null) result.put("Status", status.toString());
        if (type != null) result.put("type", type.toString());
        if (beforeDate != null) result.put("BeforeDate", Long.toString(beforeDate));
        if (afterDate != null) result.put("AfterDate", Long.toString(afterDate));

        return result;
    }
}
