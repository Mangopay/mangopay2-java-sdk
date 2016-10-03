package com.mangopay.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for reports list.
 */
public class FilterReportsList {

    public Long BeforeDate;

    public Long AfterDate;

    public Map<String, String> getValues()
    {
        Map<String, String> result = new HashMap<>();

        if (BeforeDate != null) result.put("BeforeDate", BeforeDate.toString());
        if (AfterDate != null) result.put("AfterDate", AfterDate.toString());

        return result;
    }
    
}
