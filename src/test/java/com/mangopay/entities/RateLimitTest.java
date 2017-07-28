package com.mangopay.entities;

import com.mangopay.core.BaseTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests concerning rate limit data storage and update.
 * <p>
 * Created by thepa on 28-Jul-17.
 */
public class RateLimitTest extends BaseTest {

    @Test
    public void rateLimitsUpdateTest() throws Exception {
        User john = getJohn();

        List<RateLimit> initialRateLimits = this.api.getRateLimits();

        john = getJohn(true);

        List<RateLimit> updatedRateLimits = this.api.getRateLimits();

        assertEquals(initialRateLimits.size(), updatedRateLimits.size());

        for(int i = 0; i < initialRateLimits.size(); i++) {
            assertEquals(initialRateLimits.get(i).getCallsMade() + 1, updatedRateLimits.get(i).getCallsMade());
            assertEquals(initialRateLimits.get(i).getCallsRemaining() - 1, updatedRateLimits.get(i).getCallsRemaining());
        }
    }
}
