from typing import List
from _collections import defaultdict


class Solution:
    def __init__(self):
        self.rst = list()
        self.time, self.low = None, None
        self.timestamp = 0

    def dfs(self, g, from_node, node):
        """
        return: min_timestamp or low
        """
        # if already visited
        if self.time[node] != -1: return self.low[node]
        # if not visited
        self.time[node], self.low[node] = self.timestamp, self.timestamp
        self.timestamp += 1
        for neighbor in g[node]:
            if neighbor == from_node: continue
            r = self.dfs(g, node, neighbor)
            if r > self.time[node]: self.rst.append([node, neighbor])
            else: self.low[node] = min(self.low[node], r)
        return self.low[node]

    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        """
        1. goal, find critical edge that does not form cycle
        2. maintain a timestamp for each node and low for each node, if can't relax low from original timestamp
           though a edge(low[x] == timestamp[x] is okay, node of a dfs subtree) then that edge is a critical edge
        """
        self.time = [-1] * n
        self.low = [-1] * n
        g = defaultdict(set)
        for connection in connections:
            node1, node2 = connection[0], connection[1]
            g[node1].add(node2)
            g[node2].add(node1)
        self.dfs(g, -1, 0)
        return self.rst


s = Solution()
rst = s.criticalConnections(4, [[0, 1], [1, 2], [2, 0], [1, 3]])
print(rst)
