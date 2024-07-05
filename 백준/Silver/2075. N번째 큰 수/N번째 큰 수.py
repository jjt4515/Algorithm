import heapq
from sys import stdin

n = int(stdin.readline())
heap = []
for i in range(n):
    line = map(int, stdin.readline().split())
    for num in line:
        if len(heap) < n:
            heapq.heappush(heap, num)
        else:
            if num > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, num)

print(heap[0])