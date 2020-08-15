import bisect


a = [-1, 1,2 ,3 ,4, 4, 4, 8]
# idx = bisect.bisect_left(a,-1)
# print(idx)
idx = bisect.bisect_right(a,8)
print(idx)
a.insert(100, 20)
print(a)