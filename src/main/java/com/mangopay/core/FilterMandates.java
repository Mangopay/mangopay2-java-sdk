package com.mangopay.core;

import com.mangopay.core.enumerations.MandateStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Filters for mandates list.
 */
public class FilterMandates extends Dto {

    /**
     * Status of mandates.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(MandateStatus)} instead.
     */
    @Deprecated
    public MandateStatus Status;

    /**
     * Start date in Unix format.
     *
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
     * End date in Unix format.
     *
     * @deprecated Use {@link #getAfterDate()} and {@link #setAfterDate(Long)} instead.
     */
    @Deprecated
    public Long AfterDate;

    public MandateStatus getStatus() {
        return Status;
    }

    public void setStatus(MandateStatus status) {
        this.Status = status;
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

        if (Status != null && Status != MandateStatus.NotSpecified) {
            result.put("status", Status.name());
        }

        if (BeforeDate != null) result.put("beforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("afterDate", Long.toString(AfterDate));

        return result;
    }

}
