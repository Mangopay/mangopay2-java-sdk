package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.EventType;
import com.mangopay.core.enumerations.HookStatus;
import com.mangopay.core.enumerations.Validity;

/**
 * Hooks and Notifications entity.
 */
public class Hook extends EntityBase {

    /**
     * This is the URL where you receive notification for various event types.
     */
    @SerializedName("Url")
    private String url;

    /**
     * Hook status.
     */
    @SerializedName("Status")
    private HookStatus status;

    /**
     * Hook validity.
     */
    @SerializedName("Validity")
    private Validity validity;

    /**
     * Event type (the <code>EventType.ALL</code> value is forbidden here).
     */
    @SerializedName("EventType")
    private EventType eventType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HookStatus getStatus() {
        return status;
    }

    public void setStatus(HookStatus status) {
        this.status = status;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
