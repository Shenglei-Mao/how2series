from typing import List
# TODO: Redo TLE

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        count = 0
        for i in range(n):
            acc = 0
            for j in range(i, n):
                acc = acc + nums[j]
                if acc == k:
                    count += 1
        return count


s = Solution()
rst = s.subarraySum([], 2)
print(rst)

