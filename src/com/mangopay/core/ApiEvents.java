package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Event;
import java.util.List;

/**
 * API for events.
 */
public class ApiEvents extends ApiBase {
    
    /**
     * Instantiates new ApiEvents object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiEvents(MangoPayApi root) { super(root); }
    
    /**
     * Gets the events.
     * @param filter        Filters for events.
     * @param pagination    Pagination.
     * @return              List of events matching passed filter criteria.
     * @throws Exception
     */
    public List<Event> get(FilterEvents filter, Pagination pagination) throws Exception {
        return this.getList(Event[].class, Event.class, "events_all", pagination, "", filter.getValues(), null);
    }
}
