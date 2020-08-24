from typing import List
from _collections import defaultdict

class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        """
        for each cpdomain, split based on ".", and then build subdomains from backward, put it into a dict
        """
        store = defaultdict(lambda: 0)
        for cpdomain in cpdomains:
            cpdomain = cpdomain.split()
            count, domain = cpdomain[0], cpdomain[1]
            domain = domain.strip().split(".")
            n = len(domain)
            tmp = ""
            for i in range(n-1, -1, -1):
                if i == n - 1: tmp = domain[i]
                else: tmp = domain[i] + "." + tmp
                store[tmp] += int(count)
        rst = list()
        for k, v in store.items():
            rst.append(str(v) + " " + k)
        return rst


s = Solution()
rst = s.subdomainVisits(["9001 discuss.leetcode.com"])
print(rst)