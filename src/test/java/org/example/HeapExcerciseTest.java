package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeapExcerciseTest {

    @Test
    void cookies() {
        assertThat(HeapExcercise.cookies(10, List.of(1,1,1))).isEqualTo(-1);
    }

    @Test
    void test1(){
        HeapExcercise.KthLargest k = new HeapExcercise.KthLargest(3, new int[]{4, 5, 8, 2});
        assertThat(k.add(3)).isEqualTo(4);
    }

    @Test
    void test3() {
        assertThat(new HeapExcercise().lastStoneWeight(new int[]{2,7,4,1,8,1})).isEqualTo(1);
    }

    @Test
    void test4() {
        assertThat(new HeapExcercise().kClosest(new int[][]{ {1,3}, {-2,2}}, 1)).isEqualTo(new int[][]{{-2, 2}});
    }

    @Test
    void test5() {
//        assertThat(new HeapExcercise().findKthLargest(new int[]{3,2,1,5,6,4}, 2)).isEqualTo(5);
    }

}