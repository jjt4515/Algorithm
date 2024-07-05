from sys import stdin
back = []
front = []
cur = 0
n, q = map(int, stdin.readline().split())
for _ in range(q):
    inp = stdin.readline().split()
    command = inp[0]
    if command == "B":
        if len(back) != 0:
            front.append(cur)
            cur = back.pop()
    elif command == "F":
        if len(front) != 0:
            back.append(cur)
            cur = front.pop()
    elif command == "A":
        front = []
        if cur > 0:
            back.append(cur)
        cur = int(inp[1])
    elif command == "C":
        new_back = []
        while(back):
            tmp = back.pop(0)
            if not new_back or tmp != new_back[-1]:
                new_back.append(tmp)
        back = new_back

print(cur)

if back:
    back.reverse()
    for i in back:
        print(i, end=" ")
    print()
else:
    print(-1)

if front:
    front.reverse()
    for i in front:
        print(i, end=" ")
    print()
else:
    print(-1)    