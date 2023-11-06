package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecursionExcerciseTest {

    @Test
    void getWays() {
        assertThat(RecursionExcercise.getWays(4, List.of(1L,2L,3L))).isEqualTo(4);
    }
}