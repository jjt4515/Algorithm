#9/14
#
#백준 14500번 테트로미노: https://www.acmicpc.net/problem/14500
#접근방법:
from sys import stdin 

def dfs(i, j, total,size):
    global ans
    if size == 4:
        ans = max(ans, total)
        return

    for mi, mj in moves:
        ni, nj = i + mi, j + mj

        if 0<= ni < n and 0<= nj < m and not visited[ni][nj]:
            
            if size == 2:
                visited[ni][nj] = True
                dfs(i, j, total+board[ni][nj],size+1)
                visited[ni][nj] = False

            visited[ni][nj] = True
            dfs(ni, nj, total+board[ni][nj],size+1)
            visited[ni][nj] = False


moves=[[-1,0],[0,1],[1,0],[0,-1]]

n,m = map(int, input().split())
visited=[[False for _ in range(m)] for _ in range(n)]
board=[]
for _ in range(n):
    board.append(list(map(int, input().split())))
ans=0
for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i,j,board[i][j],1)
        visited[i][j] = False
print(ans)

