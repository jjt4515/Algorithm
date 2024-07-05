from sys import stdin  
n = int(stdin.readline())
words = []
for _ in range(n):
    word = stdin.readline().rstrip()
    words.append([len(word), word])
words.sort(reverse=True)
ans = []
for i in range(n):
    flag = 0
    new_word = words[i][1]
    for j in range(len(ans)):
        if ans[j].startswith(new_word):
            flag = 1
            break 
    if flag == 0: 
        ans.append(new_word)
print(len(ans))