from typing import List
# TODO: 1. Optimize in Space;
#       2. Return the Actual Set


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        # init_state: dp[0][0] true dp[0][..] false dp[..][0] false
        # state: dp[i][s]: bool -> means if we could use first (i) elements to get the sum (s)
        # sub_problem: dp[i][s] = dp[i-1][s] or dp[i-1][s - val[i]]
        # if there is any dp[..][s] is true, our target (sum/2) is reachable
        total = sum(nums)
        n = len(nums)
        if total % 2 != 0: return False
        total = total//2
        dp = [[False for _ in range(total + 1)] for _ in range(n+1)]
        dp[0][0] = True
        for i in range(1, n+1):
            for j in range(1, total + 1):
                if j-nums[i-1] < 0:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i-1]]
                if j == total and dp[i][j]: return True
        return False


s = Solution()
# rst = s.canPartition([1, 5, 11, 5])
# print(rst)
# rst = s.canPartition([1, 2, 3, 5])
# print(rst)
# rst = s.canPartition([1, 2, 3])
# print(rst)
# rst = s.canPartition([1, 2])
# print(rst)
# rst = s.canPartition([2, 2])
# print(rst)
rst = s.canPartition([10])
print(rst)