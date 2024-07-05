from sys import stdin

# 입력받기
n, d = map(int, stdin.readline().split())
li = [list(map(int,stdin.readline().split())) for _ in range(n)]

# 최단거리담는 그래프 
graph = [i for i in range(d+1)]

for i in range(d+1):
    # 지름길 있으면 최단거리 바꿈
    graph[i] = min(graph[i],graph[i-1]+1)
    for s,e,l in li:
        if i == s and e <= d:
            graph[e] = min(graph[e],graph[i]+l)

print(graph[-1])
