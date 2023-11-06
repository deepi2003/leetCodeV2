package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScratchPadTest {

    @Test
    void sample() {
        String s = "1234";
        s.substring(2, 3);

        assertTrue((int) Math.round(Math.random()*6+1) <=6);
    }

}