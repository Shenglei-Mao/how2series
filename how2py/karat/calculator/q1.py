def basicCalculator(expression) -> int:
    """
    maintain acc
    sign and pre_v
    scan through each char, if char is +, set sign = 1 and acc = acc + sign * pre_v, pre_v = 0
                            if char is -, set sign = 1 and acc = acc + sign * pre_v, pre_v = 0
                            if char is numerical, v = v * 10 + char
    """
    acc = 0
    sign, pre_v = 1, 0
    for c in expression:
        if c is '+':
            acc += sign * pre_v
            sign = 1
            pre_v = 0
        elif c is '-':
            acc += sign * pre_v
            sign = -1
            pre_v = 0
        else:
            pre_v = pre_v * 10 + int(c)
    acc += sign * pre_v
    return acc


rst = basicCalculator("2+3-999")
print(rst)
rst = basicCalculator("-1-1-1")
print(rst)
rst = basicCalculator("-1+2-3")
print(rst)
rst = basicCalculator("2")
print(rst)
rst = basicCalculator("-1")
print(rst)
