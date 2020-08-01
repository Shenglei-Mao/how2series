import sys

def num_pass(length, arr) -> int:
    arr_sorted = sorted(arr)
    min_v, max_v = min(arr), max(arr)
    if arr == arr_sorted: return 0
    if arr[0] == min_v or arr[-1] == max_v: return 1
    if arr[0] == max_v and arr[0] == min_v: return 3
    else: return 2

# rst = num_pass(6, [4, 3, 1, 6, 2, 5])
# print(rst)
if __name__ == "__main__":
    # 读取第一行的n
    length = int(sys.stdin.readline().strip())
    line = sys.stdin.readline().strip()
    arr = list(map(int, line.split()))
    rst = num_pass(length, arr)
    print(rst)
