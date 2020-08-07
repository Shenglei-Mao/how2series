def getUnallottedUsers(bids, totalShares):
    # Write your code here
    # 1. reformat <price, time, quota, uid>
    # 2. sort
    # 3. stream process, find all tie, see if consumable, if consumable, go one
    # 4. if not, find first guy that unlucky not able to get quoto in the tie group
    # 5. sort result based on uid (list of integers)

    for bid in bids:
        bid[0], bid[1], bid[2], bid[3] = bid[2], -bid[3], -bid[1], bid[0]
    bids.sort(reverse=True)
    prev_price = bids[0][0]
    bucket = list()
    result = list()
    flag = True
    for i, bid in enumerate(bids):
        if not flag: result.append(bid[3])
        else:
            cur_price = bid[0]
            if cur_price == prev_price:
                bucket.append(bid)
            else:
                total = 0
                for b in bucket:
                    total += (-b[2])
                if totalShares > total:
                    totalShares -= total
                elif totalShares == total:
                    totalShares -= total
                    flag = False
                else:
                    if totalShares >= len(bids):
                        totalShares = 0
                        flag = False
                    else:
                        for b in bucket:
                            totalShares -= 1
                            if totalShares < 0:
                                result.append(b[3])
                        totalShares = 0
                    flag = False
                bucket.clear()
                bucket.append(bid)
            prev_price = cur_price
    total = 0
    for b in bucket:
        total += (-b[2])
    if totalShares > total:
        totalShares -= total
    elif totalShares == total:
        totalShares -= total
        flag = False
    else:
        if totalShares >= len(bids):
            flag = False
        else:
            for b in bucket:
                totalShares -= 1
                if totalShares < 0:
                    result.append(b[3])
        flag = False
    result.sort()
    return result



# getUnallottedUsers([[1,2,5,0],[2,1,4,2],[3,5,4,6]], 3)
rst = getUnallottedUsers([[1, 4, 3, 3524], [2, 3, 2, 2802], [3, 4, 3, 9850]], 3)
print(rst)
