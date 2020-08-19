from _collections import defaultdict
all_courses = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]


def default_value():
    return [0, 0]


def mid(courses):
    result = set()
    lookup = defaultdict(lambda : [0, 0])
    for course in courses:
        from_c, to_c = course[0], course[1]
        lookup[from_c][0] += 1
        lookup[to_c][1] += 1
    for course in lookup:
        v = lookup[course]
        if v[0] != 0 and v[1] != 0:
            result.add(course)
    return result


rst = mid(all_courses)
print(rst)