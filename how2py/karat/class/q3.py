from typing import List
from _collections import defaultdict
prereqs_courses1 = [
    ['Data Structures', 'Algorithms'],
    ['Foundations of Computer Science', 'Operating Systems'],
    ['Computer Networks', 'Computer Architecture'],
    ['Algorithms', 'Foundations of Computer Science'],
    ['Computer Architecture', 'Data Structures'],
    ['Software Design', 'Computer Networks'],
]

allCourses = [
    ['Logic', 'COBOL'],
    ['Data Structures', 'Algorithms'],
    ['Creative Writing', 'Data Structures'],
    ['Algorithms', 'COBOL'],
    ['Intro to Computer Science', 'Data Structures'],
    ['Logic', 'Compilers'],
    ['Data Structures', 'Logic'],
    ['Creative Writing', 'System Administration'],
    ['Databases', 'System Administration'],
    ['Creative Writing', 'Databases'],
    ['Intro to Computer Science', 'Graphics'],
]


class Solution:
    def __init__(self):
        self.rst = set()
    def dfs(self, graph, acc_path, cur_node):
        # terminal node
        if cur_node not in graph:
            mid_course = self.midway(acc_path)
            self.rst.add(mid_course)
            return
        for neighbor in graph[cur_node]:
            acc_path.append([cur_node, neighbor])
            self.dfs(graph, acc_path, neighbor)
            acc_path.pop(-1)


    def allMidway(self, allCourses) -> List[str]:
        g = defaultdict(list)
        from_courses = set()
        to_courses = set()
        for course_pair in allCourses:
            from_course, to_course = course_pair[0], course_pair[1]
            g[from_course].append(to_course)
            from_courses.add(from_course)
            to_courses.add(to_course)
        start_nodes = from_courses.difference(to_courses)
        path = list()
        for start_node in start_nodes:
            self.dfs(g, path, start_node)
        return list(self.rst)

    def midway(self, prereqs):
        """
        1. find the midpoint
        2. find the node with 0 in-degree -> that node is the starting point
        3. find the mid course from the starting node
        """
        mid = len(prereqs) // 2
        store = dict()  # key: from_course, value : to_course
        from_courses = set()
        to_courses = set()
        for prereq in prereqs:
            from_course, to_course = prereq[0], prereq[1]
            store[from_course] = to_course
            from_courses.add(from_course)
            to_courses.add(to_course)
        start_node = from_courses.difference(to_courses)
        count = 0
        course = start_node.pop()
        while count < mid:
            course = store[course]
            count += 1
        return course

s = Solution()
rst = s.allMidway(allCourses)
print(rst)