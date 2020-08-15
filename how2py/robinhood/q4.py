def oppositeSums(arr):
    def reverse(array):
        """
        reverse each int in the array
        """
        out = list()
        for num in array:
            out.append(int(str(num)[::-1]))
        return out

    origin = arr
    n = len(arr)
    rev = reverse(arr)
    result = 0
    for i in range(n):
        for j in range(i, n):
            if arr[i] + rev[j] == arr[j] + rev[i]: result += 1
    return result
