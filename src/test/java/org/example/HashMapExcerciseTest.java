package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HashMapExcerciseTest {
        HashMapExcercise he = new HashMapExcercise();

    @Test
    void romanToIntTest() {
        assertEquals(1994,he.romanToInt3("MCMXCIV") );
        assertEquals(3,he.romanToInt3("III") );
    }

    @Test
    void wordPattern() {
//        assertTrue(he.wordPatternV3("abba", "dog cat cat dog"));
//        assertFalse(he.wordPatternV3("abba", "dog cat cat fish"));
//        assertFalse(he.wordPatternV3("aaaa", "dog cat cat dog"));
        assertFalse(he.wordPatternV3("abba", "dog dog dog dog"));
    }


    @Test
    void intToRoman() {
//        assertThat(he.intToRoman(3)).isEqualTo("III");
//        assertThat(he.intToRoman(12)).isEqualTo("XII");
        assertThat(he.intToRoman(28)).isEqualTo("XXVIII");
        assertThat(he.intToRoman(58)).isEqualTo("LVIII");
        assertThat(he.intToRoman(99)).isEqualTo("XCIX");

    }
}