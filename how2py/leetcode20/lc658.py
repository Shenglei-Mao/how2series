from typing import List
import heapq
# TODO: Optimize

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        hp = list()
        for ele in arr:
            top = 0
            if hp: top = hp[0][0]
            if len(hp) < k:
                heapq.heappush(hp, (-abs(ele - x), ele))
            elif top < -abs(ele-x):
                heapq.heappop(hp)
                heapq.heappush(hp, (-abs(ele - x), ele))
        result = list()
        for ele in hp:
            result.append(ele[1])
        result.sort()
        return result
