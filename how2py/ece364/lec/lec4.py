# Collection 1
# author : Shenglei M
import os
import sys

# Tuples
A = [1, 2, 3]
B = tuple(A)
print(B)
print(sum(A))
print(sum(B))

S = "Hello"
T = tuple(S)
print(T)

# Unpacked Tuples
namesAndAges = [('Alex', 'Gheith', 40),
                ('Mary', 'Hanson', 22),
                ('John', 'Stewart', 33)]

for first, last, age in namesAndAges:
    print(first, last, age)

s = "lololol"
print(s.count("lol"))
print(s.title())

A = {"red": 23, "green": 42}

os.access("./avg.py", os.R_OK)


def myFun(*args, **kwargs):
    for arg in args:
        print("Next argument through *argv :", arg)
    for key, value in kwargs.items():
        print("%s == %s" % (key, value))




myFun("./avg.py", os.R_OK)

myFun()

print(sys.argv[0])
