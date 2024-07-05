#백트래킹과 dfs로 풀었는데, combination 써도됨
from sys import stdin       

n,k = map(int, stdin.readline().split())

if k < 5:
    print(0)
    exit()


words = [set(stdin.readline().rstrip()) for _ in range(n)]
learns = [0] * 26
answer = 0

for w in "acint":
    learns[ord(w) - ord('a')] = 1

def dfs(idx, dep):

    global answer #외부 전역변수 answer을 가리킴

    if dep == k - 5:
        cnt = 0
        for word in words:
            flag = 1
            for w in word:
                if not learns[ord(w) - ord('a')]:
                    flag = 0
                    break
            if flag:
                cnt += 1
        answer = max(answer, cnt)
        return 

    for i in range(idx, 26):
        if not learns[i]:
            learns[i] = 1
            dfs(i, dep + 1)
            learns[i] = 0
        
dfs(0, 0)
print(answer)

        

        