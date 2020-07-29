import sys




def num_days(egg1, idx1, egg2, idx2):
    if (egg1 - egg2) % (idx2 - idx1) == 0:
        days = (egg1 - egg2) / (idx2 - idx1)
    else:
        days = sys.maxsize
    days = int(days)
    return days


def days_for_two_egg(num, eggs) -> int:
    """
    # Solution1: brutal force
    # update the eggs array day by day
    # for each update, check if there have at least two eggs with same size
    # Solution2: Check each two pairs
    """
    days = sys.maxsize
    for i in range(num - 1):
        for j in range(i + 1, num):
            days = min(days, num_days(eggs[i], i, eggs[j], j))
    return days


print(days_for_two_egg(3, [8, 4, 2]))
if __name__ == "__main__":
    # 读取第一行的n
    num = int(sys.stdin.readline().strip())
    line = sys.stdin.readline().strip()
    eggs = list(map(int, line.split()))
    print(days_for_two_egg(num, eggs))


