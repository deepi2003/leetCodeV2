package org.example.patterns;

import org.example.patterns.DynamicProgramming;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DynamicProgrammingTest {

    @Test
    void climbingStairs() {
        assertThat(new DynamicProgramming().climbingStairsV4(4,3)).isEqualTo(7);

    }

    @Test
    void coinChange() {
        assertThat(new DynamicProgramming().coinChange(new int[]{2},3)).isEqualTo(-1);
    }

    @Test
    void maxProfit() {
        assertThat(new DynamicProgramming().maxProfitV2(new int[]{1,5,8,9,10, 17,17, 20},8)).isEqualTo(22);
        assertThat(new DynamicProgramming().maxProfitV2(new int[]{3,5,8,9,10, 17,17, 20},8)).isEqualTo(24);
    }

    @Test
    void minJump() {
        assertThat(new DynamicProgramming().jumpv2(new int[]{2,3,0,1,4})).isEqualTo(2);
        assertThat(new DynamicProgramming().jumpv2(new int[]{3,4,2,1,2,3,7,1,1,1,2,5})).isEqualTo(4);
        assertThat(new DynamicProgramming().jumpv2(new int[]{2,3,1,1,4})).isEqualTo(2);
    }

    @Test
    void minFrogJump() {
        assertThat(new DynamicProgramming().minFrogJump(new int[]{10,30,40, 20})).isEqualTo(30);
        assertThat(new DynamicProgramming().minFrogJump(new int[]{30,10,60,10,60,50})).isEqualTo(40);
    }


    @Test
    void adjacentSum() {
        assertThat(new DynamicProgramming().adjacentSumV2(new int[]{6,10,12,7,9,14})).isEqualTo(32);
    }

    @Test
    void longestIncreasingSubsequence() {
        assertThat(new DynamicProgramming().LongestIncreasingSubsequence(new int[]{3,50,4,150, 8,30,200})).isEqualTo(5);
        assertThat(new DynamicProgramming().LongestIncreasingSubsequence(new int[]{50,4,10,8,30,100})).isEqualTo(4);
        assertThat(new DynamicProgramming().LongestIncreasingSubsequence(new int[]{50,4,10,8,30,100,2})).isEqualTo(4);
    }

    @Test
    void boxStacking() {
        assertThat(new DynamicProgramming().BoxStacking(new int[][]{new int[]{2,1,2},new int[]{3,2,3},
                new int[]{2,2,8}, new int[]{2,3,4},
                new int[]{2,2,1}, new int[]{4,4,5} })).isEqualTo(10);

    }

    @Test
    void lSTs() {
        assertThat(new DynamicProgramming().countBSTs(3)).isEqualTo(5);

    }

    @Test
    void test1() {
        assertThat(new DynamicProgramming().maxProduct(new int[] {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0}))
                .isEqualTo(1000000000);
    }



}