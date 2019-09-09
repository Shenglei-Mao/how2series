package com.ctci.chap4.tree.and.graph.ex8;

/**
 * @author : Michael M
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
    class Result {
        //TODO make it private and using setter & getter
        public TreeNode node;
        public boolean isAncestor;
        public Result(TreeNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result res = lowestCommonAncestorHelper(root, p, q);
        return res.node;
    }

    private Result lowestCommonAncestorHelper(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return new Result(null, false);
        }

        Result leftResult = lowestCommonAncestorHelper(cur.left, p, q);
        if (leftResult.isAncestor == true) {
            return leftResult;
        }
        Result rightResult = lowestCommonAncestorHelper(cur.right, p, q);
        if (rightResult.isAncestor == true) {
            return rightResult;
        }
        if ((leftResult.node == p || leftResult.node == q) && (rightResult.node == p || rightResult.node == q)) {
            return new Result(cur, true);
        }
        if ((leftResult.node == p || leftResult.node == q) && (cur == p || cur == q)) {
            return new Result(cur, true);
        }
        if (cur == p) {
            return new Result(p, false);
        }
        if (cur == q) {
            return new Result(q, false);
        }
        return (leftResult.node != null)? leftResult: rightResult;
    }


}