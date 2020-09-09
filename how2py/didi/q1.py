def mid_index(input_list):
    """
    return a set of mid index
    """
    sum_v = sum(input_list)
    if sum_v % 2 != 0: return [], -1
    mid_v = sum_v // 2
    acc = 0
    rst = set()
    for i, num in enumerate(input_list):
        if i == len(input_list) - 1: break
        acc += num
        if acc == mid_v: rst.add(i)
    return rst, mid_v


def solution(A, B):
    # write your code in Python 3.6
    mid_a, v_a = mid_index(A)
    if not mid_a: return 0
    mid_b, v_b = mid_index(B)
    if not mid_b: return 0
    if v_a != v_b: return 0
    return len(mid_a.intersection(mid_b))


# rst = solution([4, -1, 0, 3], [-2, 5, 0, 3])
# print(rst)
# rst = solution([2, -2, -3, 3], [0, 0, 4, -4])
# print(rst)
rst = solution([4, -1, 0, 3], [-2, 6, 0, 4])
print(rst)
