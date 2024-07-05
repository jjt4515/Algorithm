n = int(input())
dp = [-1]*(n+1)
if n < 10:
    print(-1)
    exit()
dp[10] = 1
for i in range(11, n+1):
    arr = []
    s = str(i)
    for j in range(len(s)):
        for k in range(j, len(s)):
            num = int(s[j:k+1])
            if num != 0 and num != i:
                arr.append(num)
    arr.sort()
    for j in range(len(arr)):
        if dp[i-arr[j]] == -1:
            dp[i] = arr[j]
            break 

print(dp[n])

