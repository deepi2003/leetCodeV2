package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListExcerciseTest {

    @Test
    void test1() {
        ListNode node = new ListNode(5);
        node = new ListNode(4, node);
        node = new ListNode(3, node);
        node = new ListNode(2, node);
        node = new ListNode(1, node);
        ListNode actual = new LinkedListExcercise().reverseList(node);
        assertThat(actual.val).isEqualTo(5);
        assertThat(new LinkedListExcercise().hasCycle(node)).isFalse();
    }


    @Test
    void test2() {
        assertThat(new LinkedListExcercise().findDuplicate(new int[] {1, 3, 4, 2, 1})).isEqualTo(1);
    }
}