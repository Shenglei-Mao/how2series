import sys


def if_space2(space, cargos):
    space1, space2 = 0, 0
    for cargo in cargos:
        if space1 <= space2:
            space1 = space1 + cargo
            if space < space1:
                return False
        else:
            space2 = space2 + cargo
            if space < space2:
                return False
    return True


def min_space(cargos):
    left, right = sum(cargos) // 2, sum(cargos)
    cargos = sorted(cargos)
    while left < right:
        mid = left + (right - left) // 2
        can_split = if_space2(mid, cargos)
        if can_split:
            right = mid
        else:
            left = mid + 1
    return right


print(min_space([8, 11, 19, 21]))
# if __name__ == "__main__":
#     # 读取第一行的n
#     n = int(sys.stdin.readline().strip())
#     ans = 0
#     for i in range(n):
#         # 读取每一行
#         line = sys.stdin.readline().strip()
#         # 把每一行的数字分隔后转化成int列表
#         values = list(map(int, line.split()))
#         result = min_space(values)
#     print(result)


