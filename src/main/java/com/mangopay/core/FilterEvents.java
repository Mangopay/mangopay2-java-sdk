package com.mangopay.core;

import com.mangopay.core.enumerations.EventType;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for events list.
 */
public class FilterEvents extends Dto {

    /**
     * Type of events.
     *
     * @deprecated Use {@link #getType()} and {@link #setType(EventType)} instead.
     */
    @Deprecated
    public EventType Type;

    /**
     * Start date in Unix format.
     *
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
     * End date in Unix format.
     *
     * @deprecated Use {@link #getAfterDate()} and {@link #setAfterDate(Long)} instead.
     */
    @Deprecated
    public Long AfterDate;

    public EventType getType() {
        return Type;
    }

    public void setType(EventType type) {
        this.Type = type;
    }

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

        if (Type != EventType.ALL) {
            result.put("eventtype", Type.name());
        }

        if (BeforeDate != null) result.put("beforeDate", Long.toString(BeforeDate));
        if (AfterDate != null) result.put("afterDate", Long.toString(AfterDate));

        return result;
    }
}
