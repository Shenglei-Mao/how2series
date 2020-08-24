import math
from typing import List

lines = ["The day began as still as the",
         "night abruptly lighted with",
         "brilliant flame"]

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
            total_free_space = maxLen - (acc_len - len(word) - 1)
            space_between = i - prev_start - 1
            if space_between == 0: extra_hyphen = 0
            else: extra_hyphen = math.ceil(total_free_space / space_between)
            # append_word = "-".join(words[prev_start: i])
            append_word = ""
            for j, tmp in enumerate(words[prev_start: i]):
                if j == 0: append_word += tmp
                else:
                    extra_hyphen = extra_hyphen if total_free_space >= extra_hyphen else total_free_space
                    total_free_space -= extra_hyphen
                    append_word = append_word + "-" + "-" * extra_hyphen + tmp
            if append_word and len(append_word) <= maxLen: result.append(append_word)
            acc_len = len(word)
            prev_start = i
        acc_len += 1
    final_word = "-".join(words[prev_start::])
    if len(final_word) <= maxLen: result.append(final_word)
    return result

def reflowAndJustify(lines, maxLen) -> List[str]:
    words = list()
    for line in lines:
        line = line.strip().split()
        words.extend(line)
    return wordWrap(words, maxLen)


rst = reflowAndJustify(lines, 24)
print(rst)
rst = reflowAndJustify(lines, 12)
print(rst)
