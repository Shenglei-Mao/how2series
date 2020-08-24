from typing import List
from collections import defaultdict

class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        # key: groupsize, value: List[List[int]]
        # scan input(could be stream), get the value (list of list)
        # if list contains 0 element, or last element is already key size, creat a new list and insert it into the map
        # finally, flat the map to a list

        # scan the stream
        lookup = defaultdict(list)
        for i, size in enumerate(groupSizes):
            v = lookup[size]
            if not v or len(v[-1]) == size:
                v.append([i])
            else:
                v[-1].append(i)
        result = list()
        # flat map
        for _, v in lookup.items():
            result.extend(v)
        return result


s = Solution()
rst = s.groupThePeople([3,3,3,3,3,1,3])
print(rst)
rst = s.groupThePeople([3,3,3,3,3,1,3])
print(rst)
