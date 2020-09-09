from typing import List
from _collections import defaultdict
# TLE

class Solution:
    def coinChange(self, remain, coins, memo, level):
        if not remain:
            return 1
        if level >= len(coins): return 0
        if memo[level][remain]: return memo[level][remain]
        coin = coins[level]
        total = 0
        for i in range(remain // coin + 1):
            total += self.coinChange(remain - i * coin, coins, memo, level + 1)
        memo[level][remain] = total
        return total

    def change(self, amount: int, coins: List[int]) -> int:
        """
        amount = coins(5) * [0..x] + coins(2) * [0..x] + coins(1) * [0..x]
                    level1              level2             level3
        memo: key -> level + count, value -> number of ways
        """
        coins.sort(reverse=True)
        memo = defaultdict(lambda: defaultdict(lambda: 0))
        rst = self.coinChange(amount, coins, memo, 0)
        return rst


s = Solution()
rst = s.change(5, [1, 2, 5])
print(rst)
rst = s.change(5000,
               [11, 24, 37, 50, 63, 76, 89, 102])
# print(rst) 992951208
