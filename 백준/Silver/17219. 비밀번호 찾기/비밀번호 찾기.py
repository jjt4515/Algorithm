n, m = map(int, input().split())
tmp = {}
for i in range(n):
    a, b = map(str, input().split())
    tmp[a] = b
for i in range(m):
    s = input()
    if s in tmp.keys():
        print(tmp[s])


       