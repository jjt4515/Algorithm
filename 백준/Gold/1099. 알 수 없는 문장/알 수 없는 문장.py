#5/2
#
#백준 1099번 알 수 없는 문장: https://www.acmicpc.net/problem/1099
#접근방법: 

from sys import stdin 

def check(w1, w2, l):
    cnt = 0
    for i in range(l):
        if w1[i] != w2[i]:
            cnt += 1
    return cnt

sentence = stdin.readline().rstrip()
n = int(stdin.readline())
words = []
for _ in range(n):
    words.append(stdin.readline().rstrip())

dp = [[100]*(len(sentence)+1) for _ in range(len(sentence)+1)]
dp[0][0] = 0


for i in range(1, len(sentence)+1):
    if dp[i-1][0] == 100:
        continue
    for word in words:
        l = len(word)
        if sorted(sentence[i-1:i-1+l]) == sorted(word):
            dp[i][i+l-1] = min(dp[i][i+l-1],dp[i-1][0]+check(sentence[i-1:i-1+l],word,l))
            dp[i+l-1][0] = min(dp[i+l-1][0],dp[i][i+l-1])

if dp[-1][0] != 100: 
    print(dp[-1][0])
else: 
    print(-1)
