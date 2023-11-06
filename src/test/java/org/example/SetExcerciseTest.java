package org.example;

import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SetExcerciseTest {

    @Test
    void test1() {

        SortedSet<String> tset = new TreeSet<>();
        tset.add("1_bar");
        tset.add("4_bar2");
    }


}