package com.ctci.chap4.tree.and.graph.ex4;

/**
 * @author : Michael M
 * LeetCode 110
 * Check Balanced (Binary Tree)
 */
public class Question {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer integer = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    private boolean mark = true;

    public boolean isBalanced(TreeNode root) {

        heightOfTree(root);

        return mark;
    }


    /**
     * return the height of the tree which root is the current node
     */
    private int heightOfTree(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        if ((Math.abs(left - right) > 1)) {
            mark = false;
        }

        return Math.max(left, right) + 1;
    }
}