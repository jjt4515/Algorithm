num = int(input())
chk = 0
tmp = {"STRAWBERRY" : 0, "BANANA" : 0, "LIME" : 0, "PLUM": 0}
for i in range(num):
    a, b = map(str, input().split())
    tmp[a] += int(b)
for value in tmp.values():
    if value == 5:
        chk = 1
if chk == 1:
    print("YES")
else:
    print("NO")
