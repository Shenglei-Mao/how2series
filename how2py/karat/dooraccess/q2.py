# list of [name, time], time is string format: '1300' //下午一点
# return: list of names and the times where their swipe badges within one hour. if there are multiple intervals
# that satisfy the condition, return any one of them.
# name1: time1, time2, time3...
# name2: time1, time2, time3, time4, time5...
# example:
# input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']]
# output: {
# 'Martha': ['1600', '1620', '1530']
# }
from collections import defaultdict

input1 = [['James', '1159'], ['James', '1201'], ['James', '1230'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']]
input2 = [['James', '1300'], ['James', '1330'], ['James', '1359'], ['Martha', '20'], ['Martha', '2330'], ['Martha', '2350'], ['Martha', '2355']]
# output: {
# 'Martha': ['1600', '1620', '1530']
# }
def frequentAccess(records):
    """
    maintain a map of <name, list of sorted timestamp>
    -> find out if exist subarray of 3 that max(subarr) - min(subarray) within a hour
    if exist 4 and want to return 4 instead of 3, then use sliding window add to window as long as within a hour
    check if > 3, if yes, add to result and go next record
    -> time conversion is also important
    ex: 1600 ~ 1700 is okay, 1300 ~ 1330, 1330 ~ 1421, 2330 ~ 030, 2300 ~ 000
    within a hour -> diff is less than 100
    sol: append all 0 ~ 100 to the end of list, by first incre by 2400
    """
    status = defaultdict(list)
    rst = dict()
    for record in records:
        name, time = record[0], record[1]
        status[name].append(int(time))
    for name, times in status.items():
        times.sort()
        for time in times:
            if time < 100: times.append(time + 2400)
            else: break
        # implement a sliding window algorithm
        n = len(times)
        if n < 3: continue
        left, right = 0, 1
        window_head = times[0]
        while right < n:
            while right < n and times[right] - window_head <= 100: right += 1
            if right - left >= 3:
                # TODO: time conversion back for those > 2400
                rst[name] = [e % 2400 for e in times[left: right]]
            left += 1
            window_head = times[left]
    return rst




rst = frequentAccess(input1)
print(rst)
rst = frequentAccess(input2)
print(rst)
