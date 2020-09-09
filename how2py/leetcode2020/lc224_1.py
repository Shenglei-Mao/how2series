class Solution:
    def calculate(self, s: str) -> int:
        """
        init acc = 0, sign = 1 and v = 0
        case1: (  () ()  )
        case2: (  ()   )
        case3: (  (  (  ) ) )
        if case1: [v sign
        if case2: [
        if case3: [( v sign ( v sign  (v sign )
        stack = []
        scan through each char,
            if char is (, put acc and sign onto stack, init acc = 0, sign = 1 and v = 0
            if char is ), eval acc (set acc = acc + sign * v) and set new acc = sign(on stack) * acc + v(on stack), init v
            if char is +, eval acc (set acc = acc + sign * v), v = 0 and sign = 1
            if char is -, eval acc (set acc = acc + sign * v), v = 0 and sign = -1
            if char is digit, v = v * 10 + int(char)
        """
        acc = 0
        sign, v = 1, 0
        my_stack = list()
        for c in s:
            if c is '+':
                acc += sign * v
                sign = 1
                v = 0
            elif c is '-':
                acc += sign * v
                sign = -1
                v = 0
            elif c.isdigit():
                v = v * 10 + int(c)
            elif c is '(':
                my_stack.append(acc)
                my_stack.append(sign)
                acc, sign, v = 0, 1, 0
            elif c is ')':
                acc += sign * v
                acc = my_stack.pop() * acc + my_stack.pop()
                v = 0
        acc += sign * v
        return acc


s = Solution()
rst = s.calculate("2-((1+2)-(3-5))+1")
print(rst)
