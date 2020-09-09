from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        c0, c1, c2 ... = coins
        dp[x] = min(dp[x-c0], dp[x-c1], dp[x-c2], ....) + 1
        or from another point of view
        for x, we propagate the dp[x] to dp[x+c0], dp[x+c1],.
        or from a third point of view
        we add coin one by one, for each new coin, update the min step it can achieve with the new coin
        """
        if not amount: return 0
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(coin, amount + 1):
                if not dp[i - coin]: continue
                if i == coin:
                    dp[i] = 1
                elif dp[i]:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
                else:
                    dp[i] = dp[i - coin] + 1
        return dp[amount] if dp[amount] else -1


s = Solution()
rst = s.coinChange(coins=[1, 2, 5], amount=11)
print(rst)
rst = s.coinChange(coins=[2], amount=3)
print(rst)
rst = s.coinChange(coins=[1, 5, 2], amount=11)
print(rst)
