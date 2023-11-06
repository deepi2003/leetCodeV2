package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MathExcerciseTest {

    MathExcercise me = new MathExcercise();
    @Test
    void isHappy() {
        assertThat(me.isHappy(14)).isEqualTo(false);
        assertThat(me.isHappy(19)).isEqualTo(true);
        assertThat(me.isHappy(2)).isEqualTo(false);
        assertThat(me.isHappy(44)).isEqualTo(true);
    }


    @Test
    void testSolution() {
//        assertThat(me.solution(32)).isEqualTo(5);
    }
}