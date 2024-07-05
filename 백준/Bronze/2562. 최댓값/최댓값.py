numlist = []
for i in range(9):
    numlist.append(int(input()))
max = 0
max_idx=0
for i in range(9):
    if max < numlist[i]:
        max = numlist[i]
        max_idx = i+1
print(max)
print(max_idx)