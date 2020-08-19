from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        """
        1. init, go right, if out of boundary (*) or go to a already existed block, turn right(*)
        *out boundary: layer by layer, first layer is a issue, -> sol: row % n, col % n
        *turn right: [0, 1], [1, 0], [0, -1], [-1, 0]  -> new x, y = prev y, -x
        """
        v = 1
        rst = [[0 for _ in range(n)] for _ in range(n)]
        direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        d_idx = 0
        x, y = 0, 0
        while v <= n * n:
            rst[x][y] = v
            v += 1
            ix, iy = direction[d_idx % 4]
            if rst[(x+ix)%n][(y+iy)%n]:
                # make right turn
                d_idx += 1
                ix, iy = direction[d_idx % 4]
            x, y = x+ix, y+iy
        return rst

s = Solution()
rst = s.generateMatrix(3)
print(rst)

