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
        assertTrue(rateLimits.size() == 4);
    }
}
