def dfs(g, visited, cur):
    if cur in visited: return
    visited.add(cur)
    dfs(g, visited, g[cur])

def solution(A, B):
    # write your code in Python 3.6
    """
    1. find all the nodes
    2, check if num of edge is same to node, if not, return false
    3. check if one node have only one in-degree edge and one out-degree edge
    4. dfs
    """
    set_A = set(A)
    set_B = set(B)
    nodes = set_A.union(set_B)
    if (len(nodes) != len(A)) or (len(nodes) != len(B)): return False  # check condition2
    if (len(A) != len(set_A)) or (len(B) != len(set_B)): return False  # check condition3
    g = dict()
    for i in range(len(A)):
        from_node, to_node = A[i], B[i]
        g[from_node] = to_node
    visited = set()
    dfs(g, visited, A[0])
    return len(visited) == len(nodes)

rst = solution([1,2,3],[2,3,2])
print(rst)
