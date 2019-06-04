//import javafx.util.Pair;
//
//import java.util.LinkedList;
//
//class Solution {
//    public int minDepth(TreeNode root) {
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        if (root == null) {
//            return 0;
//        } else {
//            stack.add(new Pair(root, 1));
//        }
////        System.out.println(root.val);
//        int min_depth = Integer.MAX_VALUE;
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> current = stack.pollLast();
//            root = current.getKey();
//            int current_depth = current.getValue();
//            System.out.println(root.val);
//            System.out.println(current_depth);
//            if ((root.left == null) && (root.right == null)) {
//                min_depth = Math.min(min_depth, current_depth);
//            }
//            if (root.right != null) {
//                stack.add(new Pair(root.right, current_depth + 1));
//            }
//            if (root.left != null) {
//                stack.add(new Pair(root.left, current_depth + 1));
//            }
//        }
//        return min_depth;
//    }
//}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        helper(root);
        return;
    }

    /*
     *@param: the root node for the tree to be flatten
     *@function：
     *@return: the last node
     */
    private TreeNode helper(TreeNode root){
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        if (root.left == null) return helper(root.right);


        TreeNode leftLast = helper(root.left);
        TreeNode originRight = root.right;
        root.right = root.left;
        root.left = null;
        leftLast.right = originRight;

        return helper(originRight);
    }
}