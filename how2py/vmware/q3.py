import bisect
def evenSubarray(numbers, k):
    """
    1. presum of the number of odd element
    2, binary search on the prev subarray
    """
    presum = list()
    presum.append(0)
    odd_acc = 0
    for number in numbers:
        if number % 2 != 0: odd_acc += 1
        presum.append(odd_acc)
    result = 0
    seen = set()
    for i, number in enumerate(numbers):
        max_diff = presum[i+1] - k
        if max_diff <= 0:
            for j in range(i+1):
                e = tuple(numbers[j:i+1])
                if e not in seen:
                    result += 1
                    seen.add(e)
        else:
            idx = bisect.bisect_left(presum, max_diff)
            for j in range(idx, i+1):
                e = tuple(numbers[j:i+1])
                if e not in seen:
                    result += 1
                    seen.add(e)
    return result

rst = evenSubarray([2,1,2,1,3], 2)
print(rst)