package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringExcerciseTest {

    StringExcercise se = new StringExcercise();
    @Test
    void reverseWords() {
        assertEquals("blue is sky the", se.reverseWords("the sky is blue"));
        assertEquals("world hello", se.reverseWords("  hello world  "));
        assertEquals("example good a", se.reverseWords("a good   example"));

    }

    @Test
    void strStr() {
//        assertEquals(0, se.strStr("sadbutsad", "sad"));
//        assertEquals(-1, se.strStr("leetcode", "leeto"));
        assertEquals(2, se.strStr("abc", "c"));
    }

    @Test
    void isAnagram() {
        assertTrue(se.isAnagramV2("anagram", "nagaram"));
        assertFalse(se.isAnagramV2("rat", "car"));
        assertFalse(se.isAnagramV2("aacc", "ccac"));
    }

    @Test
    void groupAnagrams() {
        List<List<String>> expected = List.of(List.of("bat"),List.of("nat","tan"),List.of("ate","eat","tea"));
        String[] input = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> actual = se.groupAnagramsV2(input);
//        assertThat(actual)
//                .containsExactlyInAnyOrderElementsOf(expected);

        assertThat(actual).usingRecursiveFieldByFieldElementComparator().containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void simplifyPath() {
//        assertThat(se.simplifyPathV2("/home//usr/../")).isEqualTo("/home");
        assertThat(se.simplifyPathV2("/../")).isEqualTo("/");
        assertThat(se.simplifyPathV2("/home//foo/")).isEqualTo("/home/foo");
        assertThat(se.simplifyPathV2("/home/")).isEqualTo("/home");
        assertThat(se.simplifyPathV2("/a/./b/../../c/")).isEqualTo("/c");
        assertThat(se.simplifyPathV2("/a//b////c/d//././/..")).isEqualTo("/a/b/c");
    }

    @Test
    void longestCommonPrefix() {
        assertThat(se.longestCommonPrefix(new String[]{"flower","flow","flight"})).isEqualTo("fl");
        assertThat(se.longestCommonPrefix(new String[]{"dog","racecar","car"})).isEqualTo("");
        assertThat(se.longestCommonPrefix(new String[]{"reflower","flow","flight"})).isEqualTo("");
    }


    @Test
    void testLengthOfLongestSubstring() {
        assertThat(se.lengthOfLongestSubstringV2("abcabcbb")).isEqualTo(3);
    }

    @Test
    void letterCombinations() {

    }
}