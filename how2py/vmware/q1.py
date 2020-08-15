def helper(cur, result, s, idx):
    if cur: result.add(cur)
    if idx == len(s): return
    helper(cur + s[idx], result, s, idx+1)
    helper(cur, result, s, idx+1)


def buildSubsequences(s):
    # Write your code here
    result = set()
    cur = ""
    helper(cur, result,s, 0)
    return sorted(result)

rst = buildSubsequences("xyz")
print(rst)
rst = buildSubsequences("")
print(rst)
rst = buildSubsequences("x")
print(rst)