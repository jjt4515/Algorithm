from sys import stdin
n,k = map(int, stdin.readline().split())
stack = []
count = 0
idx = 0
num = list(stdin.readline())

for i in range(n):
    idx = i
    while(len(stack) > 0 and stack[-1] < int(num[i]) and count<k):
        stack.pop()
        count += 1
    stack.append(int(num[i]))
  
for i in range(0, n-k):
    print(stack[i],end="")