#3/12
#
#백준 2084번 차수열: https://www.acmicpc.net/problem/2084
#접근방법: 

from sys import stdin   
import heapq

n = int(stdin.readline())
degree = list(map(int, stdin.readline().split()))

graph = [[0 for _ in range(n)] for _ in range(n)]

if sum(degree) % 2 == 1:
    print(-1)
    exit()

for i in range(n):
    degree[i] = [degree[i], i]


while True:
    degree.sort(reverse=True)
    if degree[0][0] == 0:
        break 
    for i in range(1, n):
        if degree[0][0] == 0:
            break
        if degree[i][0] == 0:
            continue
        if graph[degree[0][1]][degree[i][1]] == 0:
            graph[degree[0][1]][degree[i][1]] = 1
            graph[degree[i][1]][degree[0][1]] = 1
            degree[i][0] -= 1
            degree[0][0] -= 1
        

output = '\n'.join(' '.join(map(str, row)) for row in graph)
print(output)
