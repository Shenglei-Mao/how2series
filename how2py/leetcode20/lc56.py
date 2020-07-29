from typing import List


class Solution:
    @staticmethod
    def merge(intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        # Assume Sorted

        def overlap(i1: List[int], i2: List[int]) -> bool:
            if i1[1] >= i2[0]:
                return True
            else:
                return False

        def combine(i1, i2) -> List[int]:
            """
            combine two overlapped intervals
            """
            return [i1[0], max(i1[1], i2[1])]

        if not intervals or len(intervals) == 1:
            return intervals
        result = []
        for interval in intervals:
            if not result:
                result.append(interval)
            prev = result[-1]
            if overlap(prev, interval):
                result.append(combine(result.pop(), interval))
            else:
                result.append(interval)
        return result


rst1 = Solution.merge([[1,3],[2,6],[8,10],[15,18]])
rst2 = Solution.merge([[1,4],[4,5]])
print(rst1)
print(rst2)

