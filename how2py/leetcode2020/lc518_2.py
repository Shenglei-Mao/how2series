from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        """
        each combination is orders, based on the order inside coins
        for each new coins, update number of ways
        for coins = [1,2,5], amount = 5
        using coins1, [0, 1, 1, 1, 1, 1]
        using coins1, 2, [0, 1, 2, 2, 2, 2]
        using coins1, 2, 3, [0, 1, 2, 3, 4, 4]
        ...
        for new coin ci
        dp[x] = dp[x] + dp[x - ci]
        dp[i] := number of ways can expressed by adding to amount i
        """
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = dp[i] + dp[i - coin]
        return dp[amount]

s = Solution()
rst = s.change(5, [1, 2, 5])
print(rst)
rst = s.change(5, [2, 1, 5])
print(rst)
rst = s.change(0, [2, 1, 5])
print(rst)
rst = s.change(3, [2])
print(rst)