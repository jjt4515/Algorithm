n = int(input())
v = [int(input()) for _ in range(n)]

dp = [[0]*(n+1)]*(n+1)

res = 0
for i in range(1, n+1):
    for left in range(0, i+1):
        right = i-left
        if left == 0:
            dp[left][right] = dp[left][right-1] + i*v[-right]
        elif right == 0:
            dp[left][right] = dp[left-1][right] + i*v[left-1]
        else:
            dp[left][right] = max(dp[left-1][right] + i*v[left-1], dp[left][right-1] + i*v[-right])
        
        if i==n:
            res = max(res, dp[left][right])
print(res)

