from sys import stdin     

n = int(stdin.readline())

dp = [0]*(n+1)
dp[0] = 0
dp[1] = 1

for i in range(2, n+1):
    dp[i] = max(dp[i-1] + 1, dp[i-3]*2)
    for j in range(2, i-3):
        dp[i] = max(dp[i], dp[j]*(i-1-j))        
   
print(dp[n])