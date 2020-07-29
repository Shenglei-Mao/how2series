from typing import List


class Solution:
    def __init__(self):
        print("Class Loaded")

    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: return 0
        r, c = len(grid), len(grid[0])
        seen = [[0 for _ in range(c)] for _ in range(r)]

        def dfs(x, y):
            if x < 0 or y < 0 or x >= r or y >= c or grid[x][y] == "0" or seen[x][y]: return
            seen[x][y] = 1
            dfs(x-1, y)
            dfs(x+1, y)
            dfs(x, y-1)
            dfs(x, y+1)
        num_islands = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j] == "1" and (not seen[i][j]):
                    dfs(i, j)
                    num_islands += 1
        return num_islands


s = Solution()
rst = s.numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]])
print(rst)