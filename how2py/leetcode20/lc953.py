from typing import List


class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        def idx(character) -> int:
            """
            return proper index
            """
            return ord(character) - ord('a')

        n = len(words)
        if (not n) or (n == 1): return True
        rank = [0] * 26

        def if_in_order(w1: str, w2: str) -> bool:
            l1, l2 = len(w1), len(w2)
            length = min(l1, l2)
            for i in range(length):
                if rank[idx(w1[i])] < rank[idx(w2[i])]: return True
                if rank[idx(w1[i])] > rank[idx(w2[i])]: return False
            return l1 <= l2

        for i, c in enumerate(order):
            rank[idx(c)] = i
        for i in range(n - 1):
            if not if_in_order(words[i], words[i + 1]): return False
        return True
