package com.mangopay.core;

import java.util.ArrayList;

/**
 * Base abstract class for entities. Provides common properties.
 */
public abstract class EntityBase extends Dto {

    /**
     * Unique identifier.
     */
    public String Id;

    /**
     * Custom data.
     */
    public String Tag;

    /**
     * Date of creation (UNIX timestamp).
     */
    public long CreationDate;
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = new ArrayList<>();
        
        result.add("Id");
        result.add("CreationDate");
        
        return result;
    }
}
