package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StackExcercisesTest {

    StackExcercises se = new StackExcercises();
    @Test
    void evalRPNV2() {
//        assertThat(se.evalRPNV2(new String[]{"2","1","+","3","*"})).isEqualTo(9);
        assertThat(se.evalRPNV2(new String[]{"4","13","5","/","+"})).isEqualTo(6);

    }

    @Test
    void twoStacks() {
        assertThat(StackExcercises.twoStacks(10, List.of(4,2,4,6,1), List.of(2,1,8,5))).isEqualTo(4);
    }

    @Test
    void OKTAQuestion() {
        assertThat(new StackExcercises().oktaQuestion("cr2[m]3[op4[s]]")).isEqualTo("crmmopssssopssssopssss");
    }

    @Test
    void isValid() {
        assertThat(new StackExcercises().isValid("()")).isEqualTo(true);
    }
}