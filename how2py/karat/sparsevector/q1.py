# sparseVector v = new sparseVector(100); //size constructor; size is 100.
#     v.set(0, 1.0);
#     v.set(3, 2.0);
#     v.set(80,-4.5);
#
#     System.out.println(v.get(80)); //should print -4.5
#     System.out.println(v.get(50)); //should print 0.0
#
#     try {
#        System.out.println(v.get(101)); //error -- index out of range
#        throw new IllegalStateException("We should not get here, an exception should have been thrown");
#     } catch (IndexOutOfBoundsException t) {
#        // success
#     }
#     System.out.println(v.toString()); //should print something like [1.0, 0.0, 0.0, 2.0, 0.0, ...]


# Add these operations to your library: Addition, dot product, and cosine. Formulae for each are provided below;
# we’re more interested in you writing the code than whether you’ve memorized the formula. For each operation,
# your code should throw an error if the two input vectors are not equal length.
# Sample input/output:
# //Note: This is pseudocode. Your actual syntax will vary by language.
# v1 = new vector(5)
# v1[0] = 4.0
# v1[1] = 5.0
# v2 = new vector(5)
# v2[1] = 2.0
# v2[3] = 3.0.
#
# v3 = new vector(2)
# print v1.add(v2) //should print [4.0, 7.0, 0.0, 3.0, 0.0]
# print v1.add(v3) //error -- vector lengths don’t match
#
# print v1.dot(v2) //should print 10
# print v1.dot(v3) //error -- vector lengths don’t match
#
# print v1.cos(v2) //should print 0.433
# print v1.cos(v3) //error -- vector lengths don’t match
#
#
# Formulae:
# Addition
# a.add(b) = [a[0]+b[0], a[1]+b[1], a[2]+b[2], ...]
# Dot product
# a.dot(b) = a[0]*b[0] + a[1]*b[1] + a[2]*b[2] + ...
#
# Cosine
# a.cos(b) = a.dot(b) / (norm(a) * norm(b))
# //norm(a) = sqrt(a[0]^2 + a[1]^2 + a[2]^2 + ...).
import bisect
import math


class sparseVector:
    """
    1. hashmap
    2. sorted list of tuple, where tuple(index, value)
    """

    def __init__(self, size):
        self.size = size  # 0 ~ (size - 1)
        self.vector = list()

    def _verify_index(self, index):
        if index < 0 or index >= self.size:
            raise Exception("OutOfBoundary")

    def set(self, index, value):
        self._verify_index(index)
        if not self.vector: self.vector.append((index, value))
        fst, _ = zip(*self.vector)
        idx = bisect.bisect_left(fst, index)
        if idx < len(self.vector) and fst[idx] == index:
            self.vector[idx] = (index, value)
        else:
            self.vector.insert(idx, (index, value))

    def _norm(self):
        acc = 0
        for _, v in self.vector:
            acc += v * v
        return math.sqrt(acc)

    def cos(self, v):
        # Cosine
        # a.cos(b) = a.dot(b) / (norm(a) * norm(b))
        # //norm(a) = sqrt(a[0]^2 + a[1]^2 + a[2]^2 + ...).
        return self.dot(v) / (self._norm() * v._norm())

    def __str__(self):
        p = 0
        rst = []
        for i in range(self.size):
            if p < len(self.vector) and i == self.vector[p][0]:
                rst.append(self.vector[p][1])
                p += 1
            else:
                rst.append(0)
        return str(rst)

    def get(self, index) -> int:
        self._verify_index(index)
        if not self.vector: return 0
        fst, _ = zip(*self.vector)
        idx = bisect.bisect_left(fst, index)
        if idx < len(self.vector) and fst[idx] == index:
            return self.vector[idx][1]
        else:
            return 0

    def dot(self, v):
        n, m = self.size, v.size
        if n != m:
            raise Exception("Dot, two matrix must have same size")
        p1, p2 = 0, 0
        n, m = len(self.vector), len(v.vector)
        rst = 0
        while p1 < n and p2 < m:
            index1, value1 = self.vector[p1]
            index2, value2 = v.vector[p2]
            if index1 == index2:
                rst += value1 * value2
                p1 += 1
                p2 += 1
            elif index1 < index2:
                p1 += 1
            else:
                p2 += 1
        return rst

    def add(self, v):
        """
        input: sparseVector
        return: new sparseVector
        """
        n, m = self.size, v.size
        if n != m:
            raise Exception("Add, two matrix must have same size")
        p1, p2 = 0, 0
        rst = sparseVector(n)
        n, m = len(self.vector), len(v.vector)
        while p1 < n and p2 < m:
            index1, value1 = self.vector[p1]
            index2, value2 = v.vector[p2]
            if index1 == index2:
                rst.set(index1, value1 + value2)
                p1 += 1
                p2 += 1
            elif index1 < index2:
                rst.set(index1, value1)
                p1 += 1
            else:
                rst.set(index2, value2)
                p2 += 1
        if p1 < n:
            for i in range(p1, n):
                index, value = self.vector[p1]
                rst.set(index, value)
        if p2 < m:
            for i in range(p2, n):
                index, value = v.vector[p2]
                rst.set(index, value)
        return rst


# v = sparseVector(100)
# v.set(0, 1.0)
# v.set(3, 2.0)
# v.set(80, -4.5)
# print(v.vector)
# print(v.get(0))
# print(v.get(3))
# print(v.get(80))
# print(v.get(101))
v1 = sparseVector(5)
v2 = sparseVector(5)
v1.set(0, 4)
v1.set(1, 2)
v1.set(3, 8)
v1.set(4, 8)
v2.set(1, 2)
v2.set(3, 3)
print(v1)
print(v2)
print("======== ADD")
rst = v1.add(v2)
print(rst)
print("======== DOT")
rst = v1.dot(v2)
print(rst)
print("======== COS")
rst = v1.cos(v2)
print(rst)
