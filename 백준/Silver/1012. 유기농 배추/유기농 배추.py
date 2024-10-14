from collections import deque

t = int(input())
for _ in range(t):
    m, n, k = map(int, input().split())
    graph = [[0 for _ in range(m)] for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1
    ans = 0
    q = deque()
    dx = [-1, 1, 0, 0]
    dy = [0, 0 ,-1, 1]
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                graph[i][j] = 0
                ans += 1
                q.append((i,j))
                while q:
                    x, y = q.popleft()
                    for h in range(4):
                        nx = x + dx[h]
                        ny = y + dy[h] 
                        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
                            graph[nx][ny] = 0
                            q.append((nx, ny))

    print(ans)
                        
                
                
                
