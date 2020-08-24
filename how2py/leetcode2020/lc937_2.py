from typing import List


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letter_log, digit_log = [], []
        for log in logs:
            if log.split()[1].isalpha():
                letter_log.append(log)
            else:
                digit_log.append(log)
        letter_log.sort(key=lambda x: x.split()[0])
        letter_log.sort(key=lambda x: x.split()[1:])
        return letter_log + digit_log


s = Solution()
rst = s.reorderLogFiles(["let9 art can", "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"])
print(rst)

