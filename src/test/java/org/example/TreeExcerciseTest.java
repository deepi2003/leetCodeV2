package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TreeExcerciseTest {

    @Test
    void isSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        assertThat(new TreeExcercise().isSymmetric(root)).isEqualTo(false);
    }

    @Test
    void maxDepth() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        assertThat(new TreeExcercise().maxDepth(root)).isEqualTo(2);
    }

    @Test
    void flatten() {
        TreeNode node1 = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode node2 = new TreeNode(5, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, node1, node2);
        new TreeExcercise().flatten(root);
    }

    @Test
    void treeHeight() {
        TreeNode root = buildTree(List.of(3, 5, 2, 1, 4, 6, 7));
        assertThat(TreeExcercise.treeHeight(root)).isEqualTo(3);
    }


    @Test
    void buildTree() {
        TreeNode root = buildTree(List.of(3, 5, 2, 1, 4, 6, 7));
        assertThat(root.val).isEqualTo(3);
    }

    @Test
    void test1(){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1, null, node1);
        node1 = new TreeNode(4);
        TreeNode root = new TreeNode(3, node2, node1);
        assertThat(new TreeExcercise().kthSmallest(root, 1)).isEqualTo(1);
        }

    private TreeNode buildTree(List<Integer> list) {
        TreeNode root = new TreeNode(list.get(0));
        list.remove(list.get(0));
        for(Integer num: list) {
            insertNode(root, num);
        }
        return root;
    }

    private TreeNode insertNode(TreeNode node, int value) {
        if(node == null) {
            return  new TreeNode(value);
        }
        if(value < node.val) {
            node.left = insertNode(node.left, value);
            return node;
        }
        node.right = insertNode(node.right, value);
        return node;
    }


    private TreeNode findLeftMost(TreeNode node) {
        if(node.left == null)
            return node;
        return findLeftMost(node.left);
    }

    private TreeNode findRightMost(TreeNode node) {
        if(node.right == null)
            return node;
        return findRightMost(node.right);
    }



}