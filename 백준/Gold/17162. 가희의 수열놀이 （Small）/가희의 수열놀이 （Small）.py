# 7/1
from sys import stdin
arr=[]
query_num, mod = map(int, stdin.readline().split())
lst = [[] for _ in range(mod)]
for i in range(query_num):
    line = list(map(int, stdin.readline().split()))
    if line[0] == 1:
        lst[line[1]%mod].append(len(arr))
        arr.append(line[1])
    elif line[0] == 2:
        if arr:
            x = arr.pop()
            lst[x%mod].pop()
    else:
        count = len(arr)
        chk = 1 
        for i in lst: #시간초과 고려
            if not i:
                print(-1)
                chk = 0
                break
            count = min(i[-1],count)
        if chk:
            print(len(arr)-count)
    