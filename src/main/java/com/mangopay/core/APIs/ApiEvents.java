package com.mangopay.core.APIs;

import com.mangopay.core.FilterEvents;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Event;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ApiEvents {
    /**
     * Gets the events.
     * @param filter        Filters for events.
     * @param pagination    Pagination.
     * @return              List of events matching passed filter criteria.
     * @throws Exception
     */
    List<Event> get(FilterEvents filter, Pagination pagination, Sorting sorting) throws Exception;
}
