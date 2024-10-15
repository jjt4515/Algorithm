n,m = map(int,input().split())
lst = list(map(int, input().split()))
ssum = [0]
tmp = 0

for i in range(n):
    tmp += lst[i]
    ssum.append(tmp)

for _ in range(m):
    i, j = map(int, input().split())
    print(ssum[j] - ssum[i-1])
    
