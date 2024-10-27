# 2024/10/27
# 
# 백준 1753번 최단경로: https://www.acmicpc.net/problem/1753
# 접근 방법: 최단경로 문제이므로 다익스트라 알고리즘을 적용한다.
# 다익스트라 알고리즘에서는 우선순위 큐를 사용한다.

import heapq
from sys import stdin  

v, e = map(int, stdin.readline().split())
k = int(stdin.readline())

graph = [[] for _ in range(v+1)]
visited = [float('inf')] * (v+1)

for _ in range(e):
    u, v, w = map(int, stdin.readline().split())
    graph[u].append((v,w))

def dijkstra(start):
    pQueue = []
    heapq.heappush(pQueue, (0,start))
    
    while pQueue:
        cost, s = heapq.heappop(pQueue)
 
        if visited[s] <= cost:
            continue

        visited[s] = min(visited[s], cost)

        for v, w in graph[s]:
            if visited[v] > cost+w:
                heapq.heappush(pQueue, (cost+w, v))
        

dijkstra(k)
    
for i in range(1, len(visited)):
    if visited[i] == float('inf'):
        print("INF")
    else:
        print(visited[i])
    