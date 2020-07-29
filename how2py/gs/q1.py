def canReach(x1, y1, x2, y2):
    print(x1, y1, y2, y2)
    # Write your code here
    # so, explore all situation
    # if reach end point, return immediately
    # else (out of boundary) return false
    # we can work from end point to start point as well
    # -------------------------------------------------------------
    # Code Start Here

    # # Solution1: DPS -> Stack Overflow
    # # Boundary Check
    # if x1 > x2 or y1 > y2: return "No"

    # # Termination Condition Check
    # if x1 == x2 and y1 == y2: return "Yes"

    # # Expolre All Paths
    # if canReach(x1 + y1, y1, x2, y2) == "Yes":
    #     return "Yes"
    # return canReach(x1, x1 + y1, x2, y2)

    # -------------------------------------------------------------
    # Solution2: Bottom-Up with Memoization (Scan from Left to Right, Bottom to Up)
    table = [[0 for _ in range(y2+1)] for _ in range(x2+1)]
    # Init Condition
    table[x1][y1] = 1
    # Scan
    for r in range(x1, x2+1):
        for c in range(y1, y2+1):
            # Check Boundary
            if r == x1 and c == y1: continue
            cond1 = 0 if r-c < 0 else table[r-c][c]
            cond2 = 0 if c-r < 0 else table[r][c-r]
            table[r][c] = cond1 | cond2
    print(table)
    return "Yes" if table[x2][y2] else "No"


print(canReach(1, 1000, 1, 1000))