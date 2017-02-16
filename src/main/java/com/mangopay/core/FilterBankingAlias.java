package com.mangopay.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for banking alias list.
 */
public class FilterBankingAlias extends Dto {

    /**
     * Return only banking aliases that have creation date BEFORE this date.
     */
    public Long BeforeDate;
    /**
     * Return only banking aliases that have creation date AFTER this date.
     */
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
