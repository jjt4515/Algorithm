#11/12
#
#백준 1011번 램프: https://www.acmicpc.net/problem/1011
#접근방법:

from sys import stdin
n = int(stdin.readline())
for _ in range(n):
    x, y = map(int, stdin.readline().split())
    a = x 
    b = y
    l = 0
    r = 0 
    cnt = 0
    while True:
        l += 1
        a = a + l
        if a >= b:
             cnt += 1
             break 

        r += 1
        b = b - r 

        if a >= b:
                cnt +=2 
                break
        
        cnt += 2
     
    print(cnt)
        


