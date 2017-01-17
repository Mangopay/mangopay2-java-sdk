package com.mangopay.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for disputes list.
 */
public class FilterDisputes extends Dto {

    /**
     * Start date in Unix format: return only disputes that have CreationDate BEFORE this date.
     *
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
     * End date in Unix format: return only disputes that have CreationDate AFTER this date.
     *
     * @deprecated Use {@link #getAfterDate()} and {@link #setAfterDate(Long)} instead.
     */
    @Deprecated
    public Long AfterDate;

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

        if (BeforeDate != null) result.put("BeforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("AfterDate", Long.toString(AfterDate));

        return result;
    }
}
