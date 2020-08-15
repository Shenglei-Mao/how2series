a = [1, 2, 3]
b = [4, 5, 6]


for i, j in zip(a, b):
    print(i, j)


c = list(zip(a, b))
print(c)
print(type(c[0]))

out = sorted(a, reverse=True)
print(out)