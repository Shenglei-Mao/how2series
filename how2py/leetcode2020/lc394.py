class Solution:
    # TODO Use Recursive to Implement it again
    # TODO Write Out a More Cohesive Solution
    def decodeString(self, s: str) -> str:
        """
        result = [a, b, c
        stack = [3, c, d
        for c in s
        1. if character and stack is empty, c go to result
        2. if character and stack not empty, c go to stack
        3. if integer, integer go to stack
        4. if [, doing nothing
        5, if ], compress the stack, cd -> multiple * 3 -> 3cd, then push to stack if stack is not empty,
            to result if stack is empty

        case2: 3[ab2[cd]] -> 3[abcdcd] -> abcdcd abcdcd abcdcd
        result =
        stack = [3, a, b, cdcd
        cdcd
        """
        result, stack = list(), list()

        def compress():
            str_builder = list()
            if not stack: return ""
            while not stack[-1].isdigit():
                seg = stack.pop()
                if seg == "[": continue
                str_builder.insert(0, seg)
            multi = int (stack.pop())
            return multi*("".join(str_builder))

        for c in s:
            if c.isalpha() and not stack: result.append(c)
            if c.isalpha() and stack: stack.append(c)
            if c.isdigit():
                if stack and stack[-1].isdigit():
                    prev = int(stack.pop())
                    c = prev * 10 + int (c)
                stack.append(str (c))
            if c == "[": stack.append(c)
            if c == ']':
                comp = compress()
                if not stack: result.append(comp)
                else: stack.append(comp)
        return "".join(result)


s = Solution()
rst = s.decodeString("2[2[y]pq4[k]]")
print(rst)
# rst = s.decodeString("3[ab2[cd]]")
# print(rst)
# assert rst == "abcdcdabcdcdabcdcd"
# rst = s.decodeString("3[]")
# print(rst)
# assert rst == ""
# rst = s.decodeString("")
# print(rst)
# assert rst == ""
# rst = s.decodeString("[]")
# print(rst)
# assert rst == ""
# rst = s.decodeString("3[a]2[bc]")
# print(rst)
# assert rst == "aaabcbc"
# rst = s.decodeString("3[a2[c]]")
# print(rst)
# assert rst == "accaccacc"
# rst = s.decodeString("2[abc]3[cd]ef")
# print(rst)
# assert rst == "abcabccdcdcdef"
# rst = s.decodeString("abc3[cd]xyz")
# print(rst)
# assert rst == "abccdcdcdxyz"
# rst = s.decodeString("3[cd]")
# print(rst)
# assert rst == "cdcdcd"
# rst = s.decodeString("12[cd]")
# print(rst)
# assert rst == 12 * "cd"


