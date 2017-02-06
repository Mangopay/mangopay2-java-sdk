package com.mangopay.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Filter for reports list.
 */
public class FilterReportsList {

    /**
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
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

    public Map<String, String> getValues() {
        Map<String, String> result = new HashMap<>();

        if (BeforeDate != null) result.put("BeforeDate", BeforeDate.toString());
        if (AfterDate != null) result.put("AfterDate", AfterDate.toString());

        return result;
    }
    
}
