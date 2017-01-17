package com.mangopay.core;

import com.mangopay.core.enumerations.SortDirection;
import java.util.*;

/**
 * Base sorting object.
 */
public class Sorting {
    
    /**
     * Fields separator in sort parameters for URL query.
     */
    private final String sortFieldSeparator = "_";
    
    /**
     * Sort query parameter name.
     */
    private final String sortUrlParameterName = "Sort";
    
    /**
     * Collection of fields to sort by and sort directions.
     */
    private Map<String, SortDirection> sortFields;
    
    /**
     * Adds field to sort by.
     * @param fieldName     Property name to sort by.
     * @param sortDirection Sort direction.
     */
    public void addField(String fieldName, SortDirection sortDirection) {
        if (sortFields == null) sortFields = new HashMap<>();
        
        sortFields.put(fieldName, sortDirection);
    }
    
    /**
     * Gets sort parameters.
     * @return 
     */
    public Map<String, String> GetSortParameter() {
        return new HashMap<String, String>() {{ put(sortUrlParameterName, getFields()); }};
    }
    
    public String getFields() {
        String sortValues = "";
        for (Map.Entry<String, SortDirection> entry : sortFields.entrySet()) {
            if (!sortValues.equals(""))
                sortValues += sortFieldSeparator;
     
            sortValues += entry.getKey() + ":" + entry.getValue();
        }
        
        return sortValues;
    }
}