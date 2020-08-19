from typing import List


class Solution:
    def union(self, parents, x, y, rank):
        px = self.find(parents,x)
        py = self.find(parents,y)
        if px == py: return
        if rank[px] < rank[py]:
            parents[px] = py
        elif rank[px] > rank[py]:
            parents[py] = px
        else:
            parents[px] = py
            rank[py] += 1

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

    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        """
        1. Union-find
        2. Count
        """
        rank = [0] * n
        parents = [i for i in range(n)]
        for edge in edges:
            node1, node2 = edge[0], edge[1]
            self.union(parents, node1, node2, rank)
        return self.count(parents)


s = Solution()
rst = s.countComponents(5, [[0, 1], [1, 2], [3, 4]])
print(rst)
rst = s.countComponents(5, [[0, 1], [1, 2], [2, 3], [3, 4]])
print(rst)
rst = s.countComponents(5, [[0,1],[1,2],[0,2],[3,4]])
print(rst)