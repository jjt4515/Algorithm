from sys import stdin 
n = int(stdin.readline())
lst = [list(map(int, stdin.readline().split())) for _ in range(n)]

dp = [0] * (n+2)

for i in range(n, 0, -1):
    if i+lst[i-1][0] <= n+1:
        dp[i] = max(dp[i+lst[i-1][0]] + lst[i-1][1], dp[i+1])
    else:
        dp[i] = dp[i+1]

print(max(dp))