from sys import stdin

def dfs(x):
    visited[x] = 1
    for i in graph[x]:
        if visited[i] == 0:
            dfs(i)

num = int(stdin.readline())
graph = [[] for _ in range(num+1)]
n = int(stdin.readline())
for _ in range(n):
    first, next = map(int, stdin.readline().split())
    graph[first].append(next)
    graph[next].append(first)
visited = [0] * (num+1)
dfs(1)
print(sum(visited)-1)

