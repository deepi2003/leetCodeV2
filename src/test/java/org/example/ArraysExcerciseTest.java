package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArraysExcerciseTest {

    ArraysExcercise ae = new ArraysExcercise();

    @Test
    void testArrayMerge() {
        int[] res = ae.merge3(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, res);

        res = ae.merge3(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, res);


//
//        res =  ae.merge(new int[]{1}, 1, new int[] {}, 0);
//        assertArrayEquals(new int[] {1}, res);
//
//        res =  ae.merge(new int[]{0}, 0, new int[] {1}, 1);
//        assertArrayEquals(new int[] {1}, res);
    }

    @Test
    void testRemoveElement() {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int res;
        res = ae.removeElement3(nums, 2);

        assertEquals(5, res);
        assertArrayEquals(new int[]{0, 1, 4, 0, 3, 2, 2, 2}, nums);


        nums = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        res = ae.removeElement3(nums, 4);

        assertEquals(4, res);
        assertArrayEquals(new int[]{0, 2, 0, 0, 4, 4, 4, 4, 4}, nums);
    }

    @Test
    public void testRemoveDuplicates() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res;
        res = ae.removeDuplicates2(nums);
        assertEquals(5, res);
        assertArrayEquals(new int[]{0,1,2,3,4,0,1,1,2,3},  nums);

        nums= new int[] {1,1};
        res = ae.removeDuplicates2(nums);
        assertEquals(1, res);
        assertArrayEquals(new int[]{1},  nums);
    }


    @Test
    public void testRemoveDuplicates3() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int res;
        res = ae.removeDuplicates3(nums);
        assertEquals(7, res);
//        assertArrayEquals(new int[]{0,0,1,1,2,3,3,1,1},  nums);

