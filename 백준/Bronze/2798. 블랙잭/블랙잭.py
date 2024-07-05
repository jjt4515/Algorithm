n, m = map(int, input().split())
nums = list(map(int, input().split()))

sum = 0
for i in range(0, n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            if nums[i]+nums[j]+nums[k] > m:
                continue
            elif nums[i]+nums[j]+nums[k] > sum:
                sum = nums[i] + nums[j] + nums[k]
print(sum)
