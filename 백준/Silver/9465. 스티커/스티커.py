from sys import stdin    

t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    dp = [[0] * n for _ in range(2)]
    stickers = [list(map(int, stdin.readline().split())) for _ in range(2)]
    dp[0][0] = stickers[0][0]
    dp[1][0] = stickers[1][0]
    for i in range(1, n):
        for j in range(2):
            if i > 1:
                dp[j][i] = max(dp[1-j][i-1] , dp[1-j][i-2]) + stickers[j][i]
            else:
                dp[j][i] = dp[1-j][i-1] + stickers[j][i]

    print(max(dp[0][n-1], dp[1][n-1]))