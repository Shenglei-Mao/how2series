#
# 返回两次操作后，数组元素之和的最小值
# @param nums int整型一维数组 这你你需要操作的数组
# @return long长整型
#
class Solution:
    def minimumValueAfterDispel(self, nums):
        """
        列举所有可能
        """
        total = len(nums)
        nums = sorted(nums)
        one, two = nums[-1], nums[-2]
        return sum(nums) - total * (one + two)
