from typing import List


class Solution:
    def twoSum(self, nums, start_idx, num, result):
        """
        find two sum a and b that equal -num from nums[start_idx...end] and append [num, a, b] to result
        important: unique pair!
        """
        left, right = start_idx, len(nums) - 1  # pointer
        left_prev, right_prev = nums[left] - 1, nums[right] + 1  # number
        while left < right:
            while left < len(nums) - 1 and nums[left] == left_prev:
                left_prev = nums[left]
                left += 1
            while right > start_idx and nums[right] == right_prev:
                right_prev = nums[right]
                right -= 1
            if left >= right: return
            two_sum = nums[left] + nums[right]
            if two_sum < -num:
                left_prev = nums[left]
                left += 1
            elif two_sum > -num:
                right_prev = nums[right]
                right -= 1
            else:
                result.append([num, nums[left], nums[right]])
                left_prev = nums[left]
                left += 1

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        """
        1. sort the arr in asc order
        2. for every element nums[i] in nums, find two sum equal -nums[i] at nums[i..end]
           since nums[i..end] is already sorted, we could use two pointers, left and right
        3. we need unique pair!
        """
        nums.sort()
        result = []
        n = len(nums)
        if n < 3: return result
        prev = nums[0] - 1
        for i, num in enumerate(nums):
            if i >= n - 2: break
            if prev == num: continue
            self.twoSum(nums, i + 1, num, result)
            prev = num
        return result
