package chapter2;

public class Leetcode152 {
    public static void main(String[] args) {
        int[] input = {-4, -3, -2};
        input = new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(input));

    }

}
class Solution {
    public int maxProduct(int[] nums) {
        int max_here = nums[0];
        int min_here = nums[0];
        int max_so_far = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max_prev = max_here;
            /*max_here = max(cur, cur * max_here, cur * min_here*)*/
            max_here = Solution.triMax(nums[i], nums[i] * max_here, nums[i] * min_here);
            /*min_here = min(cur, cur * max_here, cur * min_here*)*/
            min_here = Solution.triMin(nums[i], nums[i] * max_prev, nums[i] * min_here);
            /*max_so_far = max(max_so_far, max_here)*/
            max_so_far = Math.max(max_so_far, max_here);
        }
        return max_so_far;

    }

    private static int triMax(int x, int y, int z){
        return Math.max(Math.max(x, y), z);
    }

    private static int triMin(int x, int y, int z){
        return Math.min(Math.min(x, y), z);
    }
}