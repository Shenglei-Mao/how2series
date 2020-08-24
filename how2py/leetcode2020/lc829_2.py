import math


class Solution:
    def consecutiveNumbersSum(self, N: int) -> int:
        pass
        # N = a + (a+1) + (a+2) .... = a * n + (1 + n - 1) * (n - 1) // 2 = a * n + n(n-1) // 2
        # when a == 1, N = n + n(n-1) // 2 -> calculate the ceiling of n = sqrt(2N)
        # TODO: Implement the Algorithm


s = Solution()
# rst = s.consecutiveNumbersSum(15)
# print(rst)
# rst = s.consecutiveNumbersSum(9)
# print(rst)
# rst = s.consecutiveNumbersSum(5)
# print(rst)
rst = s.consecutiveNumbersSum(1)
print(rst)
# rst = s.consecutiveNumbersSum(1e9)
# print(rst)
