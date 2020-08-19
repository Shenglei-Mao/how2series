import sys
from typing import List


class Solution:
    def treasureIsland2(self, matrix: List[List[int]]) -> int:
        """
        1. Round1: scan top to bot, left to right, update its closest dist from top and left
           if matrix[i][j] == 'S': dp = 0
           elif matrix == 'D': dp = sys.maxsize
           else min(top, left, cur)
           (cur not needed for first round)
        2. Round2: scan bot to top, right to bot, update its closest dist from bot and right
        3. result = min(all x)
        """
        n, m = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(m)] for _ in range(n)]
        rst = sys.maxsize
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 'S':
                    continue
                elif matrix[i][j] == 'D':
                    dp[i][j] = sys.maxsize
                else:
                    top = sys.maxsize if i - 1 < 0 else dp[i - 1][j] + 1
                    left = sys.maxsize if j - 1 < 0 else dp[i][j - 1] + 1
                    dp[i][j] = min(top, left)
        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                if matrix[i][j] == 'S':
                    continue
                elif matrix[i][j] == 'D':
                    dp[i][j] = sys.maxsize
                else:
                    bot = sys.maxsize if i + 1 >= n else dp[i + 1][j] + 1
                    right = sys.maxsize if j + 1 >= m else dp[i][j + 1] + 1
                    dp[i][j] = min(bot, right, dp[i][j])
                    if matrix[i][j] == 'X':
                        rst = min(rst, dp[i][j])
        return rst


s = Solution()
rst = s.treasureIsland2([['S', 'O', 'O', 'S', 'S'],
                         ['D', 'O', 'D', 'O', 'D'],
                         ['O', 'O', 'O', 'O', 'X'],
                         ['X', 'D', 'D', 'O', 'O'],
                         ['X', 'D', 'D', 'D', 'O']])
print(rst)
