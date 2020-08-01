from typing import List
from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        lookup = defaultdict(int)
        acc = 0
        count = 0
        lookup[0] = 1
        for num in nums:
            acc += num
            if acc - k in lookup:
                count += lookup[acc -k]
            lookup[acc] = lookup[acc] + 1
        return count


s = Solution()
rst = s.subarraySum([1, 1, 1], 2)
print(rst)
assert rst == 2
rst = s.subarraySum([1, 2, 3], 3)
print(rst)
assert rst == 2
rst = s.subarraySum([1, 2, 3, 0], 3)
print(rst)
assert rst == 3
rst = s.subarraySum([], 2)
print(rst)
assert rst == 0
rst = s.subarraySum([1, -1, 1, -1], 0)
print(rst)
assert rst == 4
