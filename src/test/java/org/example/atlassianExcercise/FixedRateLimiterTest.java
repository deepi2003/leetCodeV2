package org.example.atlassianExcercise;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class FixedRateLimiterTest {

    @Test
    void process() {
        FixedRateLimiter fixedRateLimiter = new FixedRateLimiter(4, 2);
            assertTrue(fixedRateLimiter.process(1, 1)) ;
            assertTrue(fixedRateLimiter.process(2, 1));
            assertTrue(fixedRateLimiter.process(3, 2));
            assertTrue(fixedRateLimiter.process(1, 3));
            assertFalse(fixedRateLimiter.process(1, 3));
            assertTrue(fixedRateLimiter.process(2, 4));
            assertFalse(fixedRateLimiter.process(2, 4));
            assertTrue(fixedRateLimiter.process(2, 5));
            assertTrue(fixedRateLimiter.process(2, 6));
            assertFalse(fixedRateLimiter.process(2, 6));

        }
    @Test
    void process2() {
        RollingWindowRateLimiter rollingWindowRateLimiter = new RollingWindowRateLimiter(2, 4);
        assertTrue(rollingWindowRateLimiter.process(1, 1)) ;
        assertTrue(rollingWindowRateLimiter.process(2, 1));
        assertTrue(rollingWindowRateLimiter.process(3, 2));
        assertTrue(rollingWindowRateLimiter.process(1, 3));
        assertTrue(rollingWindowRateLimiter.process(1, 5));
        assertTrue(rollingWindowRateLimiter.process(2, 2));
        assertFalse(rollingWindowRateLimiter.process(2, 3));
        assertFalse(rollingWindowRateLimiter.process(2, 4));
        assertTrue(rollingWindowRateLimiter.process(2, 5));
        assertTrue(rollingWindowRateLimiter.process(2, 6));
        assertFalse(rollingWindowRateLimiter.process(2, 6));

    }
}