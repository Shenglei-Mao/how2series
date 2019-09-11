package com.ctci.scratch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Michael M
 */
public class Test2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{1, 1, 3};
        solution2.permuteUnique(nums);
    }

}


class Solution2 {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>(nums.length);
        for (int num : nums) {
            cur.add(num);
        }
        backtracking(nums, cur, 0);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> cur, int start) {
        if (start >= nums.length) {
            result.add(new ArrayList(cur));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) continue;
            swap(cur, start, i);
            backtracking(nums, cur, start + 1);
            swap(cur, start, i);
        }
    }

    private void swap(List<Integer> cur, int x, int y) {
        Integer temp = cur.get(x);
        cur.set(x, cur.get(y));
        cur.set(y, temp);
    }
}