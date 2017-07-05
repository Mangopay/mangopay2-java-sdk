package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.MandateStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Filters for mandates list.
 */
public class FilterMandates extends Dto {

    /**
     * Status of mandates.
     */
    @SerializedName("Status")
    private MandateStatus status;

    /**
     * Start date in Unix format.
     */
    @SerializedName("BeforeDate")
    private Long beforeDate;

    /**
     * End date in Unix format.
     */
    @SerializedName("AfterDate")
    private Long afterDate;

    public MandateStatus getStatus() {
        return status;
    }

    public void setStatus(MandateStatus status) {
        this.status = status;
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

        if (status != null && status != MandateStatus.NotSpecified) {
            result.put("status", status.name());
        }

        if (beforeDate != null) result.put("beforeDate", Long.toString(beforeDate));
        if (afterDate != null) result.put("afterDate", Long.toString(afterDate));

        return result;
    }

}
