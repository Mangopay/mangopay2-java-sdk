package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for reports list.
 */
public class FilterReportsList {

    @SerializedName("BeforeDate")
    private Long beforeDate;

    @SerializedName("AfterDate")
    private Long afterDate;

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

    public Map<String, String> getValues() {
        Map<String, String> result = new HashMap<>();

        if (beforeDate != null) result.put("BeforeDate", beforeDate.toString());
        if (afterDate != null) result.put("AfterDate", afterDate.toString());

        return result;
    }
    
}
