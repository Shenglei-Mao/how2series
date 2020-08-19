from typing import List
# Union-Find O(V*(V+E)
# https://leetcode.com/discuss/interview-question/436073/
# TODO; Optimizing

class Solution:
    def union(self, parents, x, y):
        px = self.find(parents,x)
        py = self.find(parents,y)
        if px != py: parents[px] = py

    def find(self, parents, x):
        if parents[x] == x: return x
        else:
            p = self.find(parents, parents[x])
            parents[x] = p
            return p

    def count(self, parents):
        rst = 0
        for i, node in enumerate(parents):
            if i == node: rst += 1
        return rst

    def countComponents(self, n: int, edges: List[List[int]], rm_node) -> int:
        """
        1. Union-find
        2. Count
        """
        parents = [i for i in range(n)]
        for edge in edges:
            node1, node2 = edge[0], edge[1]
            if node1 == rm_node or node2 == rm_node: continue
            self.union(parents, node1, node2)
        return self.count(parents)

    def criticalRouters(self, n_node: int, n_edges: int,  edges: List[List[int]]) -> int:
        """
        1. Remove each node one by one and
        2. Run countComponents func for the remaining edges
        3. If result is not two, add that node into result list
        """
        rst = list()
        for i in range(n_node):
            n_comp = self.countComponents(n_node, edges, i)
            if n_comp != 2: rst.append(i)
        return rst

s = Solution()
rst = s.criticalRouters(7, 7, [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]])
print(rst)
rst = s.criticalRouters(4, 3, [[0, 1], [1, 2], [2, 3]])
print(rst)
rst = s.criticalRouters(7, 8, [[0, 1], [0, 2], [2, 1], [1, 6], [1, 3], [1, 4], [3, 5], [4, 5]])
print(rst)