import sys
from typing import List
# Dynamic Programming
# TODO: BFS


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        """
        1. scan top to bot, left to right, update its closest dist from top and left
           rst[i][j] = 0 if matrix[i][j] == 0 else min(top, left, cur)
        2. scan bot to top, right to bot, update its closest dist from bot and right
        """
        n, m = len(matrix), len(matrix[0])
        rst = [[0 for _ in range(m)] for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if matrix[i][j]:
                    top = sys.maxsize if i - 1 < 0 else rst[i - 1][j] + 1
                    left = sys.maxsize if j - 1 < 0 else rst[i][j - 1] + 1
                    rst[i][j] = min(top, left)
        for i in range(n-1, -1, -1):
            for j in range(m-1, -1, -1):
                if matrix[i][j]:
                    bot = sys.maxsize if i + 1 >= n else rst[i+1][j] + 1
                    right = sys.maxsize if j + 1 >= m else rst[i][j+1] + 1
                    rst[i][j] = min(bot, right, rst[i][j])
        return rst




s = Solution()
s.updateMatrix([[0, 0, 0],
                [0, 1, 0],
                [0, 0, 0]])
