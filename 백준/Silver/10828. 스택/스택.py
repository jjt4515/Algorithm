import sys
n = int(sys.stdin.readline())
lst = []
for i in range(n):
    data = list(map(str, sys.stdin.readline().split()))
    com = data[0]
    length = len(lst)
    if len(data) == 2:
        num = int(data[1])
    if com == "push":
        lst.append(num)
    elif com == "pop":
        if length:
            print(lst.pop(-1))
        else:
            print(-1)
    elif com == "size":
        print(length)
    elif com == "empty":
        if length:
            print(0)
        else:
            print(1)
    elif com == "top":
        if length:
            print(lst[length - 1])
        else:
            print(-1)