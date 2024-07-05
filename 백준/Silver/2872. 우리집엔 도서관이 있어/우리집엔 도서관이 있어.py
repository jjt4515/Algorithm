from sys import stdin 
from collections import deque 
n = int(stdin.readline())
books = deque()
for _ in range(n):
    books.append(int(stdin.readline()))
max_book = n
cnt = 0
for i in range(n-1, -1, -1):
    if books[i] == max_book:
        max_book = max_book - 1
    else:
        cnt += 1
print(cnt)
            
