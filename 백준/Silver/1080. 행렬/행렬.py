from sys import stdin        

n,m = map(int, stdin.readline().split())

mapA = []
mapB = []
for i in range(n):
    mapA.append(list(map(int, stdin.readline().rstrip())))
for i in range(n):
    mapB.append(list(map(int, stdin.readline().rstrip())))

res = 0

for i in range(0, n-2):
    for j in range(0, m-2):
        if mapA[i][j] != mapB[i][j]:
            for a in range(3):
                for b in range(3):
                    mapA[i+a][j+b] = 1-mapA[i+a][j+b]            
            res +=1 
if mapA == mapB:
    print(res)
else:
    print(-1)
        