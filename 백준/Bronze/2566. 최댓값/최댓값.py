arr = [list(map(int, input().split())) for _ in range(9)]
maximum = -1
x_idx = 0
y_idx = 0
for i in range(9):
    for j in range(9):
        if maximum < arr[i][j]:
            maximum = arr[i][j]
            x_idx = i+1
            y_idx = j+1
print(maximum)
print(x_idx, y_idx)