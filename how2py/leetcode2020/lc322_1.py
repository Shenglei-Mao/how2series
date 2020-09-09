from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        '''
        c0, c1, c2 ... = coins
        dp[x] = min(dp[x-c0], dp[x-c1], dp[x-c2], ....)
        or from another point of view
        for x, we propagate the dp[x] to dp[x+c0], dp[x+c1],.
        '''
        if not amount: return 0
        dp = [-1] * (amount + 1)
        for coin in coins:
            if coin <= amount: dp[coin] = 1
        for i in range(amount):
            if dp[i] == -1: continue
            for coin in coins:
                pos = i + coin
                if pos <= amount:
                    if dp[pos] == -1:
                        dp[pos] = dp[i] + 1
                    else:
                        dp[pos] = min(dp[pos], dp[i] + 1)
        return dp[amount] if dp[amount] else 0


s = Solution()
rst = s.coinChange(coins=[1, 2, 5], amount=11)
print(rst)
rst = s.coinChange(coins=[2], amount=3)
print(rst)
rst = s.coinChange(coins=[1, 5, 2], amount=11)
print(rst)
