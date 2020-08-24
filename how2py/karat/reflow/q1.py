from typing import List


def wordWrap(words, maxLen) -> List[str]:
    """
    scan though each word, if exceed the maxLen with current word added, append all prev to result and start new round
    """
    prev_start = 0
    acc_len = 0
    result = list()
    for i, word in enumerate(words):
        acc_len += len(word)
        if acc_len > maxLen:
            append_word = "-".join(words[prev_start: i])
            if append_word and len(append_word) <= maxLen: result.append(append_word)
            acc_len = len(word)
            prev_start = i
        acc_len += 1
    final_word = "-".join(words[prev_start::])
    if len(final_word) <= maxLen: result.append(final_word)
    return result

rst = wordWrap(["123", "456", "123"], 2)
print(rst)
rst = wordWrap(["123", "456", "123"], 6)
print(rst)
rst = wordWrap(["123", "456", "123"], 7)
print(rst)
rst = wordWrap(["123", "456", "123"], 10)
print(rst)
rst = wordWrap(["123", "456", "123"], 11)
print(rst)
rst = wordWrap(["1234", "46", "123", "1", "1314"], 6)
print(rst)