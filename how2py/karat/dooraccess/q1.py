badge_records = [
    ["Martha", "exit"],
    ["Paul", "enter"],
    ["Martha", "enter"],
    ["Martha", "exit"],
    ["Jennifer", "enter"],
    ["Paul", "enter"],
    ["Curtis", "enter"],
    ["Paul", "exit"],
    ["Martha", "enter"],
    ["Martha", "exit"],
    ["Jennifer", "exit"],
]

# Expected output: ["Paul", "Curtis"], ["Martha"]
from _collections import defaultdict


def invalidBadgeRecords(records):
    """
    maintain a hashmap to store the status of all student
    enter -> + 1, exit -> - 1
    only exit with 1 and enter with 0 is valid
    also, at the end of day, ....
    """
    invalid_enter, invalid_exit = set(), set()
    status = defaultdict(int)
    for record in records:
        name, action = record[0], record[1]
        if action is "enter":
            if status[name] != 0:
                invalid_enter.add(name)
            else:
                status[name] += 1
        elif action is "exit":
            if status[name] != 1:
                invalid_exit.add(name)
            else:
                status[name] -= 1
    for name, s in status.items():
        if s == 1: invalid_enter.add(name)
    return [[n for n in invalid_enter], [m for m in invalid_exit]]


rst = invalidBadgeRecords(badge_records)
print(rst)
