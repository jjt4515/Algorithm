#4/4
#소수판정
#백준 1843번 방정식: https://www.acmicpc.net/problem/1843
#접근방법: 

import math
n = int(input())
i = 1
ans = 0
while True:
    a = n - 2*i
    if a <= 0:
        break
    ans += a
    i += 1
print(ans)

def is_prime(num):
    for k in range(2, int(math.sqrt(num)) + 1):
        if num % k == 0:
            return False
    return True

mans = 0
pans = 0

lst = [0 for _ in range(n+1)]
lst[1] = 1

measure = [1]
primes=[]
for i in range(2, n+1):
    if n % i == 0:
       measure.append(i)
       lst[i] = 1
       if is_prime(i):
            primes.append(i)
            lst[i] = 3
    elif is_prime(i):
       primes.append(i)
       lst[i] = 2

mlen = len(measure)
plen = len(primes)

for i in range(mlen):
    for j in range(i, mlen):
        m = measure[i] + measure[j]
        if m <= n and lst[m] == 1 or m <= n and lst[m] == 3:
            mans += 1
print(mans)
 
for i in range(plen):
    for j in range(i, plen):
        p = primes[i] + primes[j]
        if p <= n and lst[p] == 2 or p <= n and lst[p] == 3:
            pans += 1
print(pans)

            
            