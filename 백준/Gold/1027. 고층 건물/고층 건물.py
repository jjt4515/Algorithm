n = int(input())
lst = list(map(int, input().split()))

res = 0

for i in range(n):
    ans = 0
    left_inclination = float('inf')
    right_inclination = -float('inf')

    for left in range(i-1, -1, -1):
        if (lst[i] - lst[left]) / (i-left) < left_inclination:
            ans += 1
            left_inclination = (lst[i] - lst[left]) / (i-left)
       
    for right in range(i+1, n):
        if (lst[right] - lst[i]) / (right - i) > right_inclination:
            ans += 1
            right_inclination = (lst[right] - lst[i]) / (right - i)
    
    res = max(res, ans)

print(res)
