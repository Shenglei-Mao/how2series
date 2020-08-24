from typing import List


class Solution:
    def dfs(self, grid, cur_shape, x, y, n, m, path_id):
        if x < 0 or x >= n or y < 0 or y >= m or grid[x][y] == 0: return
        grid[x][y] = 0
        cur_shape.append(path_id)
        self.dfs(grid, cur_shape, x + 1, y, n, m, 1)  # go down
        self.dfs(grid, cur_shape, x - 1, y, n, m, 2)  # go up
        self.dfs(grid, cur_shape, x, y + 1, n, m, 3)  # go right
        self.dfs(grid, cur_shape, x, y - 1, n, m, 4)  # go left
        cur_shape.append(-1)

    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        shape = set()
        for i in range(n):
            for j in range(m):
                if grid[i][j]:
                    cur_shape = list()
                    self.dfs(grid, cur_shape, i, j, n, m, 0)
                    shape.add(tuple(cur_shape))
        print(shape)
        return len(shape)

s = Solution()
rst = s.numDistinctIslands([[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]])
print(rst)
rst = s.numDistinctIslands([[1,1,0],[0,1,1],[0,0,0],[1,1,1],[0,1,0]])
print(rst)