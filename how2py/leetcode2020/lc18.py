from typing import List


class Solution:
    def NSum(self, n: int, nums: List[int], target: int) -> List[List[int]]:
        """
        input requirement: 1. n >= 2; 2.nums should be a sorted list
        return: list of n sum result with no duplication
        terminal condition: 2 sum (use the fact, nums is sorted)
        non-terminal: break current question into 1 + (N-1) sum question. PS: the "1" should be different each time
        """
        if n < 2: raise Exception("N sould always great or equal to 2")
        if n == 2:
            if not nums: return []
            rst = list()
            left, right = 0, len(nums) - 1
            while left < right:
                left_val, right_val = nums[left], nums[right]
                if left_val + right_val == target:
                    rst.append([left_val, right_val])
                    while left + 1 < len(nums) and nums[left] == nums[left + 1]: left += 1
                    left += 1
                elif left_val + right_val <= target:
                    while left + 1 < len(nums) and nums[left] == nums[left + 1]: left += 1
                    left += 1
                else:
                    while right - 1 >= 0 and nums[right-1] == nums[right]: right -= 1
                    right -= 1
            return rst

        else:
            if not nums: return []
            rst = []
            prev = nums[0] - 1
            for i in range(len(nums)):
                cur = nums[i]
                if cur * n > target: break
                if nums[-1] * n < target: break
                if cur == prev: continue
                ret = self.NSum(n-1, nums[i+1::], target - nums[i])
                for e in ret:
                    e.append(cur)
                    rst.insert(0, e[::])
                prev = cur
            return rst


    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        return self.NSum(4, nums, target)


s = Solution()
rst = s.fourSum([1, 0, -1, 0, -2, 2], 0)
print(rst)
