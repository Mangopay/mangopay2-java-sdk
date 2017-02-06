package com.mangopay.entities;

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
     *
     * @deprecated Use {@link #getUrl()} and {@link #setUrl(String)} instead.
     */
    @Deprecated
    public String Url;

    /**
     * Hook status.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(HookStatus)} instead.
     */
    @Deprecated
    public HookStatus Status;

    /**
     * Hook validity.
     *
     * @deprecated Use {@link #getValidity()} and {@link #setValidity(Validity)} instead.
     */
    @Deprecated
    public Validity Validity;

    /**
     * Event type (the <code>EventType.ALL</code> value is forbidden here).
     *
     * @deprecated Use {@link #getEventType()} and {@link #setEventType(EventType)} instead.
     */
    @Deprecated
    public EventType EventType;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

    public HookStatus getStatus() {
        return Status;
    }

    public void setStatus(HookStatus status) {
        this.Status = status;
    }

    public Validity getValidity() {
        return Validity;
    }

    public void setValidity(Validity validity) {
        this.Validity = validity;
    }

    public EventType getEventType() {
        return EventType;
    }

    public void setEventType(EventType eventType) {
        this.EventType = eventType;
    }
}
