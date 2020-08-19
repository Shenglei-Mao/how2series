from typing import List

def uniquePairs(nums: List[int], target: int) -> int:
    """
    O(n) Solution
    [1, 5, 1, 5], target: 6
    0. maintain a prev set (store previous element, drop duplicate)
       maintain a result set (store ele already counted into result)
    1. scan through arr, for each element
       if it already in result set, continue
       else, if (target - e) is in the prev set, increment count, and put e and its complement into result set
             add cur ele into seen
    """
    seen = set()
    result_set = set()
    rst = 0
    for num in nums:
        if num in result_set: continue
        else:
            if (target - num) in seen:
                rst += 1
                result_set.add(num)
                result_set.add(target - num)
            seen.add(num)
    return rst


rst = uniquePairs([1, 5, 1, 5], 6)
print(rst)
rst = uniquePairs([1, 1, 2, 45, 46, 46], 47)
print(rst)
rst = uniquePairs([1, 1], 2)
print(rst)
rst = uniquePairs([1], 2)
print(rst)
