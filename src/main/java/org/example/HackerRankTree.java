package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class HackerRankTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        HackerRankTreeNode root = buildTree(arr);
        long result = HackerRankTree.treeHeight(root);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int treeHeight(HackerRankTreeNode root) {
        if(root == null)
            return 0;
        int leftHeight =  treeHeightHelper(root.left, 0);
        int rightHeight = treeHeightHelper(root.right, 0);
        return Math.max(leftHeight, rightHeight);
    }

    private static int treeHeightHelper(HackerRankTreeNode node, int height) {
        if(node == null  ||(node.left  == null && node.right == null))
            return height;
        height++;
        int leftHeight = treeHeightHelper(node.left, height);
        int rightHeight = treeHeightHelper(node.right, height);
        return Math.max(leftHeight, rightHeight);
    }

    public static HackerRankTreeNode buildTree(List<Integer> list) {
        HackerRankTreeNode root = new HackerRankTreeNode(list.get(0));
        for(int i =1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }
        return root;
    }

    private static HackerRankTreeNode insertNode(HackerRankTreeNode node, int value) {
        if(node == null) {
            return  new HackerRankTreeNode(value);
        }
        if(value < node.val) {
            node.left = insertNode(node.left, value);
            return node;
        }
        node.right = insertNode(node.right, value);
        return node;
    }

    public static HackerRankTreeNode LCA(HackerRankTreeNode root, int val1, int val2) {
       return  LCAHelper(root, val1, val2);
    }

    public static boolean isBinaryTree(HackerRankTreeNode root) {
        return isBinaryTreeHelper(root);
    }

    public static boolean isBinaryTreeHelper(HackerRankTreeNode node) {
        if(node == null) {
            return true;
        }
        if(node.left != null && node.left.val >= node.val)
            return false;
        if(node.right != null && node.right.val <= node.val)
            return false;

        if(!isBinaryTreeHelper(node.left)) {
            return false;
        }
        return isBinaryTreeHelper(node.right);
    }

    private static HackerRankTreeNode LCAHelper(HackerRankTreeNode node, int val1, int val2) {
        if(val1 <= node.val && val2 >= node.val)
                return node;
        if(val1 >= node.val && val2 <= node.val ) {
            return node;
        }
        if(val1 < node.val && val2 < node.val) {
            return LCAHelper(node.left, val1, val2);
        }
        return LCAHelper(node.right, val1, val2);
    }



}
class HackerRankTreeNode {
    int val;
    HackerRankTreeNode left;
    HackerRankTreeNode right;
    HackerRankTreeNode() {}
    HackerRankTreeNode(int val) { this.val = val; }
    HackerRankTreeNode(int val, HackerRankTreeNode left, HackerRankTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}