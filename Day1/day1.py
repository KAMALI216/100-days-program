s = input().strip()  # input string

o = []  # odd digits
e = []  # even digits
c = 0   # special character count

for ch in s:
    if ch.isdigit():
        d = int(ch)
        if d % 2 == 0:
            e.append(ch)
        else:
            o.append(ch)
    elif not ch.isalnum():  # fixed: call the method
        c += 1

# decide starting type
start_odd = (c % 2 == 1)

i = j = 0
r = []

while i < len(o) or j < len(e):
    if start_odd:
        if i < len(o):
            r.append(o[i])
            i += 1
        start_odd = False
    else:
        if j < len(e):
            r.append(e[j])
            j += 1
        start_odd = True

print("".join(r))
