import bisect


def pre_sum(inputs):
    acc_sum = 0
    for i, input in enumerate(inputs):
        inputs[i] = inputs[i] + acc_sum
        acc_sum = acc_sum + input
    print(inputs)
    return inputs


def if_meet(times: list) -> int:
    if not times:
        return 1
    pre_sums = pre_sum(times)
    if pre_sums[-1] % 60 == 0:
        total_time = pre_sums[-1] // 60
    else:
        total_time = pre_sums[-1] // 60 + 1
    pages = []
    for time in range(total_time):
        i = bisect.bisect(pre_sums, (time + 1) * 60)
        pages.append(i)
    print(pages)
    prev_page = 0
    for page in pages:
        if page - prev_page > 4:
            return 0
        prev_page = page
    return 1


print(if_meet([50000,1,1,1]))

