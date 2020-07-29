from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1] * n
        # pass one: left to right
        acc = nums[0]
        for i in range(1, n):
            result[i] = result[i] * acc
            acc *= nums[i]
        acc = nums[-1]
        for i in range(n-2, -1, -1):
            result[i] = result[i] * acc
            acc *= nums[i]
        return result


s = Solution()
rst = s.productExceptSelf([1,2,3,4])
print(rst)
