from sys import stdin
node_num = int(stdin.readline())
edge_num = int(stdin.readline())

edge = [[] for _ in range(node_num+1)]
visited = [-1]*(node_num + 1)
for _ in range(edge_num):
    a,b,c = map(int,stdin.readline().split())
    edge[a].append([b,c])
    edge[b].append([a,c])
for e in edge:
    e.sort(key = lambda x: x[1])

idx = 1
cnt = 1 
weight = 0
visited[idx] = 0
while cnt < node_num:
    x = edge[idx].pop(0)
    for i in range(len(edge[x[0]])-1):
        if edge[x[0]][i][0] == idx:
            edge[x[0]].pop(i)

    weight += x[1]
    visited[x[0]] = weight 
    cnt += 1

    min_weight = 10000
    for i in range(node_num+1):
        if visited[i] != -1:
            while edge[i] and visited[edge[i][0][0]] != -1:
                edge[i].pop(0)
            if edge[i] and min_weight > edge[i][0][1]:
                idx = i
                min_weight = edge[i][0][1]
                
print(max(visited))


