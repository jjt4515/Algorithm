import sys
n = int(sys.stdin.readline())
stack = []
count = 0
for i in range(n):
    stack.append(int(sys.stdin.readline()))

max = 0
for i in range(len(stack) - 1, -1, -1):
    if stack[i] > max:
        count += 1
        max = stack[i]

print(count)