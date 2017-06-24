package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.EventType;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter for events list.
 */
public class FilterEvents extends Dto {

    /**
     * Type of events.
     */
    @SerializedName("Type")
    private EventType type;

    /**
     * Start date in Unix format.
     */
    @SerializedName("BeforeDate")
    private Long beforeDate;

    /**
     * End date in Unix format.
     */
    @SerializedName("AfterDate")
    private Long afterDate;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Long getBeforeDate() {
        return beforeDate;
    }

    public void setBeforeDate(Long beforeDate) {
        this.beforeDate = beforeDate;
    }

    public Long getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(Long afterDate) {
        this.afterDate = afterDate;
    }

    /**
     * Gets map of fields and values.
     *
     * @return Collection of field name-field value pairs.
     */
    @Override
    public Map<String, String> getValues() {
        HashMap<String, String> result = new HashMap<>();

        if (type != EventType.ALL) {
            result.put("eventtype", type.name());
        }

        if (beforeDate != null) result.put("beforeDate", Long.toString(beforeDate));
        if (afterDate != null) result.put("afterDate", Long.toString(afterDate));

        return result;
    }
}
