package com.ctci.chap4.tree.and.graph.ex2;

/**
 * @author : Michael M
 * lintCode 177
 * Minimal (Height) Tree
 */
public class Question {
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }

        return createMininaTree(A, 0, A.length - 1);
    }

    private TreeNode createMininaTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(A[start]);
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = createMininaTree(A, start, mid - 1);
        node.right = createMininaTree(A, mid + 1, end);
        return node;

    }
}
