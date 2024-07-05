from sys import stdin

def dfs(x,y):
    for a,b in tree[x]:
        if visited[a] == -1:
            visited[a] = b+y
            dfs(a,b+y)

v = int(stdin.readline())
tree = [[]for _ in range(v+1)]
for i in range(v):
    n = list(map(int,stdin.readline().split()))
    for j in range(1,len(n)-2,2):
        tree[n[0]].append([n[j],n[j+1]]) 

visited = [-1] * (v+1)
visited[1] = 0
dfs(1,0)

start = visited.index(max(visited))
visited = [-1]*(v+1)
visited[start] = 0
dfs(start,0)

print(max(visited))
