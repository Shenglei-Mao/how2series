# another practice for speed
class Solution:
    def calculate(self, s: str) -> int:
        """
        1 + (1 - (4 - (3-2)))

        scan through arr, for each c,
        acc, sign, cur_v
        if + or -: acc  += sign * acc, update sign
        if (: (left bracket always follow by sign), push acc into stack, push sign on to stack, reset acc
        if ): pop last sign, push sign * acc into stack
        if digit: add digit into cur_v
        end check
        result = sum(stack)
        """
        acc, sign, cur_v = 0, 1, 0
        total = 0
        my_stack = list()
        for c in s:
            if c.isdigit():
                cur_v = cur_v * 10 + int(c)
            elif c == '+' or c == '-':
                acc += sign * cur_v
                sign = 1 if c == '+' else -1
                cur_v = 0
            elif c == '(':
                total += acc
                my_stack.append(sign)
                sign = 1
                acc = 0
            elif c == ')':
                prev_sign = my_stack.pop()
