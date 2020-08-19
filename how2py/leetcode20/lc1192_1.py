from typing import List
# TLE


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

    def countComponents(self, n: int, edges: List[List[int]], rm_edge) -> int:
        """
        n: number of node, skip rm_edge
        1. Union-find
        2. Count
        """
        rank = [0] * n
        parents = [i for i in range(n)]
        for i, edge in enumerate(edges):
            if i == rm_edge: continue
            node1, node2 = edge[0], edge[1]
            self.union(parents, node1, node2, rank)
        return self.count(parents)

    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        num_edge = len(connections)
        rst = list()
        for i in range(num_edge):
            count = self.countComponents(n, connections, i)
            if count > 1: rst.append(connections[i])
        return rst

s = Solution()
rst = s.criticalConnections(4, [[0,1],[1,2],[2,0],[1,3]])
print(rst)