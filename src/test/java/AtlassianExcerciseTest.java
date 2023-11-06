package org.example.atlassianExcercise;

import org.example.atlassianExcercise.Trie;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AtlassianExcerciseTest {

    @Test
    void votingSystem() {
        String [] candidates = {"A", "C", "E", "B", "A", "B", "C", "B", "D", "B", "A"};
//        assertThat(new AtlassianExcercise().votingSystem(candidates)).isEqualTo("B");
    }

    @Test
    void searchRoute() {
        Trie trie = new Trie();
        trie.insert("jira.atlassian.com/testRoute/abc", "fooData1");
        trie.insert("jira.atlassian.com/testRoute/xyz", "fooData2");
        trie.insert("jira.atlassian.com/testRoute/", "fooData3");
        trie.insert("jira.atlassian.com/testRoute/abc/xyz", "fooData4");
        assertThat(trie.search("jira.atlassian.com/testRoute/*/xyz")).isEqualTo("fooData4");
        assertThat(trie.search("jira.atlassian.com/testRoute")).isEqualTo("fooData3");
        assertThat(trie.search("jira.atlassian.com/testRoute/abc")).isEqualTo("fooData1");
        assertThat(trie.search("jira.atlassian.com/testRoute/*")).isEqualTo("fooData1");
        assertThat(trie.search("jira.atlassian.com/*/xyz")).isEqualTo("fooData2");

    }
}