n, m = map(int,input().split())

arr = []
arr2 = []
for i in range(n):
    line = list(map(int, input().split()))
    arr.append(line)
for i in range(n):
    line = list(map(int, input().split()))
    arr2.append(line)
for i in range(n):
    for j in range(m):
        arr[i][j] = arr[i][j] + arr2[i][j]
for i in range(n):
    for j in range(m):
        print(arr[i][j], end=" ")
    print()
        