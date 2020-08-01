from typing import List
import heapq
# TODO: Try Quick Select


class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        if K == 0: return []
        if K == len(points): return points
        def distance(x, y) -> int:
            return x*x + y*y

        hp = []
        result = []
        # Sol: 0. maintain a max heap with size k
        #      1. iterate each point, compare with the max point in the heap
        #      3. at the end all point in the heap is the result
        for point in points:
            x, y = point[0], point[1]
            if len(hp) < K:
                heapq.heappush(hp, (-distance(x, y), [x, y]))
            else:
                heapq.heappush(hp, (-distance(x, y), [x, y]))
                heapq.heappop(hp)
        for point in hp:
            result.append(point[1])
        return result


s = Solution()
rst = s.kClosest([[3,3],[5,-1],[-2,4]], K = 2)
print(rst)
rst = s.kClosest([[1,3],[-2,2]], K = 1)
print(rst)
rst = s.kClosest([], K = 2)
print(rst)
rst = s.kClosest([[3,3],[5,-1],[-2,4]], K = 0)
print(rst)
rst = s.kClosest([[3,3],[5,-1],[-2,4]], K = 3)
print(rst)
rst = s.kClosest([[0,0],[5,-1],[-2,4]], K = 1)
print(rst)
