n, k = map(int, input().split())

left = 0
right = n // 2

flag = 0
while left <= right:
    rowCut = (left + right) // 2
    colCut = n - rowCut
    
    num = (rowCut + 1) * (colCut + 1)

    if num == k:
        print("YES")
        flag = 1
        break
    elif num > k:
        right = rowCut - 1
    else:
        left = rowCut + 1

if flag == 0:
    print("NO")