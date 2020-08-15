def maxStep(expression) -> int:
    """
    1. scan each char, two acc -> left_acc, right_acc
    2.1. if <, left_acc += 1
    2.2. if >, if left_acc is 0, step += 1 or decrement left_acc
    3 At the end, if still left_acc, return -1 or return step
    """
    left_acc, right_acc = 0, 0
    step = 0
    for c in expression:
        if c == '<': left_acc += 1
        elif c == '>':
            if left_acc == 0: step += 1
            else: left_acc -= 1
    return -1 if left_acc else step

def balancedOrNot(expressions, maxReplacements):
    # Write your code here
    # 1. check each expression
    # 2. count the max step for each expression -1 means unbalanceable
    # 3. compare with maxReplacement
    result = list()
    for i, expression in enumerate(expressions):
        step = maxStep(expression)
        if step != -1 and step <= maxReplacements[i]:
            result.append(1)
        else: result.append(0)
    return result

rst = balancedOrNot(['<>', '<>><'], [1, 0])
print(rst)