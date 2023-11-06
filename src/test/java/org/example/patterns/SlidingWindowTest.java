package org.example.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowTest {

    @Test
    void housing() {
        assertThat(new SlidingWindow().housing(new int[] {1,3,2,1,4,1,3,2,1,1,2}, 8))
                .containsExactlyInAnyOrder(new int[]{2,5}, new int[]{4,6}, new int[] {5,9});
        assertThat(new SlidingWindow().housingWithNegative(new int[] {1,3,2,1,-4,4,1,3,-2,2,1,-1}, 8))
                .containsExactlyInAnyOrder(new int[]{0,6}, new int[]{2,10});
    }

    @Test
    void largestSubStringWithoutRepeatingChars() {
        assertThat(new SlidingWindow().largestSubStringWithoutRepeatingChars("prateekbhaiya")).isEqualTo("ekbhaiy");
        assertThat(new SlidingWindow().largestSubStringWithoutRepeatingChars("aabcb")).isEqualTo("abc");
    }

    @Test
    void StringWINDOW() {
        assertThat(new SlidingWindow().stringWindow("helllo_wprld", "lelo")).isEqualTo("elllo");
        assertThat(new SlidingWindow().stringWindow("helllo_wprelold", "lelo")).isEqualTo("elol");
        assertThat(new SlidingWindow().stringWindow("hellelo_wprld", "lelo")).isEqualTo("lelo");
    }


    @Test
    void smallestWindow() {
        assertThat(new SlidingWindow().smallestWindow("aabcbcdbcaaad")).isEqualTo("dbca");
        assertThat(new SlidingWindow().smallestWindow("aaaa")).isEqualTo("a");
        assertThat(new SlidingWindow().smallestWindow("aabcbcdbcaaadz")).isEqualTo("dbcaaadz");
    }
}