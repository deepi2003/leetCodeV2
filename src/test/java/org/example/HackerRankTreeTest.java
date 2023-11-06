package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HackerRankTreeTest {

    @Test
    void buildTree() {

        assertThat(HackerRankTree.buildTree(List.of(4, 2, 3, 1, 7, 6)).val).isEqualTo(4);
    }

    @Test
    void LCA() {
        HackerRankTreeNode root = HackerRankTree.buildTree(List.of(4, 2, 3, 1, 7, 6));
        assertThat(HackerRankTree.LCA(root, 1, 7).val).isEqualTo(4);

        HackerRankTreeNode root1 = HackerRankTree.buildTree(List.of(1,2));
        assertThat(HackerRankTree.LCA(root1, 1, 2).val).isEqualTo(1);

        HackerRankTreeNode root2 = HackerRankTree.buildTree(List.of(9,7,8,5,6,4,3,1));
        assertThat(HackerRankTree.LCA(root2, 1, 6).val).isEqualTo(5);
    }

    @Test
    void isBinaryTree() {
        HackerRankTreeNode root = HackerRankTree.buildTree(List.of(3,5,2,1,4,6));
        assertFalse(HackerRankTree.isBinaryTree(root));
    }
}