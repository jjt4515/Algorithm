str = input()
dic = {}
for i in str.upper():
    if i not in dic:
        dic[i] = 1
    else:
        dic[i] += 1
max = 0
chk = 0
idx = -1
for i in dic:
    if dic[i] > max:
        max = dic[i]
        idx = i
        chk = 0
    elif dic[i] == max:
        chk = 1
if chk:
    print('?')
else:
    print(idx)