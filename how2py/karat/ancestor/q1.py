from collections import defaultdict

edges = [[1, 4], [1, 5], [2, 5], [3, 6], [6, 7], [8, 2], [8, 3]]


def _findAllNodes(edges):
    all_nodes = set()
    for edge in edges:
        p, n = edge[0], edge[1]
        all_nodes.add(p)
        all_nodes.add(n)
    return all_nodes


def _createGraph(edges):
    """
    return a map as a graph of adjacent list
    """
    lookup = defaultdict(list)
    for edge in edges:
        p, n = edge[0], edge[1]
        lookup[n].append(p)
    return lookup


def findNodesWithZeroOrOneParent(edges):
    """
    maintain a hashmap where key: node, val: list parents
    count the node with 0 or 1 parents
    """
    nodes = _findAllNodes(edges)
    graph = _createGraph(edges)
    rst = []
    # for n, parents in graph.items():
    #     if len(parents) == 1 or 0: rst.append(n)
    for node in nodes:
        if node not in graph:
            rst.append(node)
        else:
            parents = graph[node]
            if len(parents) == 1 or 0: rst.append(node)
    return rst


def _dfs(graph, x, pset):
    if x not in graph: return
    for neighbor in graph[x]:
        pset.add(neighbor)
        _dfs(graph, neighbor, pset)


def _allParents(graph, x):
    """
    return a set of all x's parent
    """
    pset = set()
    _dfs(graph, x, pset)
    return pset


def hasCommonAncestor(edges, x, y):
    graph = _createGraph(edges)
    px = _allParents(graph, x)
    py = _allParents(graph, y)
    return list(px.intersection(py))


def _dfsMaxPath(graph, x, cur_path_len, global_max, rst):
    if x not in graph:
        if cur_path_len > global_max[0]:
            global_max[0] = cur_path_len
            rst[0] = x
            return
    for neighbor in graph[x]:
        _dfsMaxPath(graph, neighbor, cur_path_len + 1, global_max, rst)


def _earliestAncestor_helper(graph, x):
    """
    given a directed graph, with len = 1 between node, find the end node with max path length
    """
    global_max = [0]
    rst = [None]
    _dfsMaxPath(graph, x, 0, global_max, rst)
    return rst[0]


def earliestAncestor(edges, x):
    graph = _createGraph(edges)
    return _earliestAncestor_helper(graph, x)


rst = findNodesWithZeroOrOneParent(edges)
print(rst)
rst = hasCommonAncestor(edges, 2, 3)
print(rst)
rst = hasCommonAncestor(edges, 6, 7)
print(rst)
rst = hasCommonAncestor(edges, 2, 4)
print(rst)
rst = hasCommonAncestor(edges, 2, 7)
print(rst)
rst = earliestAncestor(edges, 5)
print(rst)
rst = earliestAncestor(edges, 6)
print(rst)
rst = earliestAncestor(edges, 4)
print(rst)

edges2 = [[1, 4], [1, 5], [2, 5], [3, 6], [6, 7], [8, 2], [8, 3], [9, 1], [12, 9]]
rst = earliestAncestor(edges2, 5)
print(rst)
assert rst == 12
rst = earliestAncestor(edges2, 4)
assert rst == 12
print(rst)
