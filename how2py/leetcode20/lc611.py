from typing import List
import bisect
# TODO Optimize


class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        # for each point pair (a, b), we will need to find the third poind c, where a <= b <= c and a + b > c
        n = len(nums)
        if n < 3: return 0
        nums.sort()
        count = 0
        for i in range(n-2):
            for j in range(i + 1, n-1):
                idx = bisect.bisect_left(nums, nums[i] + nums[j], j+1)
                count += (idx - 1 - (j + 1) + 1)
        return count


s = Solution()
rst = s.triangleNumber([2,2,3,4])
print(rst)

