def sortByBeauty(numbers, size):
    """
    1. find out how many blocks
    2. find the rank (beauty) of each block
    3. rearrange the block by selection sort
    """
    def flat(r, c):
        """
        return as a list
        """
        res = list()
        for i in range(r * size, r * size + size):
            for j in range(c * size, c * size + size):
                res.append(numbers[i][j])
        return res

    def calc_rank(input):
        n = len(input)
        input = set(input)
        for i in range(1, n+2):
            if i not in input:
                return i

    n = len(numbers) // size # n * n block
    rank = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            flatted_list = flat(i, j)
            rank[i][j] = calc_rank(flatted_list)
    arr = list()
    for i in range(0, n*n):
        arr.append(i)
    # arr.sort(key=lambda x: rank[x//2][])

sortByBeauty([[1, 2,  2,  3],
           [3, 4,  10, 4],
           [2, 10, 1,  2],
           [5, 4,  4,  5]], 2)