##sorts uppercase and lowercase letters separately, then alternately appends them to form the final string.
S = input().strip()

# Separate uppercase and lowercase letters
upper = sorted([ch for ch in S if ch.isupper()])
lower = sorted([ch for ch in S if ch.islower()])

# Merge alternatively
i = j = 0
take_upper = True   # start with uppercase
result = []

while i < len(upper) or j < len(lower):
    if take_upper and i < len(upper):
        result.append(upper[i])
        i += 1
    elif not take_upper and j < len(lower):
        result.append(lower[j])
        j += 1
    take_upper = not take_upper  # switch turn

print("".join(result))
