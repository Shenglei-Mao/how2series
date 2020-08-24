board = [
    [1, 0, 0, 0, 0],
    [0, -1, -1, 0, 0],
    [0, -1, 0, 1, 0],
    [-1, 0, 0, 0, 0],
    [0, 1, -1, 0, 0],
    [0, 0, 0, 0, 0],
]


def dfs(board, visited, cur, end, remain_treasures, cur_path, paths):
    x, y = cur[0], cur[1]
    if cur == end:
        if board[x][y] == 1: remain_treasures -= 1
        if remain_treasures == 0:
            cur_path.append(end)
            paths.append(cur_path[::])  # deep copy
            cur_path.pop(-1)
        return
    n, m = len(board), len(board[0])
    if x < 0 or x >= n or y < 0 or y >= m or board[x][y] == -1 or visited[x][y] == 1: return
    visited[x][y] = 1
    cur_path.append([x, y])
    if board[x][y] == 1: remain_treasures -= 1
    dfs(board, visited, (x+1, y), end, remain_treasures, cur_path, paths)
    dfs(board, visited, (x-1, y), end, remain_treasures, cur_path, paths)
    dfs(board, visited, (x, y+1), end, remain_treasures, cur_path, paths)
    dfs(board, visited, (x, y-1), end, remain_treasures, cur_path, paths)
    visited[x][y] = 0
    cur_path.pop(-1)


def findAllTreasures(board, start, end):
    """
    dfs all the possible path and get those with minimum length
    """
    n, m = len(board), len(board[0])
    visited = [[0 for _ in range(m)] for _ in range(n)]
    num_treasures = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 1: num_treasures += 1
    cur_path = list()
    paths = list()
    dfs(board, visited, start, end, num_treasures, cur_path, paths)
    if len(paths) == 0: return []
    min_len = min(len(path) for path in paths)
    rst = list()
    for path in paths:
        if len(path) == min_len: rst.append(path)
    return rst



rst = findAllTreasures(board, (5, 0), (0, 4))
print(rst)
print(len(rst))
rst = findAllTreasures(board, (5, 2), (2, 0))
print(rst)
print(len(rst))
rst = findAllTreasures(board, (0, 0), (4, 1))
print(rst)
print(len(rst))