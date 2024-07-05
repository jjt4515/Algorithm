from sys import stdin    
n = int(stdin.readline())
lst = list(map(int, stdin.readline().split()))

dp = [[0 for _ in range(n)] for _ in range(2)]
dp[0][0] = lst[0]
dp[1][0] = lst[0]

for i in range(1, n):
    dp[0][i] = max(dp[0][i-1] + lst[i], lst[i])
    dp[1][i] = max(dp[0][i-1], dp[1][i-1] + lst[i])

print(max(max(dp[0]), max(dp[1])))