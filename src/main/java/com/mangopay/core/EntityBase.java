package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Base abstract class for entities. Provides common properties.
 */
public abstract class EntityBase extends Dto {

    /**
     * Unique identifier.
     */
    @SerializedName("Id")
    private String id;

    /**
     * Custom data.
     */
    @SerializedName("Tag")
    private String tag;

    /**
     * Date of creation (UNIX timestamp).
     */
    @SerializedName("CreationDate")
    private long creationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
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
