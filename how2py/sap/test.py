import sys
# text = "".join(sys.stdin.readlines())
# print(text)
#
# num = int(sys.stdin.readline().strip())

def contains_3(num):
    while num > 0:
        digit = num % 10
        if digit - 3 == 0: return True
        num = num // 10
    return False

def calc(num):
    while contains_3(num):
        num = num - 1
    return num


# print(calc(num))
print(sys.maxsize)