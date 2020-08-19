from typing import List
# TODO: TLE

class Solution:
    def bfs(self, matrix, x, y, r, c):
        if matrix[x][y] == 0: return 0
        q = list()
        q.append((x, y))
        seen = [[0 for _ in range(c)] for _ in range(r)]
        count = 0
        while q:
            n = len(q)
            for i in range(n):
                x, y = q.pop(0)
                seen[x][y] = 1
                if matrix[x][y] == 0: return count
                else:
                    if x+1 < r and not seen[x+1][y]: q.append((x+1, y))
                    if y+1 < c and not seen[x][y+1]: q.append((x, y+1))
                    if x-1 >= 0 and not seen[x-1][y]: q.append((x-1, y))
                    if y-1 >= 0 and not seen[x][y-1]: q.append((x, y-1))
            count += 1



    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        """
        1. for each element in the matrix do a bfs search for 0
        """
        n = len(matrix)
        if not n: return []
        m = len(matrix[0])
        if not m: return []
        rst = [[-1 for _ in range(m)] for _ in range(n)]
        for i in range(n):
            for j in range(m):
                rst[i][j] = self.bfs(matrix, i, j, n, m)
        return rst

s = Solution()
rst = s.updateMatrix([[0,0,0],[0,1,0],[0,0,0]])
print(rst)
rst = s.updateMatrix([[0],[0],[0],[0],[0]])
print(rst)
rst = s.updateMatrix([[0,1,0,1,1],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]])
print(rst)
