from typing import List
# TODO: Optimizing


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        """
        3 * 3  -> n * n
        define 4 boundary: right, down, left, up
                ini value: n(col), n(row), 0(col), 0(row)
        4 direction := [0, 1], [1, 0], [0, -1], [-1, 0]

        define a round as go rdlu

        we try to explore for x round until end: for each touch of a boundary, update the boundary

        terminal condition: contradiction of the boundary
        """
        if n == 1: return [1]
        direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        rst =[[0 for _ in range(n)] for _ in range(n)]
        v = 1
        x, y = 0, 0
        rst[0][0] = 1
        right, down, left, up = n-1, n-1, 0, 0
        while left <= right and up <= down:
            for i, d in enumerate(direction):
                while True:
                    x, y = x + d[0], y + d[1]
                    if i == 0 and y > right:
                        right -= 1
                        x, y = x - d[0], y - d[1]
                        break
                    elif i == 1 and x > down:
                        down -= 1
                        x, y = x - d[0], y - d[1]
                        break
                    elif i == 2 and y < left:
                        left += 1
                        x, y = x - d[0], y - d[1]
                        break
                    elif i == 3 and x <= up:
                        up += 1
                        x, y = x - d[0], y - d[1]
                        break
                    else:
                        v += 1
                        rst[x][y] = v
        return rst


s = Solution()
rst = s.generateMatrix(3)
print(rst)
rst = s.generateMatrix(4)
print(rst)
rst = s.generateMatrix(5)
print(rst)
