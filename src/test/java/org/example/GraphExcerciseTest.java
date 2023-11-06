package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraphExcerciseTest {

    @Test
    void connectedComponents() {

         assertThat(new GraphExcercise().connectedComponents(4, new int[][]{{0,1}, {1,2}, {3,4}})).isEqualTo(2);

    }
}