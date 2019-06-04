import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /*
    常量池测试
     */

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        String s5 = "a" + "bc";
        String s6 = s3.intern();
        String s7 = new String("def");
        String s8 = s7.intern();
        String s9 = s1.intern();

        /*
        prediction:
        s1 == s2
        s1 != s3
        s3 != s4
        s1 = s5;
        s3 ? s6
         */
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s1 == s5);
        System.out.println(s3 == s6);
        System.out.println(s1 == s6);
        System.out.println(s8 == "def");
        System.out.println(s9 == s1);


        Integer t1 = Integer.valueOf(1);
        Integer t2 = Integer.valueOf(1);
        System.out.println("Hello World");
        System.out.println(t1 == t2);
        Integer t3 = 1;
        System.out.println(t1 == t3);
        Integer t4 = Integer.valueOf(128);
        Integer t5 = Integer.valueOf(128);
        System.out.println(t4 == t5);
        Integer t6 = Integer.valueOf(127);
        Integer t7 = Integer.valueOf(127);
        System.out.println(t6 == t7);
        Integer t8 = new Integer(1);
        Integer t9 = new Integer(1);
        System.out.println(t8 == t9);

        List<String> l = new ArrayList<>();


        System.out.printf("------------------------------------------------------------------------------------%n");

        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(2);
        t.right = new TreeNode(20);
        t.right.left = null;
        t.right.right = new TreeNode(17);
        Solution sol = new Solution();
//        int depth = sol.minDepth(t);
////        System.out.println(depth);
        sol.flatten(t);
        System.out.println(t.right.val);

    }
}
