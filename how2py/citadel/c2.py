def findBeforeMatrix(after):
    # Write your code here
    n = len(after)
    if not n: return []
    m = len(after[0])
    if not m: return []
    before = [[0 for _ in range(m)] for _ in range(n)]
    # presum = [[0 for _ in range(m+1)] for _ in range(n+1)]
    for i in range(0, n):
        acc = 0
        for j in range(0, m):
            # cur = after[i-1][j-1] - presum[i-1][j] - presum[i][j-1]
            up_sum = 0 if i - 1 < 0 else after[i-1][j]
            left_sum = 0 if j - 1 < 0 else acc
            cur = after[i][j] - up_sum - left_sum
            before[i][j] = cur
            # presum[i][j] = presum[i][j-1] + cur
            acc += cur
    return before

rst = findBeforeMatrix([[2, 1], [5, 4]])
print(rst)
rst = findBeforeMatrix([[1,2,3], [3,4,5], [6, 7, 8]])
print(rst)