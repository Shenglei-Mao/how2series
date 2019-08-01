from collections import Counter

n = [1, 2, 1]
avg = sum(n) / len(n)
print(avg)
print(1 + 1)
print(type(n))
Z = 1.2 + 7.5j
print(Z)
s = ""
if s:
    print("hello")

X = "This isn't \"funny\""
print(X)
Y = '''Don't quote 
               "me"'''
print(Y)

s = "Hello  Worl    dddd "
print(s.split())
print(s.split(" "))
print(s.split('d'))

print(n[-2])

l = [2, 5, 7]
l.insert(1, 20)
print(l)
l.remove(13)
print(l)

k = []
print(k)
if not k:
    print("k value to false")
    print("But k is not false or true using \"is\" operator")
    print(k is True)

l.sort()

# Test "=", shallow copy and deep copy

print("Hello World!")

print('I am "{}" and I am "{}".'.format('Smart', 'Happy'))
