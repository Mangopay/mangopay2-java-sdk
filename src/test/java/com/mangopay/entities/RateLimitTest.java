package com.mangopay.entities;

import com.mangopay.core.BaseTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests concerning rate limit data storage and update.
 * <p>
 * Created by thepa on 28-Jul-17.
 */
public class RateLimitTest extends BaseTest {

    @Test
    public void rateLimitsUpdateTest() throws Exception {
        assertNull(this.api.getRateLimits());

        getJohnsCardPreAuthorization();

        List<RateLimit> rateLimits = this.api.getRateLimits();

        assertNotNull(rateLimits);
        assertEquals(6, rateLimits.size());

        assertEquals(1440, rateLimits.get(0).getIntervalMinutes());
        assertEquals(60, rateLimits.get(1).getIntervalMinutes());
        assertEquals(30, rateLimits.get(2).getIntervalMinutes());
        assertEquals(15, rateLimits.get(3).getIntervalMinutes());
        assertEquals(5, rateLimits.get(4).getIntervalMinutes());
        assertEquals(1, rateLimits.get(5).getIntervalMinutes());
    }
}
