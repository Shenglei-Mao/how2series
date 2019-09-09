package com.ctci.chap4.tree.and.graph.ex5;

/**
 * @author : Michael M
 * LeetCode 98
 * Is valid binary tree
 */
public class Question {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBstRange(root, null, null);
    }

    private boolean isValidBstRange(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (!withinRange(node.val, min, max)) {
            return false;
        }
        return isValidBstRange(node.left, min, node.val)
            && isValidBstRange(node.right, node.val, max);
    }

    //TODO think of a way to optimize this logic!
    private boolean withinRange(int val, Integer min, Integer max) {
        if (min == null && max == null) {
            return true;
        }else if (min == null && val < max) {
            return true;
        }else if (max == null && val > min) {
            return true;
        }else if (min == null || max == null){
            return false;
        }else if (val > min && val < max) {
            return true;
        }

        return false;
    }
}