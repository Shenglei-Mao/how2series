def reverse(array):
    """
    reverse each int in the array
    """
    out = list()
    for num in array:
        out.append(int(str(num)[::-1]))
    return out

rst = reverse([301, 0, 9, 2400])
print(rst)
from _collections import defaultdict

a = defaultdict(int)
print(a[0])

print(int())