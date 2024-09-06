from heapq import heappush, heappop

def dijkstra(start, end):
    distance = [float('inf')]*(n+1)
    distance[start] = 0
    q = [[0,start]]
    while q:
        d, v = heappop(q)
        if d > distance[v]:
            continue
        for next, dis in lst[v]:
                if distance[next] > distance[v] + dis:
                     distance[next] = distance[v] + dis
                     heappush(q, [distance[next], next])

    return distance[end]

ans = float('inf')
     
n, e = map(int, input().split())

lst = [[] for _ in range(n+1)]

for _ in range(e):
    v1, v2, dis = map(int,input().split())
    lst[v1].append([v2, dis])
    lst[v2].append([v1, dis])
    
v1, v2 = map(int, input().split())


path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n)
path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n)


if path1 >= float('inf') and path2 >= float('inf'):
    print(-1)
else:
     print(min(path1, path2))
    