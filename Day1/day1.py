def find(a):
    n = len(a)
    b = sum(a)   # base ones count

    # Special case: if all ones, flipping reduces count
    if b == n:
        return n - 1

    # Transform: 0 -> +1, 1 -> -1
    t = [1 if x == 0 else -1 for x in a]

    # Kadane’s algorithm
    m = c = t[0]
    for x in t[1:]:
        c = max(x, c + x)
        m = max(m, c)

    return b + m


# Driver
N = int(input().strip())
a = list(map(int, list(input().strip())))
print(find(a))
