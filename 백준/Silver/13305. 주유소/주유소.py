from sys import stdin 
n = int(stdin.readline())

a = list(map(int, stdin.readline().split()))
b = list(map(int, stdin.readline().split()))

sum = 0
s = b[0]
for i in range(n-1):
    if s > b[i]:
        s = b[i]
    sum += s * a[i]
print(sum)