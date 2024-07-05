from sys import stdin 
import heapq

n = int(stdin.readline())
lst = []


for _ in range(n):
    lst.append(list(map(int, stdin.readline().split())))
# [[1, 3], [2, 4], [3, 5]]
lst.sort(key=lambda x:x[0])

space = []
heapq.heappush(space, lst[0][1])

for i in range(1,n):
    if lst[i][0] < space[0]:
        heapq.heappush(space, lst[i][1])
    else:
        heapq.heappop(space)
        heapq.heappush(space, lst[i][1])

print(len(space))