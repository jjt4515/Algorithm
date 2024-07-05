from sys import stdin

n, k = map(int, stdin.readline().split())

inp = list(map(int,stdin.readline().split()))
d = [x for x in inp]
d.insert(0,0)

ans = [0] * (n+1)

for i in range(n, 0, -1):
    if d[i] >= k:
        ans[i] = d[i] - k
        if i < n:
            ans[i] = ans[i] + ans[i+1]
    else:
        idx = i
        sum = 0
        while sum < k:
            if idx > n:
                sum = k
                break
            sum += d[idx]
            idx += 1
        ans[i] = sum - k
        if idx <= n and i < n:
            ans[i] = max(ans[i] + ans[idx], ans[i+1])

print(ans[1])