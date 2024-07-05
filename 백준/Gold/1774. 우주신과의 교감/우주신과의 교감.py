# 10/1 
# 다익스트라 알고리즘
#백준 1774번 램프: https://www.acmicpc.net/problem/1774
#접근방법: 통로의 길이들이 합이 최소가 되게 하는 문제이므로 
#다익스트라 알고리즘을 이용하여 최소신장트리를 만드는 문제임을 파악하였다.
#각 노드사이의 거리를 모두 구하고 그래프를 만들어 거리에 대해 오름차순으로
#정렬한 뒤 순서대로 연결시켜주었다. 이 과정에서 이미 서로 연결되어 있는 노드들은 제외하였다.

from sys import stdin

def find(x):
    if root[x] == x:
        return x 
    else:
        return find(root[x])

def union(x, y):
    x = find(x)
    y = find(y)

    root[max(x,y)] = min(x,y)

def check(a,b):
    return find(a) == find(b)

def dist(a,b):
    return ((a[0] - b[0])**2 + (a[1] - b[1])**2) ** (1/2)

n,m = map(int,stdin.readline().split())
coordinate = []
graph = []
root = [i for i in range(n)]
res = 0
for _ in range(n):
    x, y = map(int,stdin.readline().split())
    coordinate.append((x,y))

for _ in range(m):
    a, b = map(int,stdin.readline().split())
    union(a-1,b-1)

for i in range(n):
    for j in range(n):
        graph.append((i,j,dist(coordinate[i],coordinate[j])))

graph.sort(key=lambda x:x[2])
for i in graph:
    if not check(i[0],i[1]):
        union(i[0],i[1])
        res += i[2]
print('%.2f' %(res))