import sys
# 变大恐龙蛋


def same_eggs(eggs) -> bool:
    seen = set()
    for egg in eggs:
        if egg in seen: return True
        seen.add(egg)
    return False


def update_eggs(eggs) -> None:
    for i, egg in enumerate(eggs):
        eggs[i] = egg * (i+1)


def days_for_two_egg(num, eggs) -> int:
    """
    # Solution1: brutal force
    # update the eggs array day by day
    # for each update, check if there have at least two eggs with same size
    """
    days = 1
    while not same_eggs(eggs):
        update_eggs(eggs)
        days = days + 1
    return days


print(days_for_two_egg(3, [8, 4, 2]))
if __name__ == "__main__":
    # 读取第一行的n
    num = int(sys.stdin.readline().strip())
    line = sys.stdin.readline().strip()
    eggs = list(map(int, line.split()))
    print(days_for_two_egg(num, eggs))


