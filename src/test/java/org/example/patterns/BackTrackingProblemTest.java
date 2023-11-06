package org.example.patterns;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BackTrackingProblemTest {

    @Test
    void findSubsets() {
        new BackTrackingProblem().findSubsets(new int[]{1,2,3});
    }

    @Test
    void combinationSum() {
        new BackTrackingProblem().combinationSum(new int[]{2,3,6,7}, 7);

    }

    @Test
    void testNumDecodings() {
       assertEquals(new BackTrackingProblem().letterCombinations("2"), Collections.emptyList());  ;
    }

}