def threeCharsDistinct(s):
    def distinct_tuple(trio):
        if trio[0] != trio[1] and trio[0] != trio[2] and trio[1] != trio[2]: return True
        else: return False
    count = 0
    n = len(s)
    if n < 3: return 0
    for i in range(n-2):
        if distinct_tuple(s[i:i+3]): count += 1
    return count
