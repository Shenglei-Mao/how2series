def maxKOccurrences(sequence, words):
    n = len(sequence)
    def max_occur(table, word):
        top = n // len(word)
        for i in range(1, top+1):
            cur = word * i
            if cur not in table: return i - 1
        return top

    # preprocessing of sequence
    look_up = set()
    for i in range(n):
        for j in range(i+1, n+1):
            look_up.add(sequence[i: j])
    result = list()
    for word in words:
        result.append(max_occur(look_up, word))
    return result


rst = maxKOccurrences("ababcbabc", ["ab", "babc", "bca"])
print(rst)