package com.mangopay.core;

import com.mangopay.entities.*;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiEvents test methods
 */
public class ApiEventsTest extends BaseTest {
    
    @Test
    public void test_Events_Get() throws Exception {
        
        FilterEvents eventsFilter = new FilterEvents();
        eventsFilter.Type = EventType.PAYIN_NORMAL_CREATED;
        
        List<Event> getEvents = this._api.Events.get(eventsFilter, null);
        
        eventsFilter.Type = EventType.ALL;
        List<Event> getAllEvents = this._api.Events.get(eventsFilter, null);
        
        assertNotNull(getEvents);
        assertNotNull(getAllEvents);
    }
    
}
