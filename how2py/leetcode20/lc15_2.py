from typing import List
from collections import Counter
import bisect
# TODO TRY No Sort

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # case1: three same elements  [0, 0, 0]
        # case2: two same elements [a, a, b]
        # case3: three distinct elements [a, b, c]
        # 1. Establish a counter key: element, value: num of occurrence O(n)
        # 2. find case1 O(1)
        # 3. find case2 by first fix b, then check if such a exist that sum(a, a, b) = 0 O(n)
        # 4. find case3 by first fix a negative a, then find b,c between [target-max, target//2], make sure b!=c
        c = Counter(nums)
        keys = sorted(c)
        result = list()
        for i, key in enumerate(keys):
            target = -key
            if key == 0:
                if c[key] >= 3:
                    result.append([0, 0, 0])
            else:
                a = target // 2
                if target % 2 == 0 and c[a] >= 2:
                    result.append([key, a, a])
            if key < 0:
                left_boundary = bisect.bisect_left(keys, target-keys[-1], i+1)
                right_boundary = bisect.bisect_right(keys, target // 2)
                for i in range(left_boundary, right_boundary):
                    if target - keys[i] in c and target - keys[i] != keys[i]:
                        result.append([key, target-keys[i], keys[i]])
        return result


s = Solution()
rst = s.threeSum([-1, 0, 1, 2, -1, -4])
print(rst)