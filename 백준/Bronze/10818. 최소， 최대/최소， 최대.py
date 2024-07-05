num_count = int(input())

numlist = list(map(int, input().split()))
max = -1000000
min = 1000000
for i in range(num_count):
    if max < numlist[i]:
        max = numlist[i]
    if min > numlist[i]:
        min = numlist[i]
print(min, max)