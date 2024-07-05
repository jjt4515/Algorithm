import sys
n, m = map(int, sys.stdin.readline().split())
parents = [i for i in range(n+1)]

sys.setrecursionlimit(1000000)

def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parents[b] = a 
    else:
        parents[a] = b 


def find(x):
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]


for _ in range(m):
    x, a, b = map(int, sys.stdin.readline().split())
    if x == 0:
        union(a,b)
    else:
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")
  
    

     

   