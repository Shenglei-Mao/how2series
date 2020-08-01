class Solution:
    def consecutiveNumbersSum(self, N: int) -> int:
        # N = a + (a+1) + (a+2) .... = a * n + (1 + n - 1) * (n - 1) // 2 = a * n + n(n-1) // 2
        # 1 + 2 + ... Y = (Y + 1) * Y // 2 >= N

        count = 1
        a = 2
        n = 2
        while a > 1:
            a_n = N - n * (n-1) // 2
            if a_n % n == 0 and a_n / n >= 1:
                count += 1
            a = a_n / n
            n += 1
        return count


s = Solution()
rst = s.consecutiveNumbersSum(15)
print(rst)
rst = s.consecutiveNumbersSum(9)
print(rst)
rst = s.consecutiveNumbersSum(5)
print(rst)
rst = s.consecutiveNumbersSum(1)
print(rst)
rst = s.consecutiveNumbersSum(1e9)
print(rst)
