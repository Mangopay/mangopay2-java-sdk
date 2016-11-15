package com.mangopay.core;

import com.mangopay.core.enumerations.EventType;
import com.mangopay.entities.*;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiEvents test methods
 */
public class ApiEventsTest extends BaseTest {
    
    @Test
    public void getEvents() throws Exception {
        
        FilterEvents eventsFilter = new FilterEvents();
        eventsFilter.Type = EventType.PAYIN_NORMAL_CREATED;
        
        List<Event> getEvents = this.api.Events.get(eventsFilter, null, null);
        
        eventsFilter.Type = EventType.ALL;
        List<Event> getAllEvents = this.api.Events.get(eventsFilter, null, null);
        
        assertNotNull(getEvents);
        assertNotNull(getAllEvents);
    }
}
