import sys

result = 50000


def min_space(space1, space2, cargos):
    global result
    if not cargos:
        result = min(result, max(space1, space2))
        return
    min_space(space1 + cargos[0], space2, cargos[1:])
    min_space(space1, space2 + cargos[0], cargos[1:])
    return


# min_space(0, 0, [8, 1, 1])
# print(result)
if __name__ == "__main__":
    # 读取第一行的n
    n = int(sys.stdin.readline().strip())
    ans = 0
    for i in range(n):
        # 读取每一行
        line = sys.stdin.readline().strip()
        # 把每一行的数字分隔后转化成int列表
        values = list(map(int, line.split()))
        min_space(0, 0, values)
    print(result)


