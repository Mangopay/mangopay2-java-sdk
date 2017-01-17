package com.mangopay.core;

import java.util.ArrayList;

/**
 * Base abstract class for entities. Provides common properties.
 */
public abstract class EntityBase extends Dto {

    /**
     * Unique identifier.
     *
     * @deprecated Use {@link #getId()} instead.
     */
    @Deprecated
    public String Id;

    /**
     * Custom data.
     *
     * @deprecated Use {@link #getTag()} and {@link #setTag(String)} instead.
     */
    @Deprecated
    public String Tag;

    /**
     * Date of creation (UNIX timestamp).
     *
     * @deprecated Use {@link #getCreationDate()} instead.
     */
    @Deprecated
    public long CreationDate;

    public String getId() {
        return Id;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        this.Tag = tag;
    }

    public long getCreationDate() {
        return CreationDate;
    }

    /**
     * Gets the collection of read-only fields names.
     *
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
