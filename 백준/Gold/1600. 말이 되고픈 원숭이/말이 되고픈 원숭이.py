from sys import stdin     
from collections import deque    

k = int(stdin.readline())
w, h = map(int, stdin.readline().split())
maps = [list(map(int, stdin.readline().split())) for _ in range(h)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
hx = [1, 2, 2, 1, -1, -2, -2, -1]
hy = [2, 1, -1, -2, -2, -1, 1, 2] 

visited = [[[0 for _ in range(k+1)] for _ in range(w)] for _ in range(h)]

def bfs(x, y, z):
    q = deque()
    q.append((x, y, z))

    while q:
        a, b, c = q.popleft()

        if a == h-1 and b == w-1:
            return visited[a][b][c]

        if maps[a][b] == 1:
            continue

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if nx >=0 and nx < h and ny >= 0 and ny < w and visited[nx][ny][c] == 0:
            
                visited[nx][ny][c] = visited[a][b][c] + 1
                q.append((nx, ny, c))

        if c > 0:
            for i in range(8):
                nhx = a + hx[i]
                nhy = b + hy[i]
                if nhx >=0 and nhx < h and nhy >= 0 and nhy < w and visited[nhx][nhy][c-1] == 0:
               
                    visited[nhx][nhy][c-1] = visited[a][b][c] + 1
                    q.append((nhx, nhy, c-1))

    return -1
    



print(bfs(0,0,k))