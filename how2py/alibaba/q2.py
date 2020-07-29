import sys
# 驿站路径问题
def max_value(num, cost):
    pass

if __name__ == "__main__":
    # 读取第一行的n
    num = int(sys.stdin.readline().strip())
    line = sys.stdin.readline().strip()
    cost = list(map(int, line.split()))
    print(max_value(num, cost))