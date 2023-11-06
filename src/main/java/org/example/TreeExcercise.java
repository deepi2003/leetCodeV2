package org.example;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeExcercise {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if(root == null) {
            return ;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        int leftVal = -101;
        int rightVal = -101;
        if(left != null) {
            leftVal = left.val;
        }
        if(right != null) {
            rightVal = right.val;
        }
        if(leftVal != rightVal) {
            return  false;
        }
        if(!isSymmetricHelper(left.left, right.right)) {
            return false;
        }
        return isSymmetricHelper(left.right, right.left);
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = 1;
        int rightDepth = 1;
        return Math.max(maxDepthHelper(root.left, leftDepth), maxDepthHelper(root.right, rightDepth));
    }

    public int maxDepthHelper(TreeNode node, int result) {
        if(node == null) {
            return result;
        }
        result += 1;
        return Math.max(maxDepthHelper(node.left, result), maxDepthHelper(node.right, result));
    }


    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(root.right);
        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while(curr.right!= null) {
            curr = curr.right;
        }
        curr.right = right;
    }

    private void flattenHelper( TreeNode node) {
        if(node == null)
            return;
        flattenHelper(node.left);
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left!= null) {
            node.right = left;
        }
        if(node.right != null) {
            node.right.right = right;
        }
        node.left = null;

    }

    public static int treeHeight(TreeNode root) {
        if(root == null)
            return 0;
       int leftHeight =  treeHeightHelper(root.left, 0);
        int rightHeight = treeHeightHelper(root.right, 0);
        return Math.max(leftHeight, rightHeight);
    }

    private static int treeHeightHelper(TreeNode node, int height) {
        if(node == null  ||(node.left  == null && node.right == null))
            return height;
        height++;
        int leftHeight = treeHeightHelper(node.left, height);
        int rightHeight = treeHeightHelper(node.right, height);
        return Math.max(leftHeight, rightHeight);
    }

    int res = 0;
    int nodeCount = 0;
    public int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);
        return res;

    }


    void inOrder(TreeNode node, int k) {
        if(node == null)
            return;

        inOrder(node.left, k);
        if(nodeCount == k)
            return ;
        nodeCount++;
        res = node.val;
        inOrder(node.right, k);
    }


}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
