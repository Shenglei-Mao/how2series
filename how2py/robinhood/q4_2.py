from _collections import defaultdict
def oppositeSums(arr):

    origin = arr
    n = len(arr)
    result = len(arr)
    # seen = defaultdict(lambda: 0)
    # seen_rev = defaultdict(lambda: 0)
    diff = defaultdict(lambda: 0)
    for num in arr:
        rev = int(str(num)[::-1])
        sub = num - rev
        # if num in seen:
        #     result += seen[num]
        # elif num in seen_rev:
        #     result += seen_rev[num]
        # seen[num] += 1
        # seen_rev[rev] += 1
        if sub in diff:
            result += diff[sub]
        diff[sub] += 1
    return result