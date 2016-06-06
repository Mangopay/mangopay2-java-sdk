package com.mangopay.core;

import com.mangopay.core.enumerations.SortDirection;
import java.util.*;

/**
 * Base sorting object.
 */
public class Sorting {

    public static final Sorting NONE = null;
    
    /**
     * Fields separator in sort parameters for URL query.
     */
    public final String SortFieldSeparator = "_";
    
    /**
     * Sort query parameter name.
     */
    public final String SortUrlParameterName = "Sort";
    
    /**
     * Collection of fields to sort by and sort directions.
     */
    private Map<String, SortDirection> _sortFields;
    
    /**
     * Adds field to sort by.
     * @param fieldName     Property name to sort by.
     * @param sortDirection Sort direction.
     */
    public void addField(String fieldName, SortDirection sortDirection) {
        if (_sortFields == null) _sortFields = new HashMap<>();
        
        _sortFields.put(fieldName, sortDirection);
    }
    
    /**
     * Gets sort parameters.
     * @return 
     */
    public Map<String, String> GetSortParameter() {
        return new HashMap<String, String>() {{ put(SortUrlParameterName, _getFields()); }};
    }
    
    private String _getFields() {
        String sortValues = "";
        for (Map.Entry<String, SortDirection> entry : _sortFields.entrySet()) {
            if (!sortValues.equals(""))
                sortValues += SortFieldSeparator;
     
            sortValues += entry.getKey() + ":" + entry.getValue();
        }
        
        return sortValues;
    }
}