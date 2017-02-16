package com.mangopay.core;

import com.mangopay.core.enumerations.EventType;
import com.mangopay.entities.Event;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * EventApiImpl test methods
 */
public class EventApiImplTest extends BaseTest {

    @Test
    public void getEvents() throws Exception {

        FilterEvents eventsFilter = new FilterEvents();
        eventsFilter.setType(EventType.PAYIN_NORMAL_CREATED);

        List<Event> getEvents = this.api.getEventApi().get(eventsFilter, null, null);

        eventsFilter.setType(EventType.ALL);
        List<Event> getAllEvents = this.api.getEventApi().get(eventsFilter, null, null);

        assertNotNull(getEvents);
        assertNotNull(getAllEvents);
    }
}
