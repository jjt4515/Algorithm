from collections import deque

n = int(input())
graph = [[0] * (n+1)]

for _ in range(n):
    graph.append([0] + list(map(int, input().split())))

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == 9:
            sa, sb = i, j 
            break


def bfs(a, b):
    visited = [[0] * (n+1) for _ in range(n+1)]
    q = deque([[a,b]])
    cand = []

    visited[a][b] = 1

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    while q:
        x, y = q.popleft()
  
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx <= 0 or nx > n or ny <= 0 or ny > n or visited[nx][ny] != 0:
                continue
            if graph[a][b] > graph[nx][ny] and graph[nx][ny] != 0:
                visited[nx][ny] = visited[x][y] + 1
                cand.append((visited[nx][ny] -1, nx, ny))
            elif graph[a][b] == graph[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx, ny])
            elif graph[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx,ny])
            
    return sorted(cand, key = lambda x: (x[0], x[1], x[2]))
    
size = [2, 0]
cnt = 0

while True:
    graph[sa][sb] = size[0]

    cand = deque(bfs(sa, sb))

    if not cand:
        break

    step, x, y = cand.popleft()
    cnt += step
    size[1] += 1 

    if size[0] == size[1]:
        size[0] += 1
        size[1] = 0

    graph[sa][sb] = 0
    sa, sb = x, y

print(cnt)