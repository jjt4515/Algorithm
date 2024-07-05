from sys import stdin   
from collections import deque  

n, m = map(int, stdin.readline().split())
graph = [list(map(int, stdin.readline().rstrip())) for _ in range(n)]

# 벽을 뚫을 수 있는지 없는지도 표현해주기위해 3차원 배열을 사용
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]


dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y, z):
    q = deque()
    q.append([x,y,z])
    visited[x][y][z] = 1

    while q:
        a, b, c = q.popleft()

        if a == n-1 and b == m-1:
            return visited[a][b][c]

        for i in range(4):
            nx, ny = a+dx[i], b+dy[i]
            if nx < 0 or nx >=n or ny <0 or ny >= m:
                continue
            
            if graph[nx][ny] == 1 and c == 0:
                visited[nx][ny][1] = visited[a][b][0] + 1
                q.append([nx, ny, 1])
            elif graph[nx][ny] == 0 and visited[nx][ny][c] == 0:
                visited[nx][ny][c] = visited[a][b][c] + 1
                q.append([nx, ny, c])

    return -1

print(bfs(0,0,0))

        
