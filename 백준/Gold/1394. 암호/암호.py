from sys import stdin 
s = stdin.readline().rstrip()  # 암호로 사용할 수 있는 문자
mp = {char: i+1 for i, char in enumerate(s)}
m = stdin.readline().rstrip()  # 암호
MOD = 900528
ans = 0
sz = len(m)  # 암호 크기
k = len(s)
for i in range(1, sz):
    ans = (ans + k) % MOD
    k = (k * len(s)) % MOD
k = 1
for i in range(sz-1, -1, -1):
    t = ((mp[m[i]] - mp[s[0]]) % MOD * k) % MOD
    ans = (ans + t) % MOD
    k = (k * len(s)) % MOD
print((ans + 1) % MOD)
