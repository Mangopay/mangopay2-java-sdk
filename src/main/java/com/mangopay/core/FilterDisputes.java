package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for disputes list.
 */
public class FilterDisputes extends Dto {

    /**
     * Start date in Unix format: return only disputes that have CreationDate BEFORE this date.
     */
    @SerializedName("BeforeDate")
    private Long beforeDate;

    /**
     * End date in Unix format: return only disputes that have CreationDate AFTER this date.
     */
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

    /**
     * Gets map of fields and values.
     *
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();

        if (beforeDate != null) result.put("BeforeDate", Long.toString(beforeDate));
        if (afterDate != null) result.put("AfterDate", Long.toString(afterDate));

        return result;
    }
}
