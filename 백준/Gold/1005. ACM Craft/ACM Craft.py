from collections import deque
from sys import stdin

t = int(stdin.readline())
for _ in range(t):
    n, k = map(int, stdin.readline().split())
    time = [0] + list(map(int, stdin.readline().split()))
    seq = [[] for _ in range(n+1)]
    degree = [0 for _ in range(n+1)]
    dp = [0 for _ in range(n+1)]

    for _ in range(k):
        a, b =  list(map(int, stdin.readline().split()))
        seq[a].append(b)
        degree[b] += 1

    w = int(stdin.readline())
    q = deque()

    for i in range(1, n+1):
        if degree[i] == 0:
            q.append(i)
            dp[i] = time[i]
            
    while q:
        start = q.popleft()
   
        for next in seq[start]:
            dp[next] = max(dp[next], dp[start] + time[next])
            degree[next] -= 1
            if degree[next] == 0:
                q.append(next)
    print(dp[w])