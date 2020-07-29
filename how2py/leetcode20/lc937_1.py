from typing import List


class Solution:
    class Log:
        def __init__(self, log):
            log = log
            content = log.split()
            self.id = content[0]
            self.content = content[1:]

        def __lt__(self, other):
            if self.content[0].isalpha() and other.content[0].isdigit(): return True
            if self.content[0].isalpha() and other.content[0].isalpha():
                if "".join(self.content) == "".join(other.content): return self.id < other.id
                else:
                    return "".join(self.content) < "".join(other.content)
            return False

    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        return sorted(logs, key=lambda log: self.Log(log))


s = Solution()
print(s.reorderLogFiles(["let9 art can", "dig1 8 1 5 1","dig2 3 6","let2 own kit dig","let3 art zero", "let1 art can"]))
