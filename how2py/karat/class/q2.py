prereqs_courses1 = [
    ['Data Structures', 'Algorithms'],
    ['Foundations of Computer Science', 'Operating Systems'],
    ['Computer Networks', 'Computer Architecture'],
    ['Algorithms', 'Foundations of Computer Science'],
    ['Computer Architecture', 'Data Structures'],
    ['Software Design', 'Computer Networks'],
]

prereqs_courses2 = [
    ['Data Structures', 'Algorithms'],
    ['Algorithms', 'Foundations of Computer Science'],
    ['Foundations of Computer Science', 'Logic'],
]


# sd -> cn -> ca -> *ds -> al -> fc -> os 6/2 = 3
# ds -> *al -> fc -> l 3/2 = 1
def midway(prereqs):
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


rst = midway(prereqs_courses1)
print(rst)
rst = midway(prereqs_courses2)
print(rst)
