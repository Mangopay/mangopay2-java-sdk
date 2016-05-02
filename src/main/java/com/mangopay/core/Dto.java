package com.mangopay.core;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Base abstract class for entities.
 */
public abstract class Dto {
    
    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     * @return Collection of field name-field type pairs.
     */
    public Map<String, Type> getSubObjects() { return new HashMap<>(); }

    /**
     * Gets the structure that maps which property depends on other property.
     * To be overridden in child class if has any dependent objects.
     * @return 
     */
    public Map<String, Map<String, Map<String, Class<?>>>> getDependentObjects() { return new HashMap<>(); }
    
    /**
     * Gets map of fields and values. 
     * To be overridden in child class.
     * @return Collection of field name-field value pairs.
     */
    public Map<String, String> getValues() { return new HashMap<>(); }
    
    /**
     * Gets the collection of read-only fields names.
     * To be overridden in child class.
     * @return List of field names.
     */
    public ArrayList<String> getReadOnlyProperties() { return new ArrayList<>(); }
    
}
