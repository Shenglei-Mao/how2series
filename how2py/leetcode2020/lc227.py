class Solution:
    def calculate(self, s: str) -> int:
        """
        sign, cur_val, total
        scan each char,
        if c is digit: cur_val = cur_val * 10 + c
        if c is + or -:
                if not stack: total = total + cur_val * sign, update sign, clear cur_val
                else: stack compact 3 to 1, update total, update sign, clear cur_val
        if c is * or /:
                if not stack: cur_val to stack, op to stack, clear cur_val
                else: stack compact 3 to 1, clear cur_val
        At the end of the day, we still have one more cur_val:
            if stack: stack compact 3 to 1, update total
            else: update total
        """

        def compactAndCalc(stack, sign, right_val):
            """
            return rst
            """
            op = my_stack.pop()
            left_v = my_stack.pop()
            if op == "*":
                return sign * (left_v * right_val)
            else:
                return sign * (left_v // right_val)

        total, sign, cur_val = 0, 1, 0
        my_stack = list()
        for c in s:
            if c.isdigit():
                cur_val = cur_val * 10 + int(c)
            elif c == "+" or c == "-":
                if my_stack:
                    total += compactAndCalc(my_stack, sign, cur_val)
                else:
                    total += cur_val * sign
                sign = 1 if c == "+" else -1
                cur_val = 0
            elif c == "*" or c == "/":
                if my_stack:
                    new_left = compactAndCalc(my_stack, 1, cur_val)
                    my_stack.append(new_left)
                    my_stack.append(c)
                else:
                    my_stack.append(cur_val)
                    my_stack.append(c)
                cur_val = 0
        if my_stack:
            total += sign * compactAndCalc(my_stack, 1, cur_val)
        else:
            total += sign * cur_val
        return total


s = Solution()
rst = s.calculate("3-2*2/2")
print(rst)
rst = s.calculate("3+2*2")
print(rst)
rst = s.calculate(" 3/2 ")
print(rst)
rst = s.calculate(" 3+5 / 2 ")
print(rst)
