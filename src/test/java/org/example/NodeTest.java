package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    GraphExcercise ge = new GraphExcercise();

    @Test
    void testCanFinish() {
//        assertTrue(ge.canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
//        assertFalse(ge.canFinish(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
        assertTrue(ge.canFinish(7, new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}));
    }
}