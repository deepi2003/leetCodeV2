package org.example;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
    @Test
    void test() {
        StackExcercises.MinStack st = new StackExcercises.MinStack();
        st.push(2147483646);
        st.push(2147483646);
        st.push(2147483647);
        assertThat(st.top()).isEqualTo(2147483647);
        st.pop();
        assertThat(st.getMin()).isEqualTo(2147483646);
        st.pop();
        assertThat(st.getMin()).isEqualTo(2147483646);
        st.pop();
        st.push(2147483647);
        assertThat(st.top()).isEqualTo(2147483647);
        assertThat(st.getMin()).isEqualTo(2147483647);
        /*
        ["push","top","getMin","pop","getMin"]
        [[-2147483648],[],[],[],[]]
         */



    }


}