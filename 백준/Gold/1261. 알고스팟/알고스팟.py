from collections import deque
m, n = map(int, input().split())
graph = [[0] * (m+1)]
for _ in range(n):
    graph.append([0] + list(map(int, input())))
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

lst = [[-1] * (m+1) for _ in range(n+1)]

def bfs(a, b):
    q = deque()
    q.append([a,b])
    lst[1][1] = 0

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx > 0 and nx <= n and ny > 0 and ny <= m and lst[nx][ny] == -1:
                if graph[nx][ny] == 0:
                    lst[nx][ny] = lst[x][y]
                    q.appendleft([nx, ny])
                else:
                    lst[nx][ny] = lst[x][y] + 1
                    q.append([nx, ny])
bfs(1, 1)
print(lst[n][m])