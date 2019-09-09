package com.ctci.chap4.tree.and.graph.ex0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Michael M
 * DFS Tree Traversal Without Revursion
 * LeetCode 94 In-order
 * LeetCode 144 Pre-order
 * LeetCode XXX Post-order (without using mirror pre-order)
 */
public class Question {
    public static void main(String[] args) {
        int x = -75;
        System.out.println(x >> 1);
        x = -75;
        System.out.println(x >>> 1);
        System.out.println(Integer.MAX_VALUE);
        x = 1;
        System.out.println(x << 1);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer i = new Integer(1);
        list.remove(i);
        System.out.println(list);

        System.out.println(f(3, 3));
    }
    private static int f(int x, int y) {
        if (y == 0) {
            return x;
        }

        return f(x*y, y-1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}


class Solution {

    /*In-order traversal iteratively with a stack*/
    public List<Integer> inorderTraversal(TreeNode root) {
        //TODO In Java, Using Deque(LinkedList or ArrayDeque) Instead In Real Project When No Synchronized Concern
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;

        }
        return result;
    }

    /*Morris Inorder Tree Traversal*/
    public List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;

        //TODO while condition
        while (cur != null) {
            /*base case - while no left node*/
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
                continue;
            }
            /*find the prenode, event when thread established*/
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }

            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                result.add(cur.val);
                pre.right = null;
                cur = cur.right;
            }
        }
        return result;
    }

    /*Pre-order traversal iteratively with a stack*/
    public List<Integer> preorderTraversal(TreeNode root) {
        //TODO In Java, Using Deque(LinkedList or ArrayDeque) Instead In Real Project When No Synchronized Concern
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
        return result;
    }

    /*Post-order traversal iteratively with a stack*/
    public List<Integer> postorderTraversal(TreeNode root) {
        //TODO In Java, Using Deque(LinkedList or ArrayDeque) Instead In Real Project When No Synchronized Concern
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (!stack.isEmpty() && cur.right == stack.peek()) {
                root = stack.pop();
                stack.add(cur);
            } else {
                result.add(cur.val);
                root = null;
            }

        }
        return result;
    }
}
