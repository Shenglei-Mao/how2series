package com.ctci.chap4.tree.and.graph.ex0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Michael M
 * DFS Tree Traversal Without Revursion
 * LeetCode 94 In-order
 * LeetCode 144 Pre-order
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

    /*In-order traversal iteratively with a stack*/
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
}