//        nums= new int[] {1,1,1,2,2,3};
//        res = ae.removeDuplicates3(nums);
//        assertEquals(5, res);
//        assertArrayEquals(new int[]{1,1,2,2,3,1},  nums);

        nums= new int[] {1,2,3};
        res = ae.removeDuplicates3(nums);
        assertEquals(3, res);
        assertArrayEquals(new int[]{1,2,3},  nums);
    }

    @Test
    void testMajorityElement() {
        int[] nums = {2,2,1,1,1,2,2};
        int res;
        res = ae.majorityElement3(nums);
        assertEquals(2, res);
        res = ae.majorityElement3(new int[] {3,2,3});
        assertEquals(3, res);
        res = ae.majorityElement3(new int[] {3,3,4});
        assertEquals(3, res);
        res = ae.majorityElement3(new int[] {1000,2,1001,1000,1000});
        assertEquals(1000, res);

    }

    @Test
    void testRotate() {
        int[] nums;
        nums = new int[]{1,2,3,4,5,6,7};
//        ae.rotate3(nums, 3);
//        assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
        nums = new int[]{1,2};
        ae.rotate3(nums, 3);
        assertArrayEquals(new int[]{2,1}, nums);
    }

    @Test
    void testMaxProfit() {
        int[] nums;
        nums = new int[]{7,1,5,3,6,4};
        int res;
        res = ae.maxProfit3(nums);
        assertEquals(7, res);
    }

    @Test
    void twoSum() {
        assertThat(ae.twoSumV2(new int[]{2,7,11,15}, 9)).containsExactlyInAnyOrder(0,1);
        assertThat(ae.twoSumV2(new int[]{3,2,4}, 6)).containsExactlyInAnyOrder(1,2);
        assertThat(ae.twoSumV2(new int[]{3,3}, 6)).containsExactlyInAnyOrder(0,1);
        assertThat(ae.twoSumV2(new int[]{0,4,3,0}, 0)).containsExactlyInAnyOrder(0,3);
    }

    @Test
    void containsNearbyDuplicate() {
        assertThat(ae.containsNearbyDuplicateV3(new int[]{1,2,3,1}, 3)).isTrue();
        assertThat(ae.containsNearbyDuplicateV3(new int[]{1,0,1,1}, 1)).isTrue();
        assertThat(ae.containsNearbyDuplicateV3(new int[]{1,2,3,1,2,3}, 2)).isFalse();
        assertThat(ae.containsNearbyDuplicateV3(new int[]{99, 99}, 2)).isTrue();
    }

    @Test
    void longestConsecutive() {
//        assertThat(ae.longestConsecutive(new int[] {100,4,200,1,3,2})).isEqualTo(4);
        assertThat(ae.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1})).isEqualTo(9);
    }

    @Test
    void merge() {;
//        assertThat(ae.merge2(new int[][]{{1,3},{2,6},{8,10},{15,18}})).containsExactlyInAnyOrder(new int[][]{{1,6},{8,10},{15,18}});
//        assertThat(ae.merge2(new int[][]{{1,4},{0,1}})).containsExactlyInAnyOrder(new int[][]{{0,4}});
        assertThat(ae.merge2(new int[][]{{1,4},{0,0}})).containsExactlyInAnyOrder(new int[][]{{0,0},{1,4}});
    }

    @Test
    void insert() {
        assertThat(ae.insert2(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}))
                .containsExactlyInAnyOrder(new int[][]{{1,2},{3,10},{12,16}});

        assertThat(ae.insert2(new int[0][0], new int[]{5,7}))
                .containsExactlyInAnyOrder(new int[][]{{5,7}});
        assertThat(ae.insert2(new int[][]{{1,3},{6,9}}, new int[]{2,5}))
                .containsExactlyInAnyOrder(new int[][]{{1,5},{6,9}});

        assertThat(ae.insert2(new int[][]{{1,5}}, new int[]{0,0}))
                .containsExactlyInAnyOrder(new int[][]{{0,0},{1,5}});

        assertThat(ae.insert2(new int[][]{{1,5}}, new int[]{6,8}))
                .containsExactlyInAnyOrder(new int[][]{{1,5},{6,8}});



    }

    @Test
    void summaryRanges() {
        assertThat(ae.summaryRangesv2(new int[]{0,1,2,4,5,7})).containsExactlyInAnyOrderElementsOf(List.of("0->2","4->5","7"));
        assertThat(ae.summaryRangesv2(new int[]{0,2,3,4,6,8,9})).containsExactlyInAnyOrderElementsOf(List.of("0","2->4","6","8->9"));
    }

    @Test
    void hIndex() {

        assertThat(ae.hIndexv2(new int[]{1,2})).isEqualTo(1);
        assertThat(ae.hIndexv2(new int[]{3,0,6,1,5})).isEqualTo(3);
        assertThat(ae.hIndexv2(new int[]{0,1})).isEqualTo(1);
    }

    @Test
    void productExceptSelf() {
//        assertThat(ae.productExceptSelf(new int[]{1,2,3,4})).containsExactly(24,12,8,6);
        assertThat(ae.productExceptSelf(new int[]{-1,1,0,-3,3})).containsExactly(0,0,9,0,0);
    }

    @Test
    void canCompleteCircuit() {
        assertThat(ae.canCompleteCircuitV2(new int[]{2}, new int[]{2})).isEqualTo(0);
        assertThat(ae.canCompleteCircuitV2(new int[]{2}, new int[]{2})).isEqualTo(0);
        assertThat(ae.canCompleteCircuitV2(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1})).isEqualTo(4);
        assertThat(ae.canCompleteCircuitV2(new int[]{3,3,4}, new int[]{3,4,4})).isEqualTo(-1);
        assertThat(ae.canCompleteCircuitV2(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})).isEqualTo(3);
        assertThat(ae.canCompleteCircuitV2(new int[]{2,3,4}, new int[]{3,4,3})).isEqualTo(-1);
        assertThat(ae.canCompleteCircuitV2(new int[]{5,8,2,8}, new int[]{6,5,6,6})).isEqualTo(3);

        /*
        1, -3, 1, -2, 3

        -2, -2, -2, 3, 3

        -1, 3, -4, 2

         */
    }

    @Test
    void candy() {
        assertThat(ae.candy(new int[] {1,2,87,87,87,2,1})).isEqualTo(13);
        assertThat(ae.candy(new int[] {1,3,2,2,1})).isEqualTo(7);
        assertThat(ae.candy(new int[] {1,3,4,2,1})).isEqualTo(9);
        assertThat(ae.candy(new int[] {1,3,4,2,5})).isEqualTo(9);
        assertThat(ae.candy(new int[] {1,0,2})).isEqualTo(5);
        assertThat(ae.candy(new int[] {1,2,2})).isEqualTo(4);
    }

    @Test
    void jump() {
//        assertThat(ae.jump(new int[] {2,3,1,1,4})).isEqualTo(2);
//        assertThat(ae.jump(new int[] {2,0,2,0,1})).isEqualTo(2);
        assertThat(ae.jump(new int[] {4,1,1,3,1,1,1})).isEqualTo(2);
    }

    @Test
    void rotateLeft() {
        assertThat(ae.rotateLeft(4, List.of(1,2,3,4,5))).containsExactly(5,1,2,3,4);
    }

    @Test
    void largestRectangle() {
        assertThat(ArraysExcercise.largestRectangle(List.of(11,11,10,10,10))).isEqualTo(50);
    }

    @Test
    void search() {
//        assertThat(new ArraysExcercise().search(new int[]{-1,0,3,5,9,12}, 9)).isEqualTo(4);
        assertThat(new ArraysExcercise().search(new int[]{-1,0,3,5,9,12}, 2)).isEqualTo(-1);
    }

    @Test
    void test1() {
        assertThat(new ArraysExcercise().minEatingSpeed(new int[]{ 332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184}, 823855818)).isEqualTo(50);
    }

}