package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.EventType;

import java.util.ArrayList;

/**
 * Event entity.
 */
public class Event extends EntityBase {

    /**
     * Resource identifier.
     *
     * @deprecated Use {@link #getResourceId()} and {@link #setResourceId(String)} instead.
     */
    @Deprecated
    public String ResourceId;

    /**
     * Type of event.
     *
     * @deprecated Use {@link #getEventType()} and {@link #setEventType(EventType)} instead.
     */
    @Deprecated
    public EventType EventType;

    /**
     * Date as UNIX timestamp.
     *
     * @deprecated Use {@link #getDate()} and {@link #setDate(long)} instead.
     */
    @Deprecated
    public long Date;

    public String getResourceId() {
        return ResourceId;
    }

    public void setResourceId(String resourceId) {
        this.ResourceId = resourceId;
    }

    public EventType getEventType() {
        return EventType;
    }

    public void setEventType(EventType eventType) {
        this.EventType = eventType;
    }

    public long getDate() {
        return Date;
    }

    public void setDate(long date) {
        this.Date = date;
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
