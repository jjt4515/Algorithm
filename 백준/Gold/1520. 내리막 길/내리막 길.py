import sys

sys.setrecursionlimit(10**6)

m,n = map(int, input().split())
graph = [[0] * (n+1)]
for _ in range(m):
    graph.append([0] + list(map(int, input().split())))
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

visited = [[-1] * (n+1) for _ in range(m+1)]

def dfs(x, y):
    if x == m and y == n:
        return 1
    
    if visited[x][y] != -1:
        return visited[x][y]
    
    visited[x][y] = 0

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx <= 0 or nx > m or ny <= 0 or ny > n:
            continue
        if graph[x][y] > graph[nx][ny]:
            visited[x][y] += dfs(nx, ny)

    return visited[x][y]

print(dfs(1,1))