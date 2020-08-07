from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        s = sum(nums)
        left_acc = 0
        for i, num in enumerate(nums):
            right_acc = s - left_acc - num
            if left_acc == right_acc: return i
            else: left_acc += num
        return -1

s = Solution()
rst = s.pivotIndex([1,7,3,6,5,6])
print(rst)
rst = s.pivotIndex([1,2,3])
print(rst)
rst = s.pivotIndex([])
print(rst)
rst = s.pivotIndex([1])
print(rst)