from sys import stdin   

n, k = map(int, stdin.readline().split())

values = [list(map(int, stdin.readline().split())) for _ in range(n)]

dp = [[0]*(k+1) for _ in range(n+1)]
for i in range(1, n+1):
    w,v  = values[i-1]

    for j in range(1, k+1):
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j-w]+v, dp[i-1][j])
print(dp[n][k])
    
