package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.EventApi;
import com.mangopay.core.FilterEvents;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Event;

import java.util.List;

/**
 * API for events.
 */
public class EventApiImpl extends ApiBase implements EventApi {

    /**
     * Instantiates new EventApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public EventApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public List<Event> get(FilterEvents filter, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Event[].class, Event.class, "events_all", pagination, "", filter.getValues(), sorting);
    }
}
