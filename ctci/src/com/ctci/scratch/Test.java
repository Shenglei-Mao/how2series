package com.ctci.scratch;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Michael M
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int jump = solution.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
        System.out.println(LocalDate.now(ZoneId.of("Asia/Shanghai")));
        System.out.println(Instant.now());
        System.out.println(LocalDateTime.now() + " Asia/Shanghai");

        OuterClass.InnerClass1 innerClass1 = new OuterClass.InnerClass1();

        System.out.println(getID(-6, 5));
        System.out.println(-6/5);

        Set<Integer> set = new HashSet<>();
        set.add(20);
        for (Integer i : set) {
            System.out.println(i);
        }
    }

    private static long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;

    }
}

class Solution {
    public int jump(int[] nums) {
        int[] count = new int[nums.length];

        Arrays.fill(nums, -1);
        for (int i = nums.length - 1; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for (int j = i + nums[i]; j >= i + 1; j--) {
                min = Math.min(min, nums[j] + 1);
            }
            count[i] = min;
        }
        return count[0];
    }
}