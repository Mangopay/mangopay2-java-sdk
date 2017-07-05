package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.EventType;

import java.util.ArrayList;

/**
 * Event entity.
 */
public class Event extends EntityBase {

    /**
     * Resource identifier.
     */
    @SerializedName("ResourceId")
    private String resourceId;

    /**
     * Type of event.
     */
    @SerializedName("EventType")
    private EventType eventType;

    /**
     * Date as UNIX timestamp.
     */
    @SerializedName("Date")
    private long date;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("ResourceId");
        result.add("EventType");
        result.add("Date");

        return result;
    }
}
